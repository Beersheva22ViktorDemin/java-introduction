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
}
