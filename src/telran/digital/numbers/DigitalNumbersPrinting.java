package telran.digital.numbers;

import java.util.Arrays;

public class DigitalNumbersPrinting {
	private static final String SYMBOL = "*";

	public static void displayDigitalNumber(int number, int offset, int width, int height) {
		int[] digits = Numbers.getDigits(number);
		String[] result = new String[height];
		Arrays.fill(result, "");
		
		for (int digit : digits) {
			String[] currentDigit = getDigitStrings(digit, offset, width, height);
			for (int row = 0; row < result.length; row++) {
				result[row] += currentDigit[row];
			}

//			displayStrings(currentDigit);
		}
		
		displayStrings(result);
	}
	
	private static String[] getDigitStrings(int digit, int offset, int width, int height) {
		String[] result = new String[height];
		switch (digit) {
		case 0:
			result = zero(offset, width, height);
			break;
		case 1:
			result = one(offset, width, height);
			break;
		case 2:
			result = two(offset, width, height);
			break;
		case 3:
			result = three(offset, width, height);
			break;
		case 4:
			result = four(offset, width, height);
			break;
		case 5:
			result = five(offset, width, height);
			break;
		case 6:
			result = six(offset, width, height);
			break;
		case 7:
			result = seven(offset, width, height);
			break;
		case 8:
			result = eight(offset, width, height);
			break;
		case 9:
			result = nine(offset, width, height);
			break;
		}
		
		return result;
	}

	public static String line(int offset, int length) {
		return " ".repeat(offset) + SYMBOL.repeat(length);
	}

	public static String[] verticalLine(int offset, int width, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width - 1);
		}
		return res;
	}

	public static String[] twoVerticalLines(int offset, int width, int height) {
		String[] result = new String[height];
		for (int i = 0; i < result.length; i++) {
			result[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width - 2) + SYMBOL;
		}
		return result;
	}

	public static String[] zero(int offset, int width, int height) {
		String[] result = new String[height];
		result[0] = line(offset, width);
		String[] lines = twoVerticalLines(offset, width, height - 2);
		System.arraycopy(lines, 0, result, 1, lines.length);
		result[height - 1] = line(offset, width);
		return result;
	}

	public static String[] one(int offset, int width, int height) {
		return verticalLine(offset + width - 1, width, height);
	}
	
	public static String[] two(int offset, int width, int height) {
		String[] result = new String[height];
		result[0] = line(offset, width);
		int middle = (int) height / 2;

		String[] verticalLine = verticalLine(offset + width - 1, 1, middle - 1);
		System.arraycopy(verticalLine, 0, result, 1, verticalLine.length);
		
		result[middle] = line(offset, width);
		
		verticalLine = verticalLine(offset, width, middle - 1);
		System.arraycopy(verticalLine, 0, result, middle + 1, verticalLine.length);
		
		result[height - 1] = line(offset, width);
	
		return result;
	}
	
	public static String[] three(int offset, int width, int height) {
		String[] result = new String[height];
		
		int middle = (int) height / 2;
		
		result[0] = line(offset, width);
		String[] verticalLine = verticalLine(offset + width - 1, 1, middle - 1);
		System.arraycopy(verticalLine, 0, result, 1, verticalLine.length);
		
		result[middle] = line(offset, width);
		
		verticalLine = verticalLine(offset + width - 1, 1, middle - 1);
		System.arraycopy(verticalLine, 0, result, middle + 1, verticalLine.length);
		
		result[height - 1] = line(offset, width);
	
		return result;
	}
	
	public static String[] four(int offset, int width, int height) {
		String[] result = new String[height];		
		String[] verticalLines = twoVerticalLines(offset, width, height / 2);
		System.arraycopy(verticalLines, 0, result, 0, verticalLines.length);
				
		result[height / 2] = line(offset, width);
		String[] verticalLine = verticalLine(offset + width - 1, 1, (height - 1)/ 2);
		System.arraycopy(verticalLine, 0, result, height / 2 + 1, verticalLine.length);
		
		return result;
	}
	
	public static String[] five(int offset, int width, int height) {
		String[] result = new String[height];
		result[0] = line(offset, width);

		String[] verticalLine = verticalLine(offset, width, (height - 1) / 2 - 1);
		System.arraycopy(verticalLine, 0, result, 1, verticalLine.length);
		
		result[(height - 1) / 2] = line(offset, width);
		
		verticalLine = verticalLine(offset + width - 1, 1, (height - 1) / 2 - 1);
		System.arraycopy(verticalLine, 0, result, (height - 1) / 2 + 1, verticalLine.length);
		
		result[height - 1] = line(offset, width);
	
		return result;
	}

	public static String[] six(int offset, int width, int height) {
		//line + vertical + line + double + line
		String[] result = new String[height];
		result[0] = line(offset, width);

		String[] verticalLine = verticalLine(offset, width, (height - 1) / 2 - 1);
		System.arraycopy(verticalLine, 0, result, 1, verticalLine.length);
		
		result[(height - 1) / 2] = line(offset, width);
		
		verticalLine = twoVerticalLines(offset, width, (height - 1) / 2 - 1);
		System.arraycopy(verticalLine, 0, result, (height - 1) / 2 + 1, verticalLine.length);
		
		result[height - 1] = line(offset, width);
	
		return result;
	}

	public static String[] seven(int offset, int width, int height) {
		//line + vertical + line + vertical
		String[] result = new String[height];
		result[0] = line(offset, width);

		String[] verticalLine = twoVerticalLines(offset, width, (height - 1) / 2);
		System.arraycopy(verticalLine, 0, result, 1, verticalLine.length);
		
		verticalLine = verticalLine(offset + width - 1, 1, (height - 1) / 2);
		System.arraycopy(verticalLine, 0, result, (height - 1) / 2 + 1, verticalLine.length);
	
		return result;
	}

	public static String[] eight(int offset, int width, int height) {
		String[] result = new String[height];
		String[] zero = zero(offset, width, height);
		System.arraycopy(zero, 0, result, 0, zero.length);
		result[(height - 1) / 2] = line(offset, width);
	
		return result;
	}

	public static String[] nine(int offset, int width, int height) {
		String[] result = new String[height];
		result[0] = line(offset, width);

		String[] verticalLine = twoVerticalLines(offset, width, (height - 1) / 2 - 1);
		System.arraycopy(verticalLine, 0, result, 1, verticalLine.length);
		
		result[(height - 1) / 2] = line(offset, width);
		
		verticalLine = verticalLine(offset + width - 1, 1, (height - 1) / 2);
		System.arraycopy(verticalLine, 0, result, (height - 1) / 2 + 1, verticalLine.length);
	
		return result;
	}

	public static void displayStrings(String[] strings) {
		for (int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
	}
}