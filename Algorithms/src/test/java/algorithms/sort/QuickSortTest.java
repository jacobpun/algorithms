package algorithms.sort;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class QuickSortTest {

	@Test(timeout=1000)
	public void test() {
		List<String> elementsToSort = new ArrayList<String>();
		elementsToSort.add("abc");
		elementsToSort.add("Abc");
		elementsToSort.add("ABc");
		elementsToSort.add("ABC");
		elementsToSort.add("aBc");
		elementsToSort.add("aBC");
		List<String> sorted = new QuickSort<String>().sort(elementsToSort);
		assertThat(sorted, contains("ABC", "ABc", "Abc", "aBC", "aBc", "abc"));
	}
}