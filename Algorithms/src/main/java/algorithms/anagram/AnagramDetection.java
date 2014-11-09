package algorithms.anagram;

import java.util.Arrays;

public class AnagramDetection {

	public boolean isAnagram(String str1, String str2) {

		if (str1 == null || str2 == null || str1.length() != str2.length()) {
			return false;
		}

		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();

		Arrays.sort(ch1);
		Arrays.sort(ch2);

		return Arrays.equals(ch1, ch2);
	}
}