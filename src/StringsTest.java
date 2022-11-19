import static org.junit.jupiter.api.Assertions.*;

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
		assertFalse(Strings.isAnagram(word, ""));
		assertFalse(Strings.isAnagram(word, "yellob"));
		assertFalse(Strings.isAnagram(word, "yello"));
		assertFalse(Strings.isAnagram(word, "yelllo"));

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
}
