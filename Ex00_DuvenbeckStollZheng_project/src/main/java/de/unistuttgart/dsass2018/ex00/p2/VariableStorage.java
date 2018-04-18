package de.unistuttgart.dsass2018.ex00.p2;

/**
 * Class for Uebungsblatt 0 - Aufgabe 2.
 * 
 * @author Lennart Duvenbeck | 2836913
 * @author Timo Stoll | 2976666
 * @author David Zheng | 3334362
 * 
 */
public class VariableStorage<T> implements IVariableStorage<T> {

	T content = null;

	@Override
	public void set(T var) {
		content = var;

	}

	@Override
	public T get() {
		return content;
	}

	public static void main(String[] args) {
		VariableStorage<Integer> test = new VariableStorage<Integer>();
		test.set(17);
		System.out.println(test.get());

	}

}
