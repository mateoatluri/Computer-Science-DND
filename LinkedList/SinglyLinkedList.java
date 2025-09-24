// Implements a singly-linked list.

import java.lang.StringBuilder;

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
			head = null;
		tail = null;
		nodeCount = 0;
		}
		else if (values.length == 1) {
			ListNode<E> newNode = new ListNode<E>((E) values[0]);
			nodeCount = 1;
			head = newNode;
			tail = newNode;
		} else {
			
			// head.setValue((E) values[0]);
			// tail.setValue((E) values[values.length - 1]); // maybe set equal to 0?
			int counter = 0;
			ListNode<E> headNode = new ListNode<E>((E) values[0]);
			head = headNode;
			ListNode<E> tailNode = new ListNode<E>((E) values[values.length - 1]);
			tail = tailNode;
			//ListNode<E> nextNode = new ListNode<E>((E) values[1], head.getNext());
			for (ListNode<E> i = head; head != tail; i = i.getNext()) {

				ListNode<E> nextNode = new ListNode<E>((E) values[counter + 1]);
				i.setNext(nextNode);
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
		for (ListNode<E> i = head; i != tail; i = i.getNext()) {
			if (i.getValue().equals(obj)) {
				return true;
			}
		}

		return false;
	}

	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(E obj) {
		int counter = 0;
		for (ListNode<E> i = head; counter < nodeCount; i = i.getNext()) {
			if (i.getValue().equals(obj)) {
				return counter;
			} else {
				counter++;
			}
		}
		return -1;
	}

	// Adds obj to this collection.  Returns true if successful;
	// otherwise returns false.
	public boolean add(E obj) {
		ListNode<E> newNode = new ListNode<E>(obj);
		if (nodeCount == 0) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			tail.setNext(newNode);
			this.tail = newNode;
		}
		return false;
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(E obj) {
		int counter = 0;
		if (((E) head.getValue()).equals(obj)) {
			head = head.getNext();
			nodeCount--;
			return true;
		}
		
		for (ListNode<E> i = head; counter < nodeCount - 1; i = i.getNext()) {
			counter++;
			if (i.getNext().getValue().equals(obj)) {
				if (i.getNext() == tail) {
					i.setNext(null);
					tail = i;
					nodeCount--;
					return true;
				}
				i.setNext(i.getNext().getNext());
				nodeCount--;
				return true;
				}
			counter++;
			} 
			return false;
		}
	

	// Returns the i-th element.               
	public E get(int i) {
		if (i < 0 || i >= nodeCount) {
			throw new IndexOutOfBoundsException();
		}
		

		ListNode<E> node = head;
		for (int counter = 0; counter <= i; counter++) {
			node = node.getNext();
		}
		return node.getValue();
	}

	public ListNode<E> getNode(int i) {
		if (i < 0 || i >= nodeCount) {
			throw new IndexOutOfBoundsException();
		}
		

		ListNode<E> node = head;
		for (int counter = 0; counter <= i; counter++) {
			node = node.getNext();
		}
		return node;
	}

	// Replaces the i-th element with obj and returns the old value.
	// FOR SET YOU CAN CALL GET
	@SuppressWarnings("unchecked")
	public E set(int i, Object obj) {
		if (i < 0 || i >= nodeCount) {
			throw new IndexOutOfBoundsException();
		}

		int counter = 0;
		for (ListNode<E> currentNode = head; counter <= i; currentNode = currentNode.getNext()) {
			if (counter == i) {
				E oldValue = currentNode.getValue();
				currentNode.getValue().equals(obj);
				return oldValue;
			}
		}
		return (E) "If this returns, this method is wrong";

	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	// get the previous, set that previous's next to the new node, then set the new node's next to what the previous node's next was
	@SuppressWarnings("unchecked")
	public void add(int i, Object obj) {
		if (i < 0 || i >= nodeCount) {
			throw new IndexOutOfBoundsException();
		}
		ListNode<E> newNode = new ListNode<E>((E) obj);
		if (i == 0) {
			newNode.setNext(head);
			head = newNode;
		}

		else if (i == nodeCount - 1) {
			tail.setNext(newNode);
			tail = newNode;
		}

		else {
			ListNode<E> previous = this.getNode(i - 1);
			ListNode<E> next = this.getNode(i);
			previous.setNext(newNode);
			newNode.setNext(next);
		}

		nodeCount++;
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	// get the index before and set the next to .next.next
	public E remove(int i) {
		if (i < 0 || i >= nodeCount) {
			throw new IndexOutOfBoundsException();
		}

		if (i == 0) {
			ListNode<E> removed = this.getNode(i);
			this.head = this.getNode(i + 1);
			return removed.getValue();
		}

		if (i == nodeCount - 1) {
			ListNode<E> removed = this.getNode(i);
			tail = this.getNode(i - 1);
			tail.setNext(null);
			return removed.getValue();
		}
			ListNode<E> previous = this.getNode(i - 1);
			ListNode<E> removed = this.getNode(i);
			ListNode<E> next = this.getNode(i + 1);
			previous.setNext(next);

			return removed.getValue();

	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {
		int counter = 0;

		StringBuilder newString = new StringBuilder();
		newString.append("[");

		for (ListNode<E> currentNode = head; counter < nodeCount - 1; currentNode = currentNode.getNext()) {
			if (currentNode.getValue() == null) {
				newString.append("null, ");
			} else {
				newString.append(currentNode.getValue().toString() + ", ");
			}
		}
		
		if (tail.getValue() == null) {
			newString.append("null]");
		} else {
			newString.append(tail.getValue().toString() + "]");
		}

		return newString.toString();
	}
	

}
