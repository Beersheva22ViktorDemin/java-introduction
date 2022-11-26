package telran.text;

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
	
	private static String arithmeticExpression() {
		String operatorExp = operator();
		String operandExp = operand();
		// FIXME
		// adds checking right placing the braces

		return String.format("%1$s(%2$s%1$s)*", operandExp, operatorExp);
	}

	private static String operand() {
		// FIXME
		// adds possibility of using Java variables
		return "(\\d+\\.?\\d*|\\.\\d+)";
	}

	public static boolean isArithmeticExpression(String expression) {
		expression = expression.replaceAll("\\s+", "");
		return expression.matches(arithmeticExpression());
	}

	private static String operator() {

		return "([-+*/])";
	}

	/**
	 * 
	 * @param expression
	 * @param values
	 * @param namesSorted - variable names sorted
	 * @return computed value of a given expression or Double.NaN
	 */
	public static Double computeArithmenticExpression(String expression, double values[], String names[]) {
		// 10 (* 2)
		// 10 * 2(())
		Double res = Double.NaN;
		if (isArithmeticExpression(expression) && checkBraces(expression)) {
			expression = expression.replaceAll("[\\s()]+", "");
			String operands[] = expression.split(operator());
			String operators[] = expression.split(operand());
			res = getOperandValue(operands[0], values, names);
			int index = 1;
			while (index < operands.length && !res.isNaN()) {
				double operandValue = getOperandValue(operands[index], values, names);
				res = computeOperation(res, operandValue, operators[index]);
				index++;
			}
			
		}

		return res;
	}

	private static Double computeOperation(Double operand1, double operand2, String operator) {
		Double res = Double.NaN;
		if(!Double.isNaN(operand2)) {
			switch(operator) {
			case "+": res = operand1 + operand2; break;
			case "-": res = operand1 - operand2; break;
			case "*": res = operand1 * operand2; break;
			case "/": res = operand1 / operand2; break;
			default: res = Double.NaN;
			}
		}
		return res;
	}

	private static Double getOperandValue(String operand, double[] values, String[] names) {
		// FIXME for possible variable names
		return Double.parseDouble(operand);
	}

	public static boolean checkBraces(String expression) {
		// TODO
		return true;
	}
}