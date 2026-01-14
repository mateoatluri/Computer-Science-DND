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
		if (root == null) {
			return -1;
		}

		return root.getHeight();
	}

	// Returns true if this BST contains value; otherwise returns false.
	public boolean contains(E value) {
		if (root == null) {
			return false;
		}
		
		return containsHelper(value, root);
	}

	public boolean containsHelper(E value, BinaryNode<E> currentPos) {
		if (value.compareTo(currentPos.getValue()) == 0) {
			return true;
		} else if (value.compareTo(currentPos.getValue()) > 0) {
			if (currentPos.hasRight()) {
				return containsHelper(value, currentPos.getRight());
			} else {
				return false;
			}
		} else {
			if (currentPos.hasLeft()) {
				return containsHelper(value, currentPos.getLeft());
			} else {
				return false;
			}
		}

	
	}


	public BinaryNode<E> findNode(E value, BinaryNode<E> currentPos) {
		// if (value.compareTo(currentPos.getValue()) == 0) {
		// 	return currentPos;
		// } 
		if (currentPos == null) {
			return null;
		}
		if (value.compareTo(currentPos.getValue()) == 0) {
			return currentPos;
		} else if (value.compareTo(currentPos.getValue()) > 0) {
			return findNode(value, currentPos.getRight());
		} else {
			return findNode(value, currentPos.getLeft());
		}

	}

	// Adds value to this BST, unless this tree already holds value.
	// Returns true if value has been added; otherwise returns false.
	public boolean add(E value) {
		if (root == null) {
			root = new BinaryNode<E>(value);
			return true;
		}
		
		return addHelper(value, root);
	}

	public boolean addHelper(E value, BinaryNode<E> currentPos) {


		if (value.compareTo(currentPos.getValue()) == 0) {
			return false;
		} else if (value.compareTo(currentPos.getValue()) > 0) {
			if (currentPos.hasRight()) {
				return addHelper(value, currentPos.getRight());
			} else {
				BinaryNode<E> newNode = new BinaryNode<E>(value);
				currentPos.setRight(newNode);
				newNode.setParent(currentPos);
				
				//System.out.println(value);
				
				return true;
			}
		} else {
			if (currentPos.hasLeft()) {
				return addHelper(value, currentPos.getLeft());
			} else {
				BinaryNode<E> newNode = new BinaryNode<E>(value);
				currentPos.setLeft(newNode);
				newNode.setParent(currentPos);

				//System.out.println(value);

				return true;
			}
		}

	}

	// Removes value from this BST.  Returns true if value has been
	// found and removed; otherwise returns false.
	// If removing a node with two children: replace it with the
	//  largest node in the right subtree
	public boolean remove(E value) {
		if (value == null) {
			return false;
		}
		
		if (!this.contains(value)) {
			return false;
		}

		return removeHelper(findNode(value, root));
	}

	public boolean removeHelper(BinaryNode<E> toRemove) {
		if (toRemove.isLeaf()) {
			
			if (toRemove.getParent() == null) {
				root = null;
				return true;
			}

			if (toRemove.getParent().getValue().compareTo(toRemove.getValue()) > 0) {
				toRemove.getParent().setLeft(null);
			} else {
				toRemove.getParent().setRight(null);
			}
			return true;
		}
		
		if (toRemove.hasRight() == false) {
			BinaryNode<E> maxLeft = maxNodeFromSpot(toRemove.getLeft());
			toRemove.setValue(maxLeft.getValue());

			if (maxLeft.hasLeft()) {
				BinaryNode<E> toUpdateHeight = maxLeft.getLeft();

					if (maxLeft.equals(toRemove.getLeft())) {
						maxLeft.getLeft().setParent(toRemove);
						toRemove.setLeft(maxLeft.getLeft());

					} else {
						maxLeft.getParent().setRight(maxLeft.getLeft());
						maxLeft.getLeft().setParent(maxLeft.getParent()); // doesn't work... fix next time
					}
				subtractHeight(toUpdateHeight);
			} else {
				return removeHelper(maxLeft);
			}

		} else {
			BinaryNode<E> minRight = minNodeFromSpot(toRemove.getRight());
			toRemove.setValue(minRight.getValue());

			if (minRight.hasRight()) {
				BinaryNode<E> toUpdateHeight = minRight.getRight();

				if (minRight.equals(toRemove.getRight())) {
					minRight.getRight().setParent(toRemove);
					toRemove.setRight(minRight.getRight());
				} else {
					minRight.getParent().setLeft(minRight.getRight());
					minRight.getRight().setParent(minRight.getParent());
				}

			subtractHeight(toUpdateHeight);
			} else {
				return removeHelper(minRight);
			}
		}
		return true;
	}
	
	public void subtractHeight (BinaryNode<E> startNode) {
		if (startNode == null) {
			return;
		}

		startNode.setHeight(startNode.getHeight() - 1);
		
		subtractHeight(startNode.getLeft());
		subtractHeight(startNode.getRight());
	}

	// Returns the minimum in the tree
	public E min() {
		if (root == null) {
			return null;
		}

		BinaryNode<E> currentNode = root;
		while (currentNode.hasLeft()) {
			currentNode = currentNode.getLeft();
		}

		return currentNode.getValue();
	}

	public BinaryNode<E> minNode() {
		if (root == null) {
			return null;
		}

		BinaryNode<E> currentNode = root;
		while (currentNode.hasLeft()) {
			currentNode = currentNode.getLeft();
		}

		return currentNode;
	}

	public BinaryNode<E> minNodeFromSpot(BinaryNode<E> currentPos) {
		BinaryNode<E> currentNode = currentPos;
		while (currentNode.hasLeft()) {
			currentNode = currentNode.getLeft();
		}

		return currentNode;
	}
	
	// Returns the maximum in the tree.
	public E max() {
		if (root == null) {
			return null;
		}
		BinaryNode<E> currentNode = root;
		while (currentNode.hasRight()) {
			currentNode = currentNode.getRight();
		}

		return currentNode.getValue();
	}

	public BinaryNode<E> maxNode() {
		if (root == null) {
			return null;
		}
		BinaryNode<E> currentNode = root;
		while (currentNode.hasRight()) {
			currentNode = currentNode.getRight();
		}

		return currentNode;
	}

	public BinaryNode<E> maxNodeFromSpot(BinaryNode<E> currentPos) {
		while (currentPos.hasRight()) {
			currentPos = currentPos.getRight();
		}

		return currentPos;
	}

	// Returns a bracket-surrounded, comma separated list of the contents of the nodes, in order
	// e.g. [Apple, Cranberry, Durian, Mango]
	public String toString() {
		StringBuilder currentString = new StringBuilder("[");
		toStringHelper(root, currentString);
		currentString.append("]");
		return currentString.toString();

	}

	public void toStringHelper(BinaryNode<E> currentPos, StringBuilder currentString) {
		if (currentPos == null) {
			return;
		}

		toStringHelper(currentPos.getLeft(), currentString);

		if (currentString.length() == 1) {
			currentString.append(currentPos.getValue());
		} else {
			currentString.append("," + currentPos.getValue());
		}

		toStringHelper(currentPos.getRight(), currentString);
		
	}

}
