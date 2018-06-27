package de.unistuttgart.dsass2018.ex08.p1;

import java.awt.Point;
import java.util.Iterator;
import java.util.Stack;

/**
 * Class for Uebungsblatt 8 - Aufgabe 3.
 * 
 * @author Lennart Duvenbeck | 2836913
 * @author Timo Stoll | 2976666
 * @author David Zheng | 3334362
 * 
 */
public class BinarySearchTree<T extends Comparable<T>> implements IBinarySearchTree<T> {

	private volatile IBinaryTreeNode<T> root;

	public BinarySearchTree() {
		this.root = null;
	}

	@Override
	public void insert(T t) {
		this.root = this.insert(this.root, t, 0, null);
	}

	private IBinaryTreeNode<T> insert(IBinaryTreeNode<T> node, T t, int lev, IBinaryTreeNode<T> par) {
		if (node == null) {
			IBinaryTreeNode<T> newNode = new BinaryTreeNode<>();
			newNode.setValue(t);
			return newNode;
		}

		if (t.compareTo(node.getValue()) < 0) {
			// Go left
			node.setLeftChild(this.insert(node.getLeftChild(), t, lev + 1, node));
		} else if (t.compareTo(node.getValue()) > 0) {
			// Go right
			node.setRightChild(this.insert(node.getRightChild(), t, lev + 1, node));
		}
		return node;
	}

	@Override
	public IBinaryTreeNode<T> getRootNode() {
		return this.root;
	}

	@Override
	public boolean isFull() {
		return this.isFull(this.root);
	}

	private boolean isFull(IBinaryTreeNode<T> node) {
		if (node == null) {
			return true;
		} else if ((node.getLeftChild() == null) && (node.getRightChild() == null)) {
			return true;
		} else if ((node.getLeftChild() == null) || (node.getRightChild() == null)) {
			return false;
		}
		return this.isFull(node.getLeftChild()) && this.isFull(node.getRightChild());
	}

	class InorderIterator implements Iterator<IBinaryTreeNode<T>> {

		private Stack<IBinaryTreeNode<T>> stack = new Stack<IBinaryTreeNode<T>>();
		private IBinaryTreeNode<T> node;
		public int depth = 0;

		public InorderIterator(BinarySearchTree<T> tree) {
			node = tree.getRootNode();
		}

		@Override
		public boolean hasNext() {
			return (!stack.isEmpty() || node != null);
		}

		@Override
		public IBinaryTreeNode<T> next() {
			while (this.hasNext()) {
				if (node != null) {
					stack.push(node);
					node = node.getLeftChild();
				} else {
					node = stack.pop();
					IBinaryTreeNode<T> returnNode = node;
					node = node.getRightChild();
					return returnNode;
				}
			}
			return null;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public void calculatePositions() {
		InorderIterator inorderIterator = new InorderIterator(this);
		int xValue = 0;
		int yValue = 0;
		while (inorderIterator.hasNext()) {
			IBinaryTreeNode<T> node = inorderIterator.next();
			yValue = getDepth(node);
			Point position = new Point(xValue, yValue);
			xValue++;
			node.setPosition(position);
		}
	}

	private int getDepth(IBinaryTreeNode<T> node) {
		IBinaryTreeNode<T> currentNode = this.getRootNode();
		int depth = 0;
		while(currentNode != node) {
			if (currentNode.getValue().compareTo(node.getValue()) < 0) {
				currentNode = currentNode.getRightChild();
			} else {
				currentNode = currentNode.getLeftChild();
			}
			depth++;
		}
		return depth;
	}

}
