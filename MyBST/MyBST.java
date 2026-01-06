// Implements a BST with BinaryNode nodes

import java.lang.StringBuilder;

public class MyBST<E extends Comparable<E>> {
	
	private BinaryNode<E> root;  // holds the root of this BST

	// Constructor: creates an empty BST.
	public MyBST() {
		root = null;
	}

	public BinaryNode<E> getRoot() {
		return root;
	}
	
	public int getHeight() {
		return root.getHeight();
	}

	// Returns true if this BST contains value; otherwise returns false.
	public boolean contains(E value) {
		return false;
	}

	public boolean containsHelper(E value, BinaryNode<E> currentPos) {
		if (value.compareTo(currentPos.getValue()) == 0) {
			return true;
		} else if (value.compareTo(currentPos.getValue()) > 0) {
			if (currentPos.hasRight()) {
				containsHelper(value, currentPos.getRight());
			} else {
				return false;
			}
		} else {
			if (currentPos.hasLeft()) {
				containsHelper(value, currentPos.getLeft());
			} else {
				return false;
			}
		}

		System.out.println("This didn't work if you see this.");
		return false;
	}

	// Adds value to this BST, unless this tree already holds value.
	// Returns true if value has been added; otherwise returns false.
	public boolean add(E value) {
		return addHelper(value, root);
	}

	public boolean addHelper(E value, BinaryNode<E> currentPos) {
		if (root == null) {
			root = new BinaryNode<E>(value);
			return true;
		}

		if (value.compareTo(currentPos.getValue()) == 0) {
			return false;
		} else if (value.compareTo(currentPos.getValue()) > 0) {
			if (currentPos.hasRight()) {
				addHelper(value, currentPos.getRight());
			} else {
				BinaryNode<E> newNode = new BinaryNode<E>(value);
				currentPos.setRight(newNode);
				return true;
			}
		} else {
			if (currentPos.hasLeft()) {
				addHelper(value, currentPos.getLeft());
			} else {
				BinaryNode<E> newNode = new BinaryNode<E>(value);
				currentPos.setLeft(newNode);
				return true;
			}
		}

		System.out.println("This didn't work if you see this.");
		return false;
	}

	// Removes value from this BST.  Returns true if value has been
	// found and removed; otherwise returns false.
	// If removing a node with two children: replace it with the
	//  largest node in the right subtree
	public boolean remove(E value) {
		return false;
	}
	
	// Returns the minimum in the tree
	public E min() {
		BinaryNode<E> currentNode = root;
		while (currentNode.hasLeft()) {
			currentNode = currentNode.getLeft();
		}

		return currentNode.getValue();
	}
	
	// Returns the maximum in the tree.
	public E max() {
		BinaryNode<E> currentNode = root;
		while (currentNode.hasRight()) {
			currentNode = currentNode.getRight();
		}

		return currentNode.getValue();
	}

	// Returns a bracket-surrounded, comma separated list of the contents of the nodes, in order
	// e.g. [Apple, Cranberry, Durian, Mango]
	public String toString() {
		StringBuilder currentString = new StringBuilder("[");
		currentString = toStringHelper(root, currentString);
		currentString.append("]");
		return currentString.toString();


	}

	public StringBuilder toStringHelper(BinaryNode<E> currentPos, StringBuilder currentString) {
		if (currentPos.getValue().compareTo(min()) == 0) {
			currentString.append(currentPos.getValue());
		} else {
			if (currentPos.hasLeft()) {
				toStringHelper(currentPos.getLeft(), currentString);
			}
			currentString.append(", " + currentPos.getValue());
			
			if (currentPos.hasRight()) {
				toStringHelper(currentPos.getRight(), currentString);
			}
		}
		return currentString;
	}

}
