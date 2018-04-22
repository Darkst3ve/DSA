package de.unistuttgart.dsass2018.ex01.p2;

/**
 * Class for Uebungsblatt 1 - Aufgabe 2.
 * 
 * @author Lennart Duvenbeck | 2836913
 * @author Timo Stoll | 2976666
 * @author David Zheng | 3334362
 * 
 */
public class SpeedList<T> implements ISpeedList<T> {

	private class Node {
		private T content = null;
		private Node next = null;
		private Node eightNext = null;

		public Node(T content, Node next, Node eightNext) {
			this.content = content;
			this.next = next;
			this.eightNext = eightNext;
		}

		public Node() {
			this.content = null;
			this.next = null;
			this.eightNext = null;
		}

		public T getElement() {
			return this.content;
		}

		public void setElement(T t) {
			this.content = t;
		}

		public Node getNext() {
			return this.next;
		}

		public void setNext(Node n) {
			this.next = n;
		}

		public Node getEightNext() {
			return this.eightNext;
		}

		public void setEightNext(Node n) {
			this.eightNext = n;
		}

	}

	private Node head;

	public SpeedList() {
		head = new Node();
	}

	@Override
	public int size() {
		Node current = head;
		int size = 0;
		while (current.getEightNext() != null) {
			current = current.getEightNext();
			size += 8;
		}
		while (current.getNext() != null) {
			current = current.getNext();
			size += 1;
		}
		return size;
	}

	@Override
	public void prepend(T t) {
		boolean overflow = false;
		Node seventh = head;
		for (int i = 1; i <= 7; i++) {
			if (seventh.getNext() == null) {
				overflow = true;
				break;
			} else {
				seventh = seventh.getNext();
			}
		}
		Node n = new Node(t, head.getNext(), head.getEightNext());
		head.setNext(n);
		if (overflow) {
			head.setEightNext(null);
		} else {
			head.setEightNext(seventh);
		}
	}

	@Override
	public T getElementAt(int pos) {
		Node wanted = head;
		while (pos >= 8) {
			wanted = wanted.getEightNext();
			pos -= 8;
		}
		while (pos >= 1) {
			wanted = wanted.getNext();
			pos -= 1;
		}
		return wanted.getElement();
	}

	@Override
	public T getNext8thElementOf(int pos) {
		return getElementAt(pos + 8);
	}

	public static void main(String[] args) {
		SpeedList<Integer> list = new SpeedList<>();
		list.prepend(10);
		list.prepend(9);
		list.prepend(8);
		list.prepend(7);
		list.prepend(6);
		list.prepend(5);
		list.prepend(4);
		list.prepend(3);
		list.prepend(2);
		list.prepend(1);
		System.out.println(list.getElementAt(5));
		System.out.println(list.getNext8thElementOf(1));
		System.out.println(list.size());
	}

}
