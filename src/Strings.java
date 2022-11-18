import java.util.Arrays;

public class Strings {
	/**
	 * 
	 * @param str1
	 * @param str2
	 * @return true if str2 is an anagram of str1 complexity O[N] two passes only
	 *         one additional array only symbols or English letters 1. the same
	 *         length 2. the same symbols just in different order
	 */
	public static boolean isAnagram(String str1, String str2) {
		char[] array1 = str1.toCharArray();
		char[] array2 = str2.toCharArray();
		Arrays.sort(array1);
		Arrays.sort(array2);

		return Arrays.equals(array1, array2);
	}
}