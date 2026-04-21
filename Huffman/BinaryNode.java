
public class BinaryNode<E extends Comparable<E>> {

	private E value;
	private int frequency;
	private int binary;
	private BinaryNode<E> left;
	private BinaryNode<E> right;
	private BinaryNode<E> parent;
	private int height;

	public BinaryNode(E value) {
		this.value = value;
		this.frequency = 0;
		this.left = null;
		this.right = null;
		this.parent = null;
		this.height = 0;
		this.binary = 0;
	}
	
	public BinaryNode(E value, int frequency) {
		this.value = value;
		this.frequency = frequency;
		this.left = null;
		this.right = null;
		this.parent = null;
		this.height = 0;
		this.binary = 0;
	}

	
	
	/**
	 * @return the frequency
	 */
	public int getFrequency() {
		return frequency;
	}



	/**
	 * @param frequency the frequency to set
	 */
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}



	/**
	 * @return the binary
	 */
	public int getBinary() {
		return binary;
	}



	/**
	 * @param binary the binary to set
	 */
	public void setBinary(int binary) {
		this.binary = binary;
	}



	public E getValue() {
		return value;
	}

	public BinaryNode<E> getLeft() {
		return left;
	}

	public BinaryNode<E> getRight() {
		return right;
	}

	public BinaryNode<E> getParent() {
		return parent;
	}

	public int getHeight() {

		return height;
	}
	
	public void setValue(E value) {
		this.value = value;
	}

	public void setLeft(BinaryNode<E> left) {
		this.left = left;

		if (left == null) {
			return;
		}
		this.left.setHeight(height + 1);
		//YOU CODE: Update height
	}

	public void setRight(BinaryNode<E> right) {
		this.right = right;

		if (right == null) {
			return;
		}
		this.right.setHeight(height + 1);
		//YOU CODE: Update height
	}

	public void setParent(BinaryNode<E> parent) {
		this.parent = parent;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public boolean hasLeft() {
		return left != null;
	}
	
	public boolean hasRight() {
		return right != null;
	}
	
	public boolean isLeaf() {
		return !hasLeft() && !hasRight();
	}

	public String toString() {
		return value.toString();
		
	}
	
}

