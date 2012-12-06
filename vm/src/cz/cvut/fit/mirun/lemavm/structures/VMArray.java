package cz.cvut.fit.mirun.lemavm.structures;

import java.lang.reflect.Array;

import cz.cvut.fit.mirun.lemavm.core.memory.VMMemoryManager;
import cz.cvut.fit.mirun.lemavm.exceptions.VMArrayIndexOutOfBoundsException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMFile;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMClass;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMClassInstance;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;

public final class VMArray<T> extends VMObject {

	private final T[] array;
	private final String typeName;

	public VMArray(T[] array, String typeName) {
		super(ObjectType.ARRAY);
		this.array = array;
		this.typeName = typeName;
		VMMemoryManager.allocateObject(this);
	}

	public String getElementTypeName() {
		return typeName;
	}

	public T[] getAll() {
		return array;
	}

	/**
	 * Get value at the specified index.
	 * 
	 * @param index
	 *            Index into the array
	 * @return Value at the specified index
	 * @throws VMArrayIndexOutOfBoundsException
	 */
	public T get(int index) {
		checkIndex(index);
		return array[index];
	}

	/**
	 * Set value at the specified index.
	 * 
	 * @param index
	 *            Index into the array
	 * @param value
	 *            The value to set
	 * @throws VMArrayIndexOutOfBoundsException
	 * @throws VMEvaluationException
	 */
	public void set(int index, Object value) {
		checkIndex(index);
		checkType(value);
		this.array[index] = (T) value;
	}

	public int getLength() {
		return array.length;
	}

	/**
	 * Concatenate this array with the specified one. </p>
	 * 
	 * A new array is created and returned. The three array thus do not share
	 * anything.
	 * 
	 * @param other
	 *            The array to concatenate this array with
	 * @return New array containing elements from both arrays
	 */
	public VMArray<T> concat(VMArray<T> other) {
		checkType(other.get(0));
		int totalLen = array.length + other.getLength();
		@SuppressWarnings("unchecked")
		T[] all = (T[]) Array.newInstance(array.getClass().getComponentType()
				.getComponentType(), totalLen);
		System.arraycopy(array, 0, all, 0, array.length);
		System.arraycopy(other.array, 0, all, array.length, other.getLength());
		return new VMArray<T>(all, typeName);
	}

	/**
	 * Clone this array.
	 */
	@Override
	public VMArray<T> clone() {
		@SuppressWarnings("unchecked")
		T[] newArr = (T[]) Array.newInstance(array.getClass()
				.getComponentType().getComponentType(), array.length);
		System.arraycopy(array, 0, newArr, 0, array.length);
		return new VMArray<T>(newArr, typeName);
	}

	private void checkIndex(int index) {
		if (index < 0 || index >= array.length) {
			throw new VMArrayIndexOutOfBoundsException("Index value " + index
					+ " is out of array bounds.");
		}
	}

	private void checkType(Object value) {
		if (value instanceof VMClassInstance) {
			final VMClass cls = ((VMClassInstance) value).getVMClass();
			if (!(VMClass.getClasses().get(typeName)).isAssignableFrom(cls)) {
				throw new VMEvaluationException("Incompatible types. Expected "
						+ typeName + " but got " + cls.getName());
			}
		} else {
			if (value instanceof Boolean
					&& !typeName.equals(VMConstants.BOOLEAN)) {
				throw new VMEvaluationException("Incompatible types. Expected "
						+ typeName + " but got " + value.getClass().getName());
			} else if (typeName.equals(VMConstants.DOUBLE)
					&& !(value instanceof Number)) {
				throw new VMEvaluationException("Incompatible types. Expected "
						+ typeName + " but got " + value.getClass().getName());
			} else if (typeName.equals(VMConstants.LONG)
					&& !(value instanceof Long || value instanceof Integer || value instanceof Short)) {
				throw new VMEvaluationException("Incompatible types. Expected "
						+ typeName + " but got " + value.getClass().getName());
			} else if (typeName.equals(VMConstants.INT)
					&& !(value instanceof Integer || value instanceof Short)) {
				throw new VMEvaluationException("Incompatible types. Expected "
						+ typeName + " but got " + value.getClass().getName());
			} else if (typeName.equals(VMConstants.SHORT)
					&& !(value instanceof Short)) {
				throw new VMEvaluationException("Incompatible types. Expected "
						+ typeName + " but got " + value.getClass().getName());
			} else if (typeName.equals(VMConstants.STRING)
					&& !(value instanceof VMString)) {
				throw new VMEvaluationException("Incompatible types. Expected "
						+ typeName + " but got " + value.getClass().getName());
			} else if (typeName.equals(ObjectType.FILE.toString())
					&& !(value instanceof VMFile)) {
				throw new VMEvaluationException("Incompatible types. Expected "
						+ typeName + " but got " + value.getClass().getName());
			}
		}
	}
}
