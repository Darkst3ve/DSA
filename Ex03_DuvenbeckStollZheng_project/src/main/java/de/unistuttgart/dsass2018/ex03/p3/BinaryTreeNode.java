package de.unistuttgart.dsass2018.ex03.p3;

/**
 * Class for Uebungsblatt 3 - Aufgabe 3.
 * 
 * @author Lennart Duvenbeck | 2836913
 * @author Timo Stoll | 2976666
 * @author David Zheng | 3334362
 * 
 */
public class BinaryTreeNode<T extends Comparable<T>> implements IBinaryTreeNode<T> {

	protected T element;
	protected IBinaryTreeNode<T> left, right;

	public BinaryTreeNode() {
		this.element = null;
		left = null;
		right = null;
	}

	public void setValue(T val) {
		this.element = val;
	}

	public T getValue() {
		return this.element;

	}

	public void setLeftChild(IBinaryTreeNode<T> left) {
		this.left = left;

	}

	public IBinaryTreeNode<T> getLeftChild() {
		return this.left;

	}

	public void setRightChild(IBinaryTreeNode<T> right) {
		this.right = right;
	}

	public IBinaryTreeNode<T> getRightChild() {
		return this.right;
	}

}
