package de.unistuttgart.dsass2018.ex04.p3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Class for Uebungsblatt 4 - Aufgabe 3.
 * 
 * @author Lennart Duvenbeck | 2836913
 * @author Timo Stoll | 2976666
 * @author David Zheng | 3334362
 * 
 */
public class BinarySearchTree<T extends Comparable<T>> implements IBinarySearchTreeIterable<T> {

	private volatile IBinaryTreeNode<T> root;

	public BinarySearchTree() {
		this.root = null;
	}

	@Override
	public void insert(T t) {
		this.root = this.insert(this.root, t);
	}

	private IBinaryTreeNode<T> insert(IBinaryTreeNode<T> node, T t) {
		if (node == null) {
			IBinaryTreeNode<T> newNode = new BinaryTreeNode<>();
			newNode.setValue(t);
			return newNode;
		}
		if (t.compareTo(node.getValue()) < 0) {
			node.setLeftChild(this.insert(node.getLeftChild(), t));
		} else if (t.compareTo(node.getValue()) > 0) {
			node.setRightChild(this.insert(node.getRightChild(), t));
		}
		return node;
	}

	@Override
	public IBinaryTreeNode<T> getRootNode() {
		return this.root;
	}

	class PreorderIterator implements Iterator<T> {

		private Stack<IBinaryTreeNode<T>> stack = new Stack<IBinaryTreeNode<T>>();

		public PreorderIterator(BinarySearchTree<T> tree) {
			if (tree.getRootNode() != null) {
				stack.push(tree.getRootNode());
			}
		}

		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		@Override
		public T next() {
			IBinaryTreeNode<T> node = stack.pop();
			if (node.getRightChild() != null) {
				stack.push(node.getRightChild());
			}
			if (node.getLeftChild() != null) {
				stack.push(node.getLeftChild());
			}
			return node.getValue();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	class PostorderIterator implements Iterator<T> {

		private Stack<IBinaryTreeNode<T>> stack = new Stack<IBinaryTreeNode<T>>();
		private IBinaryTreeNode<T> node;
		private IBinaryTreeNode<T> prevNode;
		private IBinaryTreeNode<T> nextNode;

		public PostorderIterator(BinarySearchTree<T> tree) {
			node = tree.getRootNode();
		}

		@Override
		public boolean hasNext() {
			return (!stack.isEmpty() || node != null);
		}

		@Override
		public T next() {
			while (this.hasNext()) {
				if (node != null) {
					stack.push(node);
					node = node.getLeftChild();
				} else {
					nextNode = stack.peek();
					if (nextNode.getRightChild() != null && prevNode != nextNode.getRightChild()) {
						node = nextNode.getRightChild();
					} else {
						prevNode = stack.pop();
						return nextNode.getValue();
					}
				}
			}
			return null;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	class InorderIterator implements Iterator<T> {

		private Stack<IBinaryTreeNode<T>> stack = new Stack<IBinaryTreeNode<T>>();
		private IBinaryTreeNode<T> node;

		public InorderIterator(BinarySearchTree<T> tree) {
			node = tree.getRootNode();
		}

		@Override
		public boolean hasNext() {
			return (!stack.isEmpty() || node != null);
		}

		@Override
		public T next() {
			while (this.hasNext()) {
				if (node != null) {
					stack.push(node);
					node = node.getLeftChild();
				} else {
					node = stack.pop();
					T value = node.getValue();
					node = node.getRightChild();
					return value;
				}
			}
			return null;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	class LevelorderIterator implements Iterator<T> {

		private Queue<IBinaryTreeNode<T>> queue = new LinkedList<IBinaryTreeNode<T>>();
		private IBinaryTreeNode<T> node;

		public LevelorderIterator(BinarySearchTree<T> tree) {
			queue.add(tree.getRootNode());
			node = tree.getRootNode();
		}

		@Override
		public boolean hasNext() {
			return !queue.isEmpty();
		}

		@Override
		public T next() {
			while (!queue.isEmpty()) {
				node = queue.poll();
				if (node.getLeftChild() != null) {
					queue.add(node.getLeftChild());
				}
				if (node.getRightChild() != null) {
					queue.add(node.getRightChild());
				}
				return node.getValue();
			}
			return null;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public Iterator<T> iterator(TreeTraversalType traversalType) {
		switch (traversalType) {
		case PREORDER:
			return new PreorderIterator(this);
		case POSTORDER:
			return new PostorderIterator(this);
		case INORDER:
			return new InorderIterator(this);
		case LEVELORDER:
			return new LevelorderIterator(this);
		}
		return null;
	}

	public static void main(String[] args) {
		BinarySearchTree<Integer> test = new BinarySearchTree<Integer>();
		test.insert(4);
		test.insert(2);
		test.insert(6);
		test.insert(1);
		test.insert(3);
		test.insert(5);
		test.insert(7);

		Iterator<Integer> testIterator = test.iterator(TreeTraversalType.LEVELORDER);
		while (testIterator.hasNext()) {
			System.out.println(testIterator.next());
		}
	}

}
