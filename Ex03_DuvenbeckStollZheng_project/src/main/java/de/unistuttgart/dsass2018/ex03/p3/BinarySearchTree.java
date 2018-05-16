package de.unistuttgart.dsass2018.ex03.p3;

/**
 * Class for Uebungsblatt 3 - Aufgabe 3.
 * 
 * @author Lennart Duvenbeck | 2836913
 * @author Timo Stoll | 2976666
 * @author David Zheng | 3334362
 * 
 */
public class BinarySearchTree<T extends Comparable<T>> implements IBinarySearchTree<T> {

	private IBinaryTreeNode<T> head;

	public BinarySearchTree() {

		head = new BinaryTreeNode<T>();

	}

	// insert a node into binary search tree
	public void insert(T t) {
		// establish a new node with value t
		IBinaryTreeNode<T> newNode = new BinaryTreeNode<T>();
		newNode.setValue(t);

		head = insertNode(head, newNode);

	}

	public IBinaryTreeNode<T> insertNode(IBinaryTreeNode<T> root, IBinaryTreeNode<T> node) {

		// if the head node is still null, this node is the root node
		if (root == null || root.getValue() == null) {
			return node;
		}

		// compare the new node with existed node
		else if (root.getValue().compareTo(node.getValue()) > 0) {
			// if new node is smaller than existed node,
			// insert the new node into the left child of the existed node
			root.setLeftChild(insertNode(root.getLeftChild(), node));

		} else if (root.getValue().compareTo(node.getValue()) < 0) {

			// if new node is larger than existed node,
			// insert the new node into the right child of the existed node
			root.setRightChild(insertNode(root.getRightChild(), node));
		} else
			// if new node is equal to existed node, do nothing.
			;
		return root;
	}

	public IBinaryTreeNode<T> getRootNode() {
		return this.head;
	}

	public boolean isFull() {

		boolean result;
		result = isfull(this.head);
		return result;
	}

	public boolean isfull(IBinaryTreeNode<T> root) {

		{

			if (root != null) { // if the node has no child, that means the tree is full.
				if (root.getRightChild() == null && root.getRightChild() == null) {
					return true;
				}
				// if the node has two child nodes, check the two child nodes.
				if ((root.getRightChild() != null && root.getLeftChild() != null)) {
					return isfull(root.getRightChild()) && isfull(root.getLeftChild());
				}
			}

			// if the node has only one child node, that means it is not full.
			return false;
		}

	}

}
