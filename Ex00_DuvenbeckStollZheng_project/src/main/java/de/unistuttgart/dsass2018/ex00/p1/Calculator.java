package de.unistuttgart.dsass2018.ex00.p1;

/**
 * Class for Uebungsblatt 0 - Aufgabe 1.
 * 
 * @author Lennart Duvenbeck | 2836913
 * @author Timo Stoll | 12345678
 * @author David Zheng | 3334362
 * 
 */
public class Calculator implements ICalculator {

	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public int subtract(int a, int b) {
		return a - b;
	}

	@Override
	public int multiply(int a, int b) {
		return a * b;
	}

	@Override
	public int max(int a, int b) {
		if (a >= b) {
			return a;
		} else {
			return b;
		}
	}

	@Override
	public int quersumme(int a) {
		int result = 0;
		while (a != 0) {
			result += a % 10;
			a = a / 10;
		}
		return result;
	}

	// public static void main(String[] args) {
	// Calculator test = new Calculator();
	// System.out.println(test.quersumme(516));
	// System.out.println(test.quersumme(12345));
	// }

}
