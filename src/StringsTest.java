import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringsTest {

	@Test
	void test() {
		assertTrue(Strings.isAnagram("anagram", "gramana"));
		assertFalse(Strings.isAnagram("anagram", "graman"));
		assertFalse(Strings.isAnagram("anagram", "gramans"));
	}
}
