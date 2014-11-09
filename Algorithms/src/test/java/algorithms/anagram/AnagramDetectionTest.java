package algorithms.anagram;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AnagramDetectionTest {

	AnagramDetection anagramDetection = new AnagramDetection();

	@Test
	public void should_return_true_for_anagrams() {
		boolean isAnagram = anagramDetection.isAnagram("heart", "earth");
		assertThat(isAnagram, is(true));
	}

	@Test
	public void should_return_false_for_non_anagrams() {
		boolean isAnagram = anagramDetection.isAnagram("star", "are");
		assertThat(isAnagram, is(false));
	}
	
	@Test
	public void should_return_false_for_nulls() {
		boolean isAnagram = anagramDetection.isAnagram(null, "are");
		assertThat(isAnagram, is(false));
	}
}
