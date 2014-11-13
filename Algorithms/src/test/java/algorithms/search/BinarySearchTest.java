package algorithms.search;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BinarySearchTest {

	@Test
	public void should_find_value1() {
		List<Integer> elementsToSearch = new ArrayList<Integer>();
		elementsToSearch.add(1);
		elementsToSearch.add(2);
		elementsToSearch.add(3);
		elementsToSearch.add(4);
		elementsToSearch.add(5);
		elementsToSearch.add(6);
		elementsToSearch.add(7);
		elementsToSearch.add(8);

		BinarySearcher<Integer> searcher = new BinarySearcher<Integer>();
		int indexOfItem = searcher.search(elementsToSearch, 7);
		assertThat(indexOfItem, is(6));
	}

	@Test
	public void should_find_value2() {
		List<Integer> elementsToSearch = new ArrayList<Integer>();
		elementsToSearch.add(1);
		elementsToSearch.add(2);
		elementsToSearch.add(3);
		elementsToSearch.add(4);
		elementsToSearch.add(5);
		elementsToSearch.add(6);
		elementsToSearch.add(7);
		elementsToSearch.add(8);

		BinarySearcher<Integer> searcher = new BinarySearcher<Integer>();
		int indexOfItem = searcher.search(elementsToSearch, 2);
		assertThat(indexOfItem, is(1));
	}

	@Test
	public void should_find_value3() {
		List<Integer> elementsToSearch = new ArrayList<Integer>();
		elementsToSearch.add(1);
		elementsToSearch.add(2);
		elementsToSearch.add(3);
		elementsToSearch.add(4);
		elementsToSearch.add(5);
		elementsToSearch.add(6);
		elementsToSearch.add(7);
		elementsToSearch.add(8);

		BinarySearcher<Integer> searcher = new BinarySearcher<Integer>();
		int indexOfItem = searcher.search(elementsToSearch, 9);
		assertThat(indexOfItem, is(-8));
	}
}