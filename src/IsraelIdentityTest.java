import static org.junit.jupiter.api.Assertions.*;
import static org.testng.Assert.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class IsraelIdentityTest {

	@Test
	void verifyTest() {
		assertTrue(IsraelIdentity.verify(123456782));
		assertFalse(IsraelIdentity.verify(123456789));
		assertTrue(IsraelIdentity.verify(519444129));
		assertFalse(IsraelIdentity.verify(519444128));
		assertTrue(IsraelIdentity.verify(636147118));
	}
	
	@Test
	void getChecksumTest() {
		assertEquals(2, IsraelIdentity.getChecksum(12345678));
		assertEquals(9, IsraelIdentity.getChecksum(51944412));
		assertEquals(8, IsraelIdentity.getChecksum(63614711));
	}
	
	@Test
	void generateRandomIdTest() {
		for (int i = 0; i < 20000; i++) {
			int id = IsraelIdentity.generateRandomId();
			assertTrue(IsraelIdentity.verify(id), String.valueOf(id));
		}
	}
}
