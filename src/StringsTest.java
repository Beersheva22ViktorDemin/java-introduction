import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

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
}
