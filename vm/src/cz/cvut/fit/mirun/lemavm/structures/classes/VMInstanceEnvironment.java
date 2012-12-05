package cz.cvut.fit.mirun.lemavm.structures.classes;

import java.util.Collection;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMNull;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;
import cz.cvut.fit.mirun.lemavm.utils.VMUtils;

public class VMInstanceEnvironment extends VMEnvironment {

//	private final VMClassInstance owner;

	private final VMEnvironment classEnvironment;

	// TODO Do visibility checking

	public VMInstanceEnvironment(VMClassInstance owner) {
		super(owner);
		this.classEnvironment = owner.getVMClass().getClassEnvironment();
		init();
	}

	public VMInstanceEnvironment(VMEnvironment parent, VMClassInstance owner) {
		super(parent, owner);
		this.classEnvironment = owner.getVMClass().getClassEnvironment();
		init();
	}

	public VMObject getOwner() {
		return owner;
	}

	@Override
	public <T> T getBinding(String name, Class<T> cls) {
		if (name.equals(VMConstants.THIS)) {
			if (!cls.equals(VMObject.class)) {
				throw new VMEvaluationException(
						"The this keyword can be used only on VMObject instances.");
			}
			return cls.cast(owner);
		} else {
			T res = super.getBinding(name, cls);
			if (res == null) {
				// Try looking into static fields
				res = classEnvironment.getBinding(name, cls);
			}
			return res;
		}
	}

	@Override
	public void addBinding(String name, VMObject value, String type) {
		if (!containsBinding(name) && classEnvironment.containsBinding(name)) {
			classEnvironment.addBinding(name, value, type);
		} else if (!containsBinding(name)) {
			throw new VMEvaluationException("Field with the name " + name
					+ " not found in type " + owner.getTypeName());
		}
		super.addBinding(name, value, type);
	}

	@Override
	public void addPrimitiveBinding(String name, Object value, String type) {
		if (!containsBinding(name) && classEnvironment.containsBinding(name)) {
			classEnvironment.addPrimitiveBinding(name, value, type);
		} else if (!containsBinding(name)) {
			throw new VMEvaluationException("Field with the name " + name
					+ " not found in type " + owner.getTypeName());
		}
		super.addPrimitiveBinding(name, value, type);
	}

	/**
	 * Initialize this environment with default field values as defined by the
	 * owner's class.
	 */
	private void init() {
		final VMClass cls = owner.getVMClass();
		final Collection<VMField> fields = cls.getFields().values();
		for (VMField f : fields) {
			if (VMUtils.isTypePrimitive(f.getType())) {
				if (f.getVal() != null) {
					addPrimitiveBinding(f.getName(), f.getVal(), f.getType());
				} else {
					addPrimitiveBinding(f.getName(),
							VMUtils.getTypeDefaultValue(f.getType()),
							f.getType());
				}
			} else {
				if (f.getVal() != null) {
					addBinding(f.getName(), (VMObject) f.getVal(), f.getType());
				} else {
					addBinding(f.getName(), VMNull.getInstance(), f.getType());
				}
			}
		}
	}
}
