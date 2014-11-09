package algorithms.sort;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MergeSort<T extends Comparable<? super T>> {
	@SuppressWarnings("unchecked")
	public List<T> sort(List<T> elementsToSort) {
		T[] elementArray = (T[]) new Comparable[elementsToSort.size()];
		elementsToSort.toArray(elementArray);
		SortAction<T> task = new SortAction<T>(elementArray);
		ForkJoinPool pool = new ForkJoinPool();
		return Arrays.asList(pool.invoke(task));
	}
}

class SortAction<T extends Comparable<? super T>> extends RecursiveTask<T[]> {
	private static final long serialVersionUID = 1L;
	private T[] elementsToSort;

	public SortAction(T[] elementsToSort) {
		this.elementsToSort = elementsToSort;
	}

	@Override
	protected T[] compute() {
		if (elementsToSort.length == 1) {
			return elementsToSort;
		}

		int midPoint = elementsToSort.length / 2;

		T[] left = Arrays.copyOfRange(elementsToSort, 0, midPoint);
		T[] right = Arrays.copyOfRange(elementsToSort, midPoint,
				elementsToSort.length);

		SortAction<T>  rightSortAction = new SortAction<T>(right);
		rightSortAction.fork();
		
		SortAction<T>  leftSortAction = new SortAction<T>(left);
		
		return merge(leftSortAction.compute(), rightSortAction.join());
	}

	private T[] merge(T[] left, T[] right) {
		@SuppressWarnings("unchecked")
		T[] results = (T[]) new Comparable[left.length + right.length];
		int leftIndex = 0;
		int rightIndex = 0;
		int resultsIndex = 0;

		while (leftIndex < left.length || rightIndex < right.length) {
			if (leftIndex < left.length && rightIndex < right.length) {
				if (left[leftIndex].compareTo(right[rightIndex]) <= 0) {
					results[resultsIndex] = left[leftIndex];
					leftIndex++;
					resultsIndex++;
				} else {
					results[resultsIndex] = right[rightIndex];
					rightIndex++;
					resultsIndex++;
				}
			} else if (leftIndex < left.length) {
				results[resultsIndex] = left[leftIndex];
				leftIndex++;
				resultsIndex++;
			} else {
				results[resultsIndex] = right[rightIndex];
				rightIndex++;
				resultsIndex++;
			}
		}

		return results;
	}
}