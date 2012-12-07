package cz.cvut.fit.mirun.lemavm.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.apache.log4j.Logger;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMMethodNotFoundException;
import cz.cvut.fit.mirun.lemavm.structures.Evaluable;
import cz.cvut.fit.mirun.lemavm.structures.VMArray;
import cz.cvut.fit.mirun.lemavm.structures.VMCodeBlock;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMSystem;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMClass;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMClassInstance;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMMethod;
import cz.cvut.fit.mirun.lemavm.utils.ParsingUtils;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;
import cz.cvut.fit.mirun.lemavm.utils.VMUtils;

public class VMInterpreter {

	private static final Logger LOG = Logger.getLogger(VMInterpreter.class);

	private static final VMInterpreter instance = new VMInterpreter();

	private final Stack<VMEnvironment> stackFrames;
	private VMEnvironment currentEnvironment;

	/** Method in-line cache */
	private VMMethod ilc;
	private VMMethod staticIlc;

	private VMInterpreter() {
		this.stackFrames = new Stack<>();
		// This is the top level environment
		this.currentEnvironment = new VMEnvironment();
	}

	public static VMInterpreter getInstance() {
		return instance;
	}

	/**
	 * Execute the specified code block in the current environment
	 * 
	 * @param block
	 *            The block to execute
	 */
	private void executeCodeBlock(VMCodeBlock block) {
		// TODO There will probably a big switch or if else to execute correct
		// action for node in the block.
		// Maybe a unified evaluate function would help
		for (Object node : block.getCode()) {
			if (currentEnvironment.shouldReturn()) {
				return;
			}
			if (node instanceof Evaluable) {
				final Evaluable e = (Evaluable) node;
				e.evaluate(currentEnvironment);
			}
			// TODO some other types of nodes may come here
			// or exception in case of bad code block part
		}
	}

	/**
	 * Execute this application. </p>
	 * 
	 * This is the main entry point of the interpreter. It gets an array of
	 * arguments that should be passed to the application's main method. The
	 * main method is looked up in all discovered classes and invoked.
	 * 
	 * @param args
	 *            Arguments to pass to the interpreted application's main method
	 */
	public void executeApplication(String[] args) {
		VMMethod main = VMUtils.getMainMethod();

		if (main == null) {
			throw new VMMethodNotFoundException(
					"Cannot find the main method of this application.");
		}

		final Map<String, String> params = main.getArguments();
		final String argsName = params.keySet().iterator().next();
		final VMArray argArr = new VMArray(args, VMConstants.STRING);

		currentEnvironment.addBinding(argsName, argArr, VMConstants.STRING);
		executeCodeBlock(main.getCode());
	}

	public VMEnvironment getCurrentEnvironment() {
		return currentEnvironment;
	}

	/**
	 * Set the current environment. </p>
	 * 
	 * This method pushes the current environment to a stack and sets the
	 * {@code newEnv} as the current environment. </p>
	 * 
	 * NOTE: Do not forget to pop the environment once you're done executing
	 * code with it. Code block execution leaves the environment as it is to
	 * enable return value extraction.
	 * 
	 * @param newEnv
	 *            The environment to use as the current
	 */
	private void setCurrentEnvironment(VMEnvironment newEnv) {
		if (newEnv == null) {
			throw new NullPointerException();
		}
		stackFrames.push(currentEnvironment);
		this.currentEnvironment = newEnv;
	}

	/**
	 * Set top of the stack as current environment (pop it)
	 */
	private void unsetCurrentEnvironment() {
		this.currentEnvironment = stackFrames.pop();
	}

	public void invokeCodeBlock(VMEnvironment newEnv, VMCodeBlock code) {
		setCurrentEnvironment(newEnv);
		executeCodeBlock(code);
		unsetCurrentEnvironment();
	}

	/**
	 * Invoke constructor on the specified new instance. </p>
	 * 
	 * @param instance
	 *            The newly created blank instance (it contains preinitialized
	 *            values)
	 * @param arguments
	 *            List of arguments for the constructor or an empty list, if
	 *            there are no arguments
	 */
	public void invokeConstructor(VMClassInstance instance,
			List<Object> arguments) {
		if (instance == null || arguments == null) {
			throw new NullPointerException();
		}
		if (LOG.isTraceEnabled()) {
			LOG.trace("Invoking constructor for class " + instance.getVMClass());
		}
		final VMMethod ctor = lookupConstructor(instance.getVMClass(),
				arguments);
		final VMEnvironment instEnv = instance.getEnvironment();
		invokeMethodImpl(ctor, instEnv, arguments);
	}

	/**
	 * Invoke method with the specified name on the receiver instance. </p>
	 * 
	 * The method is looked up by its name and argument count and types.
	 * 
	 * @param receiver
	 *            The receiving instance
	 * @param methodName
	 *            Name of the method to invoke
	 * @param arguments
	 *            Arguments to pass to the method
	 * @return The value returned from the invoked method. Null if the method
	 *         did not return anything
	 */
	public Object invokeMethod(VMObject receiver, String methodName,
			List<Object> arguments) {
		if (receiver == null || methodName == null || arguments == null) {
			throw new NullPointerException();
		}
		if (LOG.isTraceEnabled()) {
			LOG.trace("Invoking method named " + methodName + " on instance "
					+ receiver);
		}
		if (VMUtils.isBuiltInType(receiver)) {
			final Object res = invokeNativeMethod(receiver, methodName,
					arguments);
			return res;
		}
		final VMClassInstance inst = (VMClassInstance) receiver;
		final VMMethod m = lookupMethod(inst, methodName, arguments);
		final VMEnvironment instEnv = inst.getEnvironment();
		return invokeMethodImpl(m, instEnv, arguments);
	}

	/**
	 * Invoke static method with the specified name on the receiver class. </p>
	 * 
	 * The method is looked up by its name and argument count and types.
	 * 
	 * @param receiver
	 *            The receiving class
	 * @param methodName
	 *            Name of the method
	 * @param arguments
	 *            Arguments to pass to the method
	 * @return Return value of the invoked method. Null if the method did not
	 *         return anything
	 */
	public Object invokeStaticMethod(VMClass receiver, String methodName,
			List<Object> arguments) {
		if (receiver == null || methodName == null || arguments == null) {
			throw new NullPointerException();
		}
		if (LOG.isTraceEnabled()) {
			LOG.trace("Invoking method named " + methodName + " on instance "
					+ receiver);
		}
		final VMMethod m = lookupStaticMethod(receiver, methodName, arguments);
		final VMEnvironment classEnv = receiver.getClassEnvironment();
		return invokeMethodImpl(m, classEnv, arguments);
	}

	/**
	 * Invoke a native method on the {@code VMSystem} class. </p>
	 * 
	 * @param methodName
	 *            Name of the method to invoke
	 * @param arguments
	 *            Arguments to pass to the method
	 * @return Return value of the method
	 */
	public Object invokeSystemNativeMethod(String methodName,
			List<Object> arguments) {
		if (methodName == null || arguments == null) {
			throw new NullPointerException();
		}
		if (LOG.isTraceEnabled()) {
			LOG.trace("Invoking system native method " + methodName);
		}
		final List<Object> args = resolveArgsForNativeMethod(arguments);
		Object res = null;
		final Method[] methods = VMSystem.class.getDeclaredMethods();
		for (Method m : methods) {
			if (m.getName().equals(methodName)) {
				try {
					res = m.invoke(null, args.toArray());
					return res;
				} catch (IllegalAccessException | IllegalArgumentException e) {
					LOG.error("Unable to invoke method " + methodName, e);
					throw new VMEvaluationException(
							"Unable to invoke system static method "
									+ methodName);
				} catch (InvocationTargetException e) {
					throw new VMEvaluationException(e.getTargetException());
				}
			}
		}
		throw new VMEvaluationException("System native method named "
				+ methodName + " not found.");
	}

	/**
	 * Invoke the specified method. </p>
	 * 
	 * @param method
	 *            The method to invoke
	 * @param parentEnv
	 *            Parent environment for the method
	 * @param args
	 *            List of method arguments
	 * @return Return value of the method or null if there is none
	 */
	private Object invokeMethodImpl(VMMethod method, VMEnvironment parentEnv,
			List<Object> args) {
		final VMEnvironment methodEnv = new VMEnvironment(parentEnv);
		methodEnv.setReturnType(method.getReturnType());

		pushArgsToEnvironment(methodEnv, method.getArguments(), args);
		setCurrentEnvironment(methodEnv);
		executeCodeBlock(method.getCode());

		final Object res = methodEnv.getReturnValue();

		unsetCurrentEnvironment();

		return res;
	}

	/**
	 * Look up constructor by the arguments. </p>
	 * 
	 * @param cls
	 *            Class
	 * @param args
	 *            Arguments
	 * @return Matching constructor
	 * @throws VMMethodNotFoundException
	 */
	private VMMethod lookupConstructor(VMClass cls, List<Object> args) {
		assert cls != null;
		assert args != null;
		final List<String> argTypes = VMUtils.getArgumentTypes(args,
				currentEnvironment);
		for (VMMethod ctor : cls.getDeclaredConstructors()) {
			if (ctor.doesMethodMatch(cls.getName(), argTypes)) {
				return ctor;
			}
		}
		throw new VMMethodNotFoundException("Constructor for class "
				+ cls.getName() + " and argument types " + argTypes
				+ " not found.");
	}

	private VMMethod lookupMethod(VMClassInstance receiver, String methodName,
			List<Object> args) {
		assert receiver != null;
		assert methodName != null;
		assert args != null;
		final List<String> argTypes = VMUtils.getArgumentTypes(args,
				currentEnvironment);
		final VMClass cls = receiver.getVMClass();
		if (ilc != null) {
			if (ilc.getOwner().equals(cls)
					&& ilc.doesMethodMatch(methodName, argTypes)) {
				return ilc;
			}
		}
		List<VMMethod> methods = cls.getMethodsForName(methodName);
		for (VMMethod m : methods) {
			if (m.doesMethodMatch(methodName, argTypes)) {
				this.ilc = m;
				return m;
			}
		}
		throw new VMMethodNotFoundException("Method with name " + methodName
				+ " and parameter types " + argTypes + " not found in type "
				+ cls.getName());
	}

	private VMMethod lookupStaticMethod(VMClass receiver, String methodName,
			List<Object> args) {
		assert receiver != null;
		assert methodName != null;
		assert args != null;
		final List<String> argTypes = VMUtils.getArgumentTypes(args,
				currentEnvironment);
		if (staticIlc != null) {
			if (staticIlc.getOwner().equals(receiver)
					&& staticIlc.doesMethodMatch(methodName, argTypes)) {
				return staticIlc;
			}
		}
		final List<VMMethod> methods = receiver
				.getStaticMethodsForName(methodName);
		for (VMMethod m : methods) {
			if (m.doesMethodMatch(methodName, argTypes)) {
				this.staticIlc = m;
				return m;
			}
		}
		throw new VMMethodNotFoundException("Static method with name "
				+ methodName + " and parameter types " + argTypes
				+ " not found in type " + receiver.getName());
	}

	/**
	 * Push argument values to the specified environment. </p>
	 * 
	 * This method assumes that the parameter map and argument list are the same
	 * size and have correct ordering (in the map by keys).
	 * 
	 * @param target
	 *            Target environment
	 * @param argNamesAndTypes
	 *            Argument names and types. Keyed by names
	 * @param args
	 *            Argument values
	 */
	private void pushArgsToEnvironment(VMEnvironment target,
			Map<String, String> argNamesAndTypes, List<Object> args) {
		assert argNamesAndTypes.size() == args.size();
		final Iterator<String> names = argNamesAndTypes.keySet().iterator();
		int i = 0;
		while (names.hasNext()) {
			final String name = names.next();
			final String type = argNamesAndTypes.get(name);
			Object o = args.get(i);
			if (VMUtils.isTypePrimitive(type)) {
				if (o instanceof String) {
					target.addPrimitiveBinding(name, currentEnvironment
							.getBinding((String) o, Object.class), type);
				} else {
					target.addPrimitiveBinding(name, args.get(i), type);
				}
			} else {
				if (o instanceof String) {
					target.addBinding(name, currentEnvironment.getBinding(
							(String) o, VMObject.class), type);
				} else {
					target.addBinding(name, (VMObject) args.get(i), type);
				}
			}
			i++;
		}
	}

	/**
	 * Invoke native method with the specified parameters. </p>
	 * 
	 * Native methods are invoked directly through the Java Reflection API.
	 * 
	 * @param receiver
	 *            Invocation receiver
	 * @param methodName
	 *            Method name
	 * @param arguments
	 *            Arguments
	 */
	private Object invokeNativeMethod(VMObject receiver, String methodName,
			List<Object> arguments) {
		final List<Object> args = resolveArgsForNativeMethod(arguments);
		Method[] methods = receiver.getClass().getDeclaredMethods();
		for (Method m : methods) {
			if (m.getName().equals(methodName)) {
				try {
					final Object res = m.invoke(receiver, args.toArray());
					return res;
				} catch (IllegalAccessException | IllegalArgumentException e) {
					LOG.error("Unable to invoke method " + methodName, e);
					throw new VMEvaluationException("Unable to invoke method "
							+ methodName + " on instance " + receiver);
				} catch (InvocationTargetException e) {
					throw new VMEvaluationException(e.getTargetException());
				}
			}
		}
		throw new VMEvaluationException("Native method named " + methodName
				+ " not found on receiver " + receiver);
	}

	/**
	 * Resolve arguments for native method call. </p>
	 * 
	 * This has to be done since for standard method call argument values are
	 * pushed to the method's environment. Native methods have no explicit
	 * environment.
	 * 
	 * @param arguments
	 *            The arguments to resolve
	 * @return List of actual arguments
	 */
	private List<Object> resolveArgsForNativeMethod(List<Object> arguments) {
		final List<Object> args = new ArrayList<>(arguments.size());
		for (Object o : arguments) {
			if (o instanceof Evaluable) {
				args.add(((Evaluable) o).evaluate(currentEnvironment));
				continue;
			}
			if (o instanceof String) {
				final String s = (String) o;
				if (s.startsWith("\"")) {
					args.add(new VMString(s.substring(1, s.length() - 1)));
					continue;
				}
				final Boolean b = ParsingUtils.tryParsingBoolean(s);
				if (b != null) {
					args.add(b);
					continue;
				}
				final Number n = ParsingUtils.tryParsingNumber(s);
				if (n != null) {
					args.add(n);
					continue;
				}
				final Object arg = currentEnvironment.getBinding(s,
						Object.class);
				args.add(arg);
				continue;
			} else {
				args.add(o);
			}
		}
		return args;
	}

	/**
	 * Get all tracked environments. </p>
	 * 
	 * This is to be used by the GC.
	 * 
	 * @return Vector of environments
	 */
	public List<VMEnvironment> getEnvironments() {
		List<VMEnvironment> envs = new ArrayList<>(stackFrames);
		envs.add(currentEnvironment);
		return envs;
	}

	/**
	 * Reset VMInterpreter part when reseting Virtual machine
	 */
	public void resetPartVM() {
		stackFrames.clear();
	}
}
