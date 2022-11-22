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
	
	public static void sortStringNumbers(String[] array) {
		int[] buffer = new int[Byte.MAX_VALUE - Byte.MIN_VALUE + 1];
		for (int i = 0; i < array.length; i++) {
			int index = Integer.parseInt(array[i]) - Byte.MIN_VALUE;

			buffer[index]++;
		}
		int outputIndex = 0;
		for (int bufferIndex = 0; bufferIndex < buffer.length; bufferIndex++) {
			for (int j = 0; j < buffer[bufferIndex]; j++) {
				array[outputIndex] = String.valueOf(bufferIndex + Byte.MIN_VALUE);
				outputIndex++;
			}
		}
	}
	
	public static String javaNameExp() {
		return "[a-zA-Z$][\\w$]*|_[\\w$]+";
	}
	
	public static String ipV4Octet() {
		//max values if 3 digits: 099 199 249 255
		return "\\d{1,2}|[0-1][0-9]{2}|2[0-4][0-9]|25[0-5]";
	}
	
	public static String ipV4() {
		String ipV4Octet = ipV4Octet();
		return String.format("((%s)\\.){3}(%s)", ipV4Octet, ipV4Octet);
	}
}