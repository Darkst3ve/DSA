package de.unistuttgart.dsass2018.ex03.p1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class for Uebungsblatt 3 - Aufgabe 1.
 * 
 * @author Lennart Duvenbeck | 2836913
 * @author Timo Stoll | 2976666
 * @author David Zheng | 3334362
 * 
 */
public class SimpleList<T extends Comparable<T>> implements ISimpleListIterable<T> {

	/** Do not modify the existing methods and signatures */
	private final List<T> list;

	public SimpleList() {
		list = new ArrayList<T>();
	}

	@Override
	public void append(T element) {
		list.add(element);
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public T get(int index) {
		return list.get(index);
	}

	@Override
	public void swap(int i, int j) {
		T tmp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, tmp);
	}

	private class simpleIterator implements Iterator<T> {
		private int index;

		public simpleIterator() {
			index = 0;
		}

		@Override
		public boolean hasNext() {
			return index >= list.size();
		}

		@Override
		public T next() {
			if (!this.hasNext()) {
				index++;
				return list.get(index - 1);
			} else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private class skippingIterator implements Iterator<T> {

		private int index;
		private int step = 1;

		public skippingIterator(int n) {
			index = 0;
			if (n < 1) {
				throw new IllegalArgumentException();
			}
			step = n;
		}

		@Override
		public boolean hasNext() {
			return index >= list.size();
		}

		@Override
		public T next() {
			if (!this.hasNext()) {
				index += step;
				return list.get(index - step);
			} else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	@Override
	public Iterator<T> iterator() {
		return new simpleIterator();
	}

	@Override
	public Iterator<T> skippingIterator(int n) {
		return new skippingIterator(n);
	}

}
