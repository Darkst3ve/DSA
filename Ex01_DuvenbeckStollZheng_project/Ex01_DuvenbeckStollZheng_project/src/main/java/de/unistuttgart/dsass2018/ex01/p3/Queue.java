package de.unistuttgart.dsass2018.ex01.p3;

import java.util.LinkedList;

/**
 * Class for Uebungsblatt 1 - Aufgabe 3.
 * 
 * @author Lennart Duvenbeck | 2836913
 * @author Timo Stoll | 2976666
 * @author David Zheng | 3334362
 * 
 */
public class Queue<T> implements IQueue<T> {
	private LinkedList<T> queue = new LinkedList<>();

	@Override
	public void enqueue(T t) {
		queue.addFirst(t);

	}

	@Override
	public T dequeue() {
		T t = queue.getLast();
		queue.removeLast();
		return t;
	}

	@Override
	public T front() {
		return queue.getLast();
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

}
