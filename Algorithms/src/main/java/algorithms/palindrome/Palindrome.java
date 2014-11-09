package algorithms.palindrome;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Palindrome {

	public boolean isPalindrome(String word) {

		if (word == null) {
			return false;
		}

		Character[] asArray = toCharacterArray(word);
		Deque<Character> queue = new ArrayDeque<Character>(
				Arrays.asList(asArray));

		while (queue.size() > 1) {
			char firstChar = queue.removeFirst();
			char lastChar = queue.removeLast();
			if (firstChar != lastChar) {
				return false;
			}
		}

		return true;
	}

	private Character[] toCharacterArray(String s) {
		int len = s.length();
		Character[] array = new Character[len];
		for (int i = 0; i < len; i++) {
			array[i] = new Character(s.charAt(i));
		}

		return array;
	}
}