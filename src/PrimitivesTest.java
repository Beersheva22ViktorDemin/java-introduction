import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PrimitivesTest {

	@Test
	void test() {
		int a;
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				for (int k = 1; k < 10; k++) {
					a = i * 100 + j * 10 + k;
					assertEquals(k, getThirdNumber(a));
					assertEquals(j, getSecondNumber(a));
					assertEquals(i, getFirstNumber(a));
				}
			}

		}
	
	}

	private int getThirdNumber(int number) {
		return number % 10;
	}

	private int getSecondNumber(int number) {
		return (number / 10) % 10;

	}

	private int getFirstNumber(int number) {
		return (number / 100) % 10;
		
	}
}
