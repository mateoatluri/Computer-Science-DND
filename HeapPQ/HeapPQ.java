
public class HeapPQ<E extends Comparable<E>> implements MyPriorityQueue<E> {

	private E[] heap;
	private int objectCount;

	public HeapPQ()
		{
			this.heap = (E[])new Comparable[3];
			this.objectCount = 0;
		}

	//Returns the number of elements in the priority queue
	public int size()
		{
			return objectCount;
		}

	//DO NOT CHANGE MY JANKY TOSTRING!!!!!
	public String toString()
	{
		StringBuffer stringbuf = new StringBuffer("[");
		for (int i = 0; i < objectCount; i++)
		{
			stringbuf.append(heap[i]);
			if (i < objectCount - 1)
				stringbuf.append(", ");
		}
		stringbuf.append("]\nor alternatively,\n");

		for(int rowLength = 1, j = 0; j < objectCount; rowLength *= 2)
		{
			for (int i = 0; i < rowLength && j < objectCount; i++, j++)
			{
				stringbuf.append(heap[j] + " ");
			}
			stringbuf.append("\n");
			if (j < objectCount)
			{
				for (int i = 0; i < Math.min(objectCount - j, rowLength*2); i++)
				{
					if (i%2 == 0)
						stringbuf.append("/");
					else
						stringbuf.append("\\ ");
				}
				stringbuf.append("\n");
			}
		}
		return stringbuf.toString();
	}

	//Doubles the size of the heap array
	private void increaseCapacity()
	{
		E[] newHeap = (E[])new Comparable[heap.length * 2];
		for (int i = 0; i < heap.length; i++) {
			newHeap[i] = heap[i];
		}
		heap = newHeap;
	}

	//Returns the index of the "parent" of index i
	private int parent(int i)
		{
			if (i == 0) {
				throw new IllegalArgumentException();
			}
			if (i >= objectCount) {
				throw new IllegalArgumentException();
			}
			int number = (i - 1) / 2;
			return number;
		}
	//Returns the index of the *smaller child* of index i
	private int smallerChild(int i)
		{
			if (i >= objectCount) {
				throw new IllegalArgumentException();
			}

			if (i < 0) {
				throw new IllegalArgumentException();
			}

			int firstKidIndex = (2 * i) + 1;
			int secondKidIndex = (2 * i) + 2;


			if (firstKidIndex < objectCount && secondKidIndex < objectCount) {
				if (heap[firstKidIndex] != null && heap[secondKidIndex] != null) {
					if (heap[firstKidIndex].compareTo(heap[secondKidIndex]) > 0) {
						return secondKidIndex;
					} else {
						return firstKidIndex;
					}
				}

				if (heap[firstKidIndex] != null && heap[secondKidIndex] == null) {
					return firstKidIndex;
				} else if (heap[firstKidIndex] == null) {
					return -1;
				}

			}
		
			return -1;

			
		}

		private boolean childExists(int i) {
			
			if (i < 0 || i >= objectCount) {
				throw new IllegalArgumentException();
			}
			
			if (smallerChild(i) < 0 || smallerChild(i) >= objectCount) {
				return false;
			} else {
				return true;
			}
		}

	//Swaps the contents of indices i and j
	private void swap(int i, int j)
	{

		if (i >= objectCount || i < 0 || j >= objectCount || j < 0) {
			throw new IllegalArgumentException();
		} else {
			E value1 = heap[i];
			E value2 = heap[j];
			heap[i] = value1;
			heap[j] = value2;
		}

	}

	// Bubbles the element at index i upwards until the heap properties hold again.
	private void bubbleUp(int i)
	{
		if (i >= objectCount || i < 0) {
			throw new IllegalArgumentException();
		}

		if (i == 0) {
			return;
		}

		int parentIndex = parent(i);
		if (heap[i].compareTo(heap[parentIndex]) < 0) {
			swap(i, parentIndex);
			bubbleUp(parentIndex);
		} else {
			return;
		}

	}

	// Bubbles the element at index i downwards until the heap properties hold again.
	private void bubbleDown(int i)
	{
		if (i >= objectCount || i < 0) {
			throw new IllegalArgumentException();
		}

		if (childExists(i) == false) {
			return;
		}

		int child = smallerChild(i);
		if (heap[i].compareTo(heap[child]) >= 0) {
			swap(i, child);
			bubbleDown(child);
		} else {
			return;
		}

	}

}
