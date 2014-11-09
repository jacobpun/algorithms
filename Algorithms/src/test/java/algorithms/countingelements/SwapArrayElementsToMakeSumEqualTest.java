package algorithms.countingelements;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class SwapArrayElementsToMakeSumEqualTest {

	SwapArrayElementsToMakeSumEqual swap = new SwapArrayElementsToMakeSumEqual();
	
	@Test
	public void should_return_elements_to_swap_1() {
		int[] arr1 = new int[] {1, 3, 4};
		int[] arr2 = new int[] {1, 1, 2};
		
		int[] elementsToSwap = swap.elementsToSwapToMakeSumEqual(arr1, arr2);
		assertThat(elementsToSwap[0], is(3));
		assertThat(elementsToSwap[1], is(1));
	}

	@Test
	public void should_return_elements_to_swap_2() {
		int[] arr1 = new int[] {1, 1, 2};
		int[] arr2 = new int[] {1, 3, 4};
		
		int[] elementsToSwap = swap.elementsToSwapToMakeSumEqual(arr1, arr2);
		assertThat(elementsToSwap[0], is(1));
		assertThat(elementsToSwap[1], is(3));
	}

	
	@Test
	public void should_return_null_if_there_are_no_elements_to_swap() {
		int[] arr1 = new int[] {1, 3, 4};
		int[] arr2 = new int[] {1, 1, 5};
		
		int[] elementsToSwap = swap.elementsToSwapToMakeSumEqual(arr1, arr2);
		assertNull(elementsToSwap);
	}
}