package algorithms.sort;

import java.util.Arrays;
import java.util.List;

public class BubbleSort<T extends Comparable<? super T>> {

	public List<T> sort(List<T> elementsToSort) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[elementsToSort.size()];
		elementsToSort.toArray(array);
		for (int i = 0; i < array.length; i++) {
			bubbleSort(array, 0, array.length - i);
		}
		return Arrays.asList(array);
	}

	private void bubbleSort(T[] array, int start, int end) {
		for (int i = 1; i < array.length; i++) {
			T prevCellValue = array[i - 1];
			T currentCellValue = array[i];
			if (prevCellValue.compareTo(currentCellValue) > 0) {
				array[i - 1] = currentCellValue;
				array[i] = prevCellValue;
			}
		}
	}
}