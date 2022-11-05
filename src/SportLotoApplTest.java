import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class SportLotoApplTest {

	@Test
	void saveValue() {
		assertEquals(2, SportLotoAppl.saveValue(SportLotoAppl.INIT, 1));
		assertEquals(4, SportLotoAppl.saveValue(SportLotoAppl.INIT, 2));
		assertEquals(8, SportLotoAppl.saveValue(SportLotoAppl.INIT, 3));
	}
	
	@Test
	void isValueExists() {
		assertEquals(false, SportLotoAppl.isValueExists(0, 1));
		assertEquals(true, SportLotoAppl.isValueExists(2, 1));
		assertEquals(true, SportLotoAppl.isValueExists(4, 2));
		assertEquals(true, SportLotoAppl.isValueExists(5, 0));
		assertEquals(true, SportLotoAppl.isValueExists(6, 1));
		assertEquals(true, SportLotoAppl.isValueExists(6, 2));
		assertEquals(false, SportLotoAppl.isValueExists(6, 20));
	}
}
