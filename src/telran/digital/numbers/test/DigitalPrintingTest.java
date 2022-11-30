package telran.digital.numbers.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static telran.digital.numbers.DigitalNumbersPrinting.*;

public class DigitalPrintingTest {
	@Test
	@Disabled
	void lineTest() {
		System.out.println(line(30, 30));
	}

	@Test
	@Disabled
	void verticalLineTest() {
		displayStrings(verticalLine(30, 1, 5));
	}

	@Test
	@Disabled
	void twoVerticalLinesTest() {
		displayStrings(twoVerticalLines(30, 10, 5));
	}

	@Test
	@Disabled
	void zeroTest() {
		displayStrings(zero(30, 5, 4));
	}

	@Test
	@Disabled
	void oneTest() {
		displayStrings(one(30, 5, 4));
	}
	
	@Test
	@Disabled
	void twoTest() {
		displayStrings(two(30, 5, 9));
		displayStrings(two(30, 5, 9));
	}
	
	@Test
	@Disabled
	void threeTest() {
		displayStrings(three(30, 5, 7));
	}
	
	@Test
	@Disabled
	void fourTest() {
		displayStrings(four(30, 5, 7));
	}
	
	@Test
	@Disabled
	void fiveTest() {
		displayStrings(five(30, 5, 9));
	}
	
	@Test
	@Disabled
	void eightTest() {
		displayStrings(eight(30, 5, 7));
	}
	
	@Test
	void test() {
		displayDigitalNumber(1234567890, 5, 5, 7);
//		displayDigitalNumber(1234567890, 5, 5, 6);
	}
}