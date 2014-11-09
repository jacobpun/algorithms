package algorithms.countingelements;

public class SwapArrayElementsToMakeSumEqual {

	public int[] elementsToSwapToMakeSumEqual(int[] arr1, int[] arr2) {
		int sum1 = sum(arr1);
		int sum2 = sum(arr2);

		int diff = sum1 - sum2;

		if (diff % 2 == 1) {
			return null;
		}

		diff = diff / 2;

		for (int i : arr1) {
			for (int j : arr2) {
				if (i - j == diff) {
					return new int[] { i, j };
				} else if (j - i == diff) {
					return new int[] { j, i };
				}
			}
		}

		return null;
	}

	private int sum(int[] arr) {
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		return sum;
	}

}