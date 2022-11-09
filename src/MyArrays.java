import java.util.Arrays;

public class MyArrays {
	/**
	 * 
	 * @param array
	 * @param number
	 * @return new array with added at end a given number
	 */
	public static int[] addsNumber(int[] array, int number) {
		// use standard class Arrays, method copyOf
		int[] result = Arrays.copyOf(array, array.length + 1);
		result[array.length] = number;
		
		return result;
	}
	
	/**
	 * 
	 * @param array
	 * @param index
	 * @return new array with no number at a given index in a given array
	 * if index doesn't exist in a given array it returns the same array
	 */
	public static int[] removeNumber(int array[], int index) {
		// use standard class System, method arraycopy
		int[] result;
		if (index < array.length) {
			result = new int[array.length - 1];
			System.arraycopy(array, 0, result, 0, index);
			System.arraycopy(array, index + 1, result, index, result.length - index);
		} else {
			result = array;
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param arraySorted - sorted array
	 * @param number
	 * @return new array with inserted number at an index for keeping array sorted
	 */
	public static int[] insertSorted(int arraySorted[], int number) {
		// use the method binarySearch of the standard class Arrays
		// use the method arraycopy of the standard class System
		int[] result = new int[arraySorted.length + 1];
		int index = Arrays.binarySearch(arraySorted, number);
		if (index < 0) {
			//-(insertion point) - 1)
			index = -index - 1;
		}
		System.arraycopy(arraySorted, 0, result, 0, index);
		result[index] = number;
		System.arraycopy(arraySorted, index, result, index + 1, arraySorted.length - index);
		
		return result;
	}
}

