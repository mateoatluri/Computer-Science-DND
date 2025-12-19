import java.util.Arrays;

public class SortedArrayList<E extends Comparable<E>> extends MyArrayList<E>{

	
	@Override
	public boolean contains(E obj) {
		int index = Arrays.binarySearch(super.internalArray, 0, objectCount, obj);
		if (index != -1) {
			return true;
		} else {
			return false;
		}
	}
	
	//May not contain more than one of the same object
	@Override
	public boolean add(E obj) {
		if (super.contains(obj) == true) {
			return false;
		}
		int binaryIndex = Arrays.binarySearch(super.internalArray, 0, objectCount, obj);
		int realIndex = (binaryIndex * -1) - 1;
		super.add(realIndex, obj);
		return true;

	}
	
	@Override
	public boolean remove(E obj) {
		if (this.contains(obj) == false) {
			return false;
		}

		int binaryIndex = Arrays.binarySearch(super.internalArray, 0, objectCount, obj);
		super.remove(binaryIndex);
		return true;
	}
	
	public E min() {
		return super.get(0);
	}
	
	public E max() {
		return super.get(objectCount - 1);
	}
}
