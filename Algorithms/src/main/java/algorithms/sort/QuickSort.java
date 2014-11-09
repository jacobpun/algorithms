package algorithms.sort;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class QuickSort<T extends Comparable<? super T>> {

	public List<T> sort(List<T> elementsToSort) {
		T[] elementsArray = (T[]) new Comparable[elementsToSort.size()];
		elementsToSort.toArray(elementsArray);

		SortTask<T> task = new SortTask<T>(elementsArray, 0,
				elementsArray.length - 1);

		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(task);

		return Arrays.asList(elementsArray);

	}
}

@SuppressWarnings("serial")
class SortTask<T extends Comparable<? super T>> extends RecursiveAction {
	private T[] values;
	private int startPos;
	private int endPos;

	public SortTask(T[] values, int startPos, int endPos) {
		this.values = values;
		this.startPos = startPos;
		this.endPos = endPos;
	}

	@Override
	protected void compute() {
		int i = startPos;
		int j = endPos;
		int mid = (startPos + endPos) / 2;
		T pivot = values[mid];

		System.out.println("Values: "
				+ Arrays.asList(values).subList(startPos, endPos));
		System.out.println("Pivot Equals: " + pivot);

		while (i < j) {

			while (values[i].compareTo(pivot) < 0) {
				i++;
			}

			while (values[j].compareTo(pivot) > 0) {
				j--;
			}

			if (i != j) {
				exchange(i, j);
			}

			i++;
			j--;
		}

		SortTask<T> rightTask = null;
		if (i < endPos) {
			rightTask = new SortTask<T>(values, i, endPos);
			rightTask.fork();
		}

		SortTask<T> leftTask = null;
		if (j > startPos) {
			leftTask = new SortTask<T>(values, startPos, j);
			leftTask.fork();
		}

		if (rightTask != null) {
			rightTask.join();
		}

		if (leftTask != null) {
			leftTask.join();
		}
	}

	private void exchange(int i, int j) {
		T temp = values[i];
		System.out.println("Exchanging " + values[i] + "(index" + i + ") with "
				+ values[j] + "(index" + j + ")");
		values[i] = values[j];
		values[j] = temp;
	}
}