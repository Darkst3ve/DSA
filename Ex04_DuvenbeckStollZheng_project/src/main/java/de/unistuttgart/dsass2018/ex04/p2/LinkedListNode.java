package de.unistuttgart.dsass2018.ex04.p2;

/**
 * Class for Uebungsblatt 4 - Aufgabe 2.
 * 
 * @author Lennart Duvenbeck | 2836913
 * @author Timo Stoll | 2976666
 * @author David Zheng | 3334362
 * 
 */
public class LinkedListNode<T extends Comparable<T>> implements ILinkedListNode<T> {

	private T var;
	private ILinkedListNode<T> next;
	private ILinkedListNode<T> prev;

	@Override
	public T getElement() {
		return var;
	}

	@Override
	public void setElement(T element) {
		var = element;

	}

	@Override
	public ILinkedListNode<T> getNext() {
		return next;
	}

	@Override
	public void setNext(ILinkedListNode<T> next) {
		this.next = next;

	}

	@Override
	public ILinkedListNode<T> getPrev() {
		return prev;
	}

	@Override
	public void setPrev(ILinkedListNode<T> prev) {
		this.prev = prev;

	}

	public LinkedListNode() {

	}

}
