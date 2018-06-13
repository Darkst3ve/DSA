package de.unistuttgart.dsass2018.ex06.p4;

/**
 * Class for Uebungsblatt 6 - Aufgabe 4.
 * 
 * @author Lennart Duvenbeck | 2836913
 * @author Timo Stoll | 2976666
 * @author David Zheng | 3334362
 * 
 */
public class Sorter {

	public static <T extends Comparable<T>> void heapSort(ISimpleList<T> list) {
		for (int i = list.size(); i >= 0; i--) {
			sink(list, list.size(), i);
		}
		for (int i = list.size() - 1; i >= 0; i--) {
			list.swap(0, i);
			sink(list, i, 0);
		}
	}

	private static <T extends Comparable<T>> void sink(ISimpleList<T> list, Integer heapSize, Integer index) {
		int leftChild = 2 * index + 1;
		int rightChild = leftChild + 1;
		int largestNode = index;

		if (leftChild < heapSize && list.get(leftChild).compareTo(list.get(largestNode)) > 0) {
			largestNode = leftChild;
		}
		if (rightChild < heapSize && list.get(rightChild).compareTo(list.get(largestNode)) > 0) {
			largestNode = rightChild;
		}
		if (largestNode != index) {
			list.swap(largestNode, index);
			sink(list, heapSize, largestNode);
		}

	}

	public static void main(String[] args) {
		ISimpleList<Integer> test = new SimpleList<Integer>();
		Integer[] testArray = { 1, 4, 2, 3, 7, 5, 6, 9, 8, 3, 2, 7, 4, 5, 5, 9, 0, 1, 6 };
		for (Integer x : testArray) {
			test.append(x);
		}
		for (int i = 0; i < test.size(); i++) {
			System.out.print(test.get(i));
		}
		heapSort(test);
		System.out.println();
		for (int i = 0; i < test.size(); i++) {
			System.out.print(test.get(i));
		}
	}

}
