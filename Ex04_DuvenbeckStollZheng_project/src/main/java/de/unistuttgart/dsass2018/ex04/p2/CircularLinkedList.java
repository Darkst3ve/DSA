package de.unistuttgart.dsass2018.ex04.p2;

/**
 * Class for Uebungsblatt 4 - Aufgabe 2.
 * 
 * @author Lennart Duvenbeck | 2836913
 * @author Timo Stoll | 2976666
 * @author David Zheng | 3334362
 * 
 */
public class CircularLinkedList<T extends Comparable<T>> implements ICircularLinkedList<T> {

	private ILinkedListNode<T> head = new LinkedListNode<T>();
	private int size = 0;

	public CircularLinkedList() {
	}

	@Override
	public void append(T element) {
		if (this.size == 0) { // If the list contains no elements the first one added becomes head
			head.setElement(element);
			head.setNext(head);
			head.setPrev(head);
			this.size = 1;
			return;
		}
		ILinkedListNode<T> newNode = new LinkedListNode<T>();
		ILinkedListNode<T> prevLast = head.getPrev();
		newNode.setElement(element);

		newNode.setNext(head);
		head.setPrev(newNode);

		newNode.setPrev(prevLast);
		prevLast.setNext(newNode);

		this.size++;
	}

	@Override
	public T get(int index) {
		ILinkedListNode<T> node = head;
		int realIndex = index % (size + 1);
		if (realIndex < 0) {
			realIndex += size;
		}
		if (realIndex <= size / 2) {
			for (int i = 0; i < realIndex; i++) {
				node = node.getNext();
			}
		} else {
			for (int i = size; i > realIndex; i--) {
				node = node.getPrev();
			}
		}
		return node.getElement();
	}

	@Override
	public int size() {
		// ILinkedListNode<T> currentNode = head.getNext();
		// int index = 0;
		// while (currentNode != head) {
		// currentNode = currentNode.getNext();
		// index++;
		// }
		// return index;
		return this.size;
	}

	@Override
	public ILinkedListNode<T> getHead() {
		return this.head;
	}

	public static void main(String[] args) {
		ICircularLinkedList<Integer> test = new CircularLinkedList<Integer>();
		test.append(0);
		test.append(1);
		test.append(2);
		test.append(3);
		test.append(4);
		test.append(5);

		System.out.println(test.size());
		System.out.println(test.get(0));
		System.out.println(test.get(1));
		System.out.println(test.get(2));
		System.out.println(test.get(3));
		System.out.println(test.getHead().getElement());
	}

}
