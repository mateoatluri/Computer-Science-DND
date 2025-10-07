import java.lang.StringBuilder;

public class DoublyLinkedList {
	// Implements a circular doubly-linked list.

	private final ListNode2<Nucleotide> SENTINEL = new ListNode2<Nucleotide>(null);
	private int nodeCount;

	// Constructor: creates an empty list
	public DoublyLinkedList() {
		SENTINEL.setNext(SENTINEL);
		SENTINEL.setPrevious(SENTINEL);
		nodeCount = 0;
	}

	// Constructor: creates a list that contains
	// all elements from the array values, in the same order
	public DoublyLinkedList(Nucleotide[] values) {
		SENTINEL.setNext(SENTINEL);
		SENTINEL.setPrevious(SENTINEL);
		for (int i = 0; i < values.length; i++) {
			this.add(values[i]);
		}
		nodeCount = values.length;
	}
	
	public ListNode2<Nucleotide> getSentinel() {
		return SENTINEL;
	}
	
	public ListNode2<Nucleotide> getHead() {
		return SENTINEL.getNext();
	}
	
	public ListNode2<Nucleotide> getTail() {
		return SENTINEL.getPrevious();
	}


	// Returns true if this list is empty; otherwise returns false.
	public boolean isEmpty() {
		if (nodeCount > 0) {
			return false;
		} else {
			return true;
		}
	}

	// Returns the number of elements in this list.
	public int size() {
		return nodeCount;
	}

	// Returns true if this list contains an element equal to obj;
	// otherwise returns false.
	public boolean contains(Nucleotide obj) {
		if (nodeCount == 0) {
			return false;
		}

		//starts with sentinel.getNext bc we don't wanna start with sentinel
		for (ListNode2<Nucleotide> currentNode = SENTINEL.getNext(); currentNode != SENTINEL; currentNode = currentNode.getNext()) {
			if (currentNode.getValue().equals(obj)) {
				return true;
			}
		}

		return false;
	}

	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(Nucleotide obj) {
		int indexCounter = 0;
		if (obj == null) {
			throw new NullPointerException();
		}

		for (ListNode2<Nucleotide> currentNode = SENTINEL.getNext(); currentNode != SENTINEL; currentNode = currentNode.getNext()) {
			if (currentNode.getValue().equals(obj)) {
				return indexCounter;
			}
			indexCounter++;
		}
		return -1;
	}

	// Adds obj to this collection.  Returns true if successful;
	// otherwise returns false.
	public boolean add(Nucleotide obj) {
		if (obj == null) {
			throw new NullPointerException();
		}
		
		ListNode2<Nucleotide> newNode = new ListNode2<Nucleotide>(obj, SENTINEL.getPrevious(), SENTINEL);
		
		ListNode2<Nucleotide> previous = SENTINEL.getPrevious();
		previous.setNext(newNode);
		SENTINEL.setPrevious(newNode);


		nodeCount++;
		return true;
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(Nucleotide obj) {
		int index = indexOf(obj);
		
		if (index == -1) {
			return false;
		}

		ListNode2<Nucleotide> removedNode = getNode(index);

		removedNode.getPrevious().setNext(removedNode.getNext());
		removedNode.getNext().setPrevious(removedNode.getPrevious());

		nodeCount--;
		return true;

	}

	// Returns the i-th element.               
	public Nucleotide get(int i) {
		if (i < 0 || i >= nodeCount) {
			throw new IndexOutOfBoundsException();
		}

		ListNode2<Nucleotide> currentNode = SENTINEL.getNext();
		for (int j = 0; j < i; j++) {
			currentNode = currentNode.getNext();
		}

		return currentNode.getValue();

	}

	public ListNode2<Nucleotide> getNode(int i) {
		if (i < 0 || i >= nodeCount) {
			throw new IndexOutOfBoundsException();
		}

		ListNode2<Nucleotide> currentNode = SENTINEL.getNext();
		for (int j = 0; j < i; j++) {
			currentNode = currentNode.getNext();
		}

		return currentNode;

	}

	// Replaces the i-th element with obj and returns the old value.
	public Nucleotide set(int i, Nucleotide obj) {
		if (i < 0 || i >= nodeCount) {
			throw new IndexOutOfBoundsException();
		}

		if (obj == null) {
			throw new NullPointerException();
		}

		ListNode2<Nucleotide> currentNode = getNode(i);
		Nucleotide oldValue = currentNode.getValue();
		currentNode.setValue(obj);

		return oldValue;

	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, Nucleotide obj) {
		if (i < 0 || i > nodeCount) {
			throw new IndexOutOfBoundsException();
		}

		ListNode2<Nucleotide> insertedNode = new ListNode2<Nucleotide>(obj);
		if (nodeCount == 0) {
			insertedNode.setNext(SENTINEL);
			insertedNode.setPrevious(SENTINEL);
			SENTINEL.setNext(insertedNode);
			SENTINEL.setPrevious(insertedNode);
		} else if (i == 0) {
			insertedNode.setNext(SENTINEL.getNext());
			SENTINEL.getNext().setPrevious(insertedNode);
			insertedNode.setPrevious(SENTINEL);
			SENTINEL.setNext(insertedNode);
		}
		else if (i == nodeCount) {
			insertedNode.setPrevious(SENTINEL.getPrevious());
			SENTINEL.getPrevious().setNext(insertedNode);
			insertedNode.setNext(SENTINEL);
			SENTINEL.setPrevious(insertedNode);
		} else {
			ListNode2<Nucleotide> previous = getNode(i - 1);
			insertedNode.setPrevious(previous);
			insertedNode.setNext(previous.getNext());
			previous.setNext(insertedNode);
			insertedNode.getNext().setPrevious(insertedNode);
		}

		nodeCount++;
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public Nucleotide remove(int i) {
		if (i < 0 || i >= nodeCount) {
			throw new IndexOutOfBoundsException();
		}

		ListNode2<Nucleotide> removedNode = getNode(i);
		Nucleotide value = get(i);

		if (nodeCount == 1) {
			SENTINEL.setNext(SENTINEL);
			SENTINEL.setPrevious(SENTINEL);
		}

		removedNode.getPrevious().setNext(removedNode.getNext());
		removedNode.getNext().setPrevious(removedNode.getPrevious());

		nodeCount--;
		return value;
	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {
		if (nodeCount == 0) {
			return "";
		}

		StringBuilder newString = new StringBuilder();
		newString.append("[");


		for (ListNode2<Nucleotide> currentNode = SENTINEL.getNext(); currentNode.getNext() != SENTINEL; currentNode = currentNode.getNext()) {


			if (currentNode == null || currentNode.getValue() == null) {
				newString.append("null, ");
			} else {
				newString.append(currentNode.getValue() + ", ");
			}
		}

		ListNode2<Nucleotide> endNode = SENTINEL.getPrevious();
		if (endNode == null || endNode.getValue() == null) {
			newString.append("null]");
		} else {
			newString.append(endNode.getValue() + "]");
		}

		return newString.toString();
	}
	
	// Like question 7 on the SinglyLinkedList test:
	// Add a "segment" (another list) onto the end of this list
	public void addSegmentToEnd(DoublyLinkedList seg) {
		if (seg.size() != 0) {
			seg.getSentinel().getNext().setPrevious(SENTINEL.getPrevious());
			SENTINEL.getPrevious().setNext(seg.getSentinel().getNext());
			seg.getSentinel().getPrevious().setNext(SENTINEL);
			SENTINEL.setPrevious(seg.getSentinel().getPrevious());
		}

		nodeCount = nodeCount + (seg.size());

	}
	
	// Like question 8 on the SinglyLinkedList test:
	// You are to remove the next 16 nodes from the list, after the node nodeBefore.
	// (on the test these nodes were assumed to contain CCCCCCCCGGGGGGGG, but here
	// you do not need to assume or check for that)
	public void removeCCCCCCCCGGGGGGGG(ListNode2<Nucleotide> nodeBefore) {
		
		ListNode2<Nucleotide> nextNode = nodeBefore.getNext();
		for (int i = 0; i < 16; i++) {
			if (nextNode != SENTINEL) {
				nextNode = nextNode.getNext();
			} else {
				throw new IllegalArgumentException("Not 16 Nodes to Remove");
			}
		}

		nodeCount = nodeCount - 16;
		nodeBefore.setNext(nextNode);
		nextNode.setPrevious(nodeBefore);
	}
	
	// Like question 9 on the SinglyLinkedList test:
	// You are to find and delete the first instance of seg in the list.
	// If seg is not in the list, return false, otherwise return true.
	
	// THIS DOES NOT WORK... FIX
	public boolean deleteSegment(DoublyLinkedList seg) {
		int segLength = seg.size();
		int index = 0;
		int counter = 0;

		for (ListNode2<Nucleotide> currentNode = SENTINEL.getNext(); currentNode != getNode(nodeCount - segLength); currentNode = currentNode.getNext()) {
			ListNode2<Nucleotide> segNode = seg.getSentinel().getNext();
			while (currentNode.getValue().equals(segNode.getValue()) && counter < segLength) {
				currentNode.getNext();
				segNode.getNext();
				counter++;
			}
			for (int i = 0; i < counter; i++) {
				currentNode = currentNode.getPrevious();
			}
			if (counter != segLength) {
				counter = 0;
			}
			if (counter == segLength) {
					currentNode.getPrevious().setNext(getNode(index+counter));
				nodeCount = nodeCount - segLength;
				return true;
			}
			index++;
		}
		return false;
	}
	
	// Like question 10 on the SinglyLinkedList test:
	// Delete the last three nodes in the list
	// If there are not enough nodes, return false
	
	
	public boolean deleteLastThree() {
		if (nodeCount < 3) {
			return false;
		}

		ListNode2<Nucleotide> newLast = SENTINEL.getPrevious().getPrevious().getPrevious().getPrevious();
		newLast.setNext(SENTINEL);
		SENTINEL.setPrevious(newLast);
		nodeCount = nodeCount - 3;
		return true;
	}

	// Like question 11 on the SinglyLinkedList test:
	// Replaces every node containing "A" with three nodes containing "T" "A" "C"
	public void replaceEveryAWithTAC() {
		int index = 0;
		for (ListNode2<Nucleotide> currentNode = SENTINEL.getNext(); currentNode != SENTINEL; currentNode = currentNode.getNext()) {
			if (currentNode.getValue() == Nucleotide.A) {
				this.add(index + 1, Nucleotide.C);
				this.add(index, Nucleotide.T);
				index = index + 2;
				nodeCount = nodeCount + 2;
			}
			index++;
		}
	}

}
