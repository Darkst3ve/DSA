package de.unistuttgart.dsass2018.ex02.p2;

/**
 * Class for Uebungsblatt 2 - Aufgabe 2.
 * 
 * @author Lennart Duvenbeck | 2836913
 * @author Timo Stoll | 2976666
 * @author David Zheng | 3334362
 * 
 */
public class Sorter {

	public static <T extends Comparable<T>> void selectionSort(ISimpleList<T> list) {
		for (int i = 0; i <= list.size() - 1; i++) {
			int smallestElementIndex = i;
			for (int j = i; j <= list.size() - 1; j++) {
				if (list.get(j).compareTo(list.get(smallestElementIndex)) < 0) {
					smallestElementIndex = j;
				}
			}
			list.swap(i, smallestElementIndex);
		}
	}

	public static <T extends Comparable<T>> void bubbleSort(ISimpleList<T> list) {
		boolean hasSwapped = true;
		int i = 0;
		while (hasSwapped) {
			hasSwapped = false;
			for (int j = 0; j <= list.size() - i - 2; j++) {
				if (list.get(j).compareTo(list.get(j + 1)) > 0) {
					list.swap(j, j + 1);
					hasSwapped = true;
				}
			}
			i++;
		}
	}

	public static <T extends Comparable<T>> void quickSort(ISimpleList<T> list) {
		quicksort(list, 0, list.size() - 1);
	}

	public static <T extends Comparable<T>> void quicksort(ISimpleList<T> list, int lower, int upper) {
		if (lower >= upper) {
			return;
		}
		int pivot = lower;
		T pivotValue = list.get(pivot);
		list.swap(pivot, upper);
		for (int i = lower; i <= upper - 1; i++) {
			if (list.get(i).compareTo(pivotValue) <= 0) {
				list.swap(i, pivot);
				pivot++;
			}
		}
		list.swap(upper, pivot);
		quicksort(list, lower, pivot - 1);
		quicksort(list, pivot + 1, upper);
	}
	
	

	/**
	 * testing
	 */
	public static void main(String[] args) {
		ISimpleList<Integer> test = new SimpleList<Integer>();
		test.append(6);
		test.append(1);
		test.append(4);
		test.append(3);
		test.append(8);
		test.append(5);
		test.append(9);
		test.append(6);
		test.append(7);
		test.append(0);
		test.append(2);
		test.append(2);
		test.append(4);
		test.append(7);
		test.append(6);
		test.append(4);
		for (int i = 0; i <= test.size() - 1; i++) {
			System.out.print(test.get(i));
		}
		ISimpleList<Integer> test2 = test;
		ISimpleList<Integer> test3 = test;

		selectionSort(test);
		System.out.println();
		for (int i = 0; i <= test.size() - 1; i++) {
			System.out.print(test.get(i));
		}

		bubbleSort(test2);
		System.out.println();
		for (int i = 0; i <= test2.size() - 1; i++) {
			System.out.print(test2.get(i));
		}

		quickSort(test3);
		System.out.println();
		for (int i = 0; i <= test3.size() - 1; i++) {
			System.out.print(test3.get(i));
		}

	}

}
