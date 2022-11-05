public class SportLotoAppl {
	
	public static final long INIT = 0L;

	/**
	 * Application displays out 6 random numbers from 1 to 49 inclusive numbers can
	 * not be repeated in a sequence of 6 random numbers no additional collections /
	 * arrays
	 */
	public static void main(String[] args) {	
		int value = 0;
		long storage = INIT;
		for (int i = 0; i < 6; i++) {
			value = getUniqueRandomValue(storage);
			storage = saveValue(storage, value);
			System.out.print(value + " ");
		}
	}

	private static int getUniqueRandomValue(long storage) {
		int value;
		do {
			value = getRandomInt(1, 49);
		} while (BitOperations.getBitValue(storage, value) > 0);
		return value;
	}

	public static int getRandomInt(int min, int max) {
		return (int)(min + Math.random() * (max - min + 1));
	}
	
	public static long saveValue(long storage, int value) {
		storage = BitOperations.setBitValue(storage, value, true);
		
		return storage;
	}
}
