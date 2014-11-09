package algorithms.palindrome;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromeTest {

	@Test
	public void should_return_true_for_palindrome() {
		boolean isPalindrome =  new Palindrome().isPalindrome("malayalam");
		assertThat(isPalindrome, is(true));
	}
	
	@Test
	public void should_return_false_for_non_palindrome() {
		boolean isPalindrome =  new Palindrome().isPalindrome("earth");
		assertThat(isPalindrome, is(false));
	}
}