// Implements a singly-linked list.


public class SinglyLinkedList<E> {
	private ListNode<E> head;
	private ListNode<E> tail;
	private int nodeCount;

	// Constructor: creates an empty list
	public SinglyLinkedList() {
		head = null;
		tail = null;
		nodeCount = 0;
	}

	// Constructor: creates a list that contains
	// all elements from the array values, in the same order
	@SuppressWarnings("unchecked")
	public SinglyLinkedList(Object[] values) {
		if (values.length == 0) {
			
		} else if (values.length == 1) {
			head.setValue((E) values[0]);
			tail.setValue((E) values[0]);
			nodeCount = 1;
		} else {
			
			head.setValue((E) values[0]);
			tail.setValue((E) values[values.length - 1]); // maybe set equal to 0?
			int counter = 0;
			ListNode<E> nextNode;
			//ListNode<E> nextNode = new ListNode<E>((E) values[1], head.getNext());
			for (ListNode<E> i = head; nodeCount != values.length; i = i.getNext()) {
				//E arrayValue = (E) values[counter];
				nextNode = new ListNode<E>((E) values[counter + 1]);
				i.setNext(nextNode);
				//i.setValue(arrayValue);
				counter++;
				nodeCount++;
			}
		}
		

	}
	
	public ListNode<E> getHead() {
		return head;
	}
	
	public ListNode<E> getTail() {
		return tail;
	}

	// Returns true if this list is empty; otherwise returns false.
	public boolean isEmpty() {
		if (nodeCount == 0) {
			return true;
		} else {
			return false;
		}
	}

	// Returns the number of elements in this list.
	public int size() {
		return nodeCount;
	}

	// Returns true if this list contains an element equal to obj;
	// otherwise returns false.
	public boolean contains(E obj) {
		for (ListNode<E> i = head; i == tail; i.getNext()) {
			if (this.get(i).getValue().equals(obj)) {
				return true;
			}
		}

		return false;
	}

	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(E obj) {
	}

	// Adds obj to this collection.  Returns true if successful;
	// otherwise returns false.
	public boolean add(E obj) {
		ListNode<E> newNode = new ListNode<E>(obj);
		if (nodeCount == 0) {
			this.head = newNode;
			this.tail = newNode;
		} else {

		}
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(E obj) {
		
	}

	// Returns the i-th element.               
	public E get(int i) {
		for (int j = 0; j < nodeCount; j++) {
			
		}
	}

	// Replaces the i-th element with obj and returns the old value.
	public E set(int i, Object obj) {
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, Object obj) {
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public E remove(int i) {
		
	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {


	}
	

}
