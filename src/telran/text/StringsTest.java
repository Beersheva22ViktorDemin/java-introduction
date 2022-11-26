package telran.text;
import static org.junit.jupiter.api.Assertions.*;

import static telran.text.Strings.*;
import org.junit.jupiter.api.*;

class StringsTest {

	@Test
	void isAnagramTest() {
		assertTrue(Strings.isAnagram("anagram", "gramana"));
		assertFalse(Strings.isAnagram("anagram", "graman"));
		assertFalse(Strings.isAnagram("anagram", "gramans"));

		String word = "yellow";
		assertTrue(Strings.isAnagram(word, "loweyl")); 
		assertTrue(Strings.isAnagram(word, "elolyw")); 
		assertTrue(Strings.isAnagram(word, "wolley")); 
		assertTrue(Strings.isAnagram(word, "loleyw")); 
		assertTrue(Strings.isAnagram("yttttoooo", "ooootttty"));
		assertFalse(Strings.isAnagram(word,"")); 
		assertFalse(Strings.isAnagram(word, "yellob")); 
		assertFalse(Strings.isAnagram(word,"yello")); 
		assertFalse(Strings.isAnagram(word,"yelllo")) ;
		assertFalse(Strings.isAnagram(word, "wolkez"));
		assertFalse(Strings.isAnagram(word, "yeooow"));
		assertFalse(Strings.isAnagram("yttttoooo", "yoootttty"));

	}

	@Test
	void sortStringNumbersTest() {
		String[][][] dataProvider = { 
				{ { "-1", "1" }, { "-1", "1" } },
				{ { "1", "-1", "1", "-1" }, { "-1", "-1", "1", "1"} },
				{ { "1", "127", "2", "-128", "-1", "0" }, { "-128", "-1", "0", "1", "2", "127"} },
				};
		for (String[][] line : dataProvider) {
			Strings.sortStringNumbers(line[0]);
			assertArrayEquals(line[1], line[0]);
		}
	}
	
	@Test
	void javaVariableTest() {
		assertTrue("java".matches(Strings.javaNameExp()));
		assertFalse("1java".matches(Strings.javaNameExp()));
		assertFalse("_".matches(Strings.javaNameExp()));
		assertTrue("__".matches(Strings.javaNameExp()));
		assertTrue("java_1_2".matches(Strings.javaNameExp()));
		assertTrue("$".matches(Strings.javaNameExp()));
		assertFalse("$ _".matches(Strings.javaNameExp()));	
	}
	
	@Test
	void ipV4OctetTest() {
		assertTrue("000".matches(Strings.ipV4Octet()));
		assertTrue("0".matches(Strings.ipV4Octet()));
		assertTrue("1".matches(Strings.ipV4Octet()));
		assertTrue("12".matches(Strings.ipV4Octet()));
		assertTrue("159".matches(Strings.ipV4Octet()));
		assertTrue("255".matches(Strings.ipV4Octet()));
		assertFalse("256".matches(Strings.ipV4Octet()));
		assertFalse("265".matches(Strings.ipV4Octet()));
		assertFalse("355".matches(Strings.ipV4Octet()));
		assertFalse("not ip".matches(Strings.ipV4Octet()));
		assertFalse("-1".matches(Strings.ipV4Octet()));
	}
	
	@Test
	void ipV4Test() {
		assertTrue("192.168.0.1".matches(Strings.ipV4()));
		assertTrue("0.0.0.0".matches(Strings.ipV4()));
		assertTrue("255.255.255.255".matches(Strings.ipV4()));
		assertFalse("0d0.0.0".matches(Strings.ipV4()));
		assertFalse("not ip".matches(Strings.ipV4()));
		assertFalse("-1.-1.-1.-1".matches(Strings.ipV4()));
		assertFalse("256.256.256.256".matches(Strings.ipV4()));
		assertFalse("255.255.255255".matches(Strings.ipV4()));
	}
	
	@Test
	void ipV4TestTrue() {
		assertTrue("1.2.3.4".matches(ipV4()));
		assertTrue("199.249.255.209".matches(ipV4()));
		assertTrue("99.99.99.05".matches(ipV4()));
	}
	@Test
	void ipV4TestFalse() {
		assertFalse("*.19.10.10".matches(ipV4()));
		assertFalse("256.19.10.10".matches(ipV4()));
		assertFalse("300.19.10.10".matches(ipV4()));
		assertFalse("255.19.10".matches(ipV4()));
		assertFalse("255.19.10.10.".matches(ipV4()));
		assertFalse("255.19".matches(ipV4()));
	}
	@Test
	void computeExpressionTest() {
		assertEquals(10.5, computeArithmenticExpression("2 + 2 + 1 * 2 + 0.5", null, null));
		assertTrue(Double.isNaN(computeArithmenticExpression("2 # 2 ++ 10", null, null)));
		assertEquals(10.5, computeArithmenticExpression("a + 2 + c * 2 + 0.5", new double[] {2, 1},
				new String[] {"a", "c"}));
		assertTrue(Double.isNaN(computeArithmenticExpression("a + 2 + c * 2 + d23", new double[] {2, 1},
				new String[] {"a", "c"})));
	}
}
