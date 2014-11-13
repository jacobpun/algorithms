package algorithms.search;

import java.util.List;

public class BinarySearcher<T extends Comparable<? super T>> {
	public int search(List<T> elements, T elementTofind) {
		T[] elementsArray = (T[]) new Comparable[elements.size()];
		elements.toArray(elementsArray);
		return search(elementTofind, elementsArray, 0,
				elementsArray.length - 1);
	}

	private int search(T elementTofind, T[] elementsArray, int startPos,
			int endPos) {
		if (endPos - startPos <= 2) {
			for (int i = startPos; i <= endPos; i++) {
				if (elementsArray[i].equals(elementTofind)) {
					return i;
				}
			}
			
			return (-1 * endPos) - 1;
		}
		
		int midPos = (startPos + endPos) / 2;
		int comparisonResult = elementTofind.compareTo(elementsArray[midPos]);
		if (comparisonResult > 0) {
			return search(elementTofind, elementsArray, midPos, endPos);
		} else if (comparisonResult < 0) {
			return search(elementTofind, elementsArray, startPos,
					midPos - 1);
		} else {
			return midPos;
		}
	}
}