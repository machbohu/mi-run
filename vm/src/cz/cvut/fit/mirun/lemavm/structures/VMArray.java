package cz.cvut.fit.mirun.lemavm.structures;

import java.lang.reflect.Array;

import cz.cvut.fit.mirun.lemavm.core.VMMemoryManager;
import cz.cvut.fit.mirun.lemavm.exceptions.VMArrayIndexOutOfBoundsException;

public final class VMArray<T> extends VMObject {

	private final T[] array;

	public VMArray(T[] array) {
		super(ObjectType.ARRAY);
		this.array = array;
		VMMemoryManager.allocateObject(this);
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
	 */
	public void set(int index, T value) {
		checkIndex(index);
		this.array[index] = value;
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
		int totalLen = array.length + other.getLength();
		@SuppressWarnings("unchecked")
		T[] all = (T[]) Array.newInstance(array.getClass().getComponentType()
				.getComponentType(), totalLen);
		System.arraycopy(array, 0, all, 0, array.length);
		System.arraycopy(other.array, 0, all, array.length, other.getLength());
		return new VMArray<T>(all);
	}

	/**
	 * Clone this array.
	 */
	public VMArray<T> clone() {
		@SuppressWarnings("unchecked")
		T[] newArr = (T[]) Array.newInstance(array.getClass()
				.getComponentType().getComponentType(), array.length);
		System.arraycopy(array, 0, newArr, 0, array.length);
		return new VMArray<T>(newArr);
	}

	private void checkIndex(int index) {
		if (index < 0 || index >= array.length) {
			throw new VMArrayIndexOutOfBoundsException("Index value " + index
					+ " is out of array bounds.");
		}
	}
}
