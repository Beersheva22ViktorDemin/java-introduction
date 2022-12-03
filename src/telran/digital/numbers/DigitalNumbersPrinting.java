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

	public static String[] verticalLine(int offset, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL;
		}
		return res;
	}

	public static String[] twoVerticalLines(int offset, int width, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width - 2) + SYMBOL;
		}
		return res;
	}

	public static String[] zero(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String[] lines = twoVerticalLines(offset, width, height - 2);
		System.arraycopy(lines, 0, res, 1, lines.length);
		res[height - 1] = line(offset, width);
		return res;
	}
	
	public static String [] one(int offset, int width, int height) {
		return verticalLine(offset + width - 1, height);
	}

	public static String[] eight(int offset, int width, int height) {
		String[] res = zero(offset, width, height);
		int heightPart = heightPart(height);
		res[heightPart] = line(offset, width);
		return res;

	}

	public static String[] two(int offset, int width, int height) {
		String res[] = eight(offset, width, height);
		int heightPart = heightPart(height);
		cleanLinePart(res, offset, 1, heightPart);
		cleanLinePart(res, offset + width - 1, heightPart + 1, height - 1);
		return res;
	}

	public static String[] five(int offset, int width, int height) {
		String res[] = eight(offset, width, height);
		int heightPart = heightPart(height);
		cleanLinePart(res, offset + width - 1, 1, heightPart);
		cleanLinePart(res, offset, heightPart + 1, height - 1);
		return res;
	}

	public static String[] nine(int offset, int width, int height) {
		String res[] = eight(offset, width, height);
		int heightPart = heightPart(height);
		cleanLinePart(res, offset, heightPart + 1, height - 1);
		return res;
	}

	public static String[] six(int offset, int width, int height) {
		String res[] = eight(offset, width, height);
		int heightPart = heightPart(height);
		cleanLinePart(res, offset + width - 1, 1, heightPart);

		return res;
	}

	public static String[] seven(int offset, int width, int height) {
		String res[] = one(offset, width, height);
		res[0] = line(offset, width);
		return res;
	}

	public static String[] three(int offset, int width, int height) {
		String res[] = eight(offset, width, height);
		int heightPart = heightPart(height);
		cleanLinePart(res, offset, 1, heightPart);
		cleanLinePart(res, offset, heightPart + 1, height - 1);
		return res;
	}

	public static String[] four(int offset, int width, int height) {
		String res[] = twoVerticalLines(offset, width, height);
		int heightPart = heightPart(height);
		res[heightPart] = line(offset, width);
		cleanLinePart(res, offset, heightPart + 1, height);
		return res;
	}

	public static void displayStrings(String[] strings) {
		for (int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
	}

	private static int heightPart(int height) {
		int delta = height % 2 == 0 ? 1 : 0;
		int heightPart = height / 2 - delta;
		return heightPart;
	}

	private static void cleanLinePart(String line[], int position, int indexFrom, int height) {

		for (int i = indexFrom; i < height; i++) {
			char[] arLine = line[i].toCharArray();
			arLine[position] = ' ';
			line[i] = new String(arLine);
		}
	}
}