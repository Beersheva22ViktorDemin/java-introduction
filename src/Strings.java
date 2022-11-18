
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
		boolean result = false;
		char[] array1 = str1.toCharArray();
		char[] array2 = str2.toCharArray();
		if (array1.length == array2.length) {
			int[] buffer = new int[Character.MAX_VALUE];
			for (int i = 0; i < array1.length; i++) {
				buffer[array1[i]]++;
				buffer[array2[i]]--;
			}
			result = isEmptyArray(buffer);
		}

		return result;
	}

	private static boolean isEmptyArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				return false;
			}
		}
		return true;
	}
}