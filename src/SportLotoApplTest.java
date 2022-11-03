import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class SportLotoApplTest {

	@Test
	void saveValue() {
		assertEquals(49L, SportLotoAppl.saveValue(SportLotoAppl.INIT, 0, 49));
		assertEquals(4900L, SportLotoAppl.saveValue(SportLotoAppl.INIT, 1, 49));
		assertEquals(4949L, SportLotoAppl.saveValue(49, 1, 49));
		assertNotEquals(4900L, SportLotoAppl.saveValue(4900, 1, 49)); //method can't rewrite values
		assertEquals(490000L, SportLotoAppl.saveValue(SportLotoAppl.INIT, 2, 49));
	}
	
	@Test
	void pow10Test() {
		assertEquals(1, SportLotoAppl.pow10(0));
		assertEquals(10, SportLotoAppl.pow10(1));
		assertEquals(100, SportLotoAppl.pow10(2));
		assertEquals(1000, SportLotoAppl.pow10(3));
	}
	
	@Test
	void isValueExists() {
		assertEquals(false, SportLotoAppl.isValueExists(0, 1));
		assertEquals(true, SportLotoAppl.isValueExists(1, 1));
		assertEquals(true, SportLotoAppl.isValueExists(49, 49));
		assertEquals(true, SportLotoAppl.isValueExists(4900, 49));
		assertEquals(true, SportLotoAppl.isValueExists(4935, 49));
		assertEquals(true, SportLotoAppl.isValueExists(4935, 35));
		assertEquals(false, SportLotoAppl.isValueExists(0, 0));
	}
}
