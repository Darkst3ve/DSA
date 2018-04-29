package de.unistuttgart.dsass2018.ex01.p3;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for Uebungsblatt 1 - Aufgabe 3.
 * 
 * @author Lennart Duvenbeck | 2836913
 * @author Timo Stoll | 2976666
 * @author David Zheng | 3334362
 * 
 */
public class Stack<T> implements IStack<T> {
	private List<T> stack = new ArrayList<>();

	@Override
	public void push(T t) {
		stack.add(stack.size(), t);
	}

	@Override
	public T pop() {
		T t = stack.get(stack.size() - 1);
		stack.remove(stack.size() - 1);
		return t;
	}

	@Override
	public T top() {
		return stack.get(stack.size() - 1);
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

}
