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
		int index = Arrays.binarySearch(arraySorted, number);
		if (index < 0) {
			index = -(index + 1);
		}
		return insertAtIndex(arraySorted, number, index);
		
	}
	
	private static int[] insertAtIndex(int[] array, int number, int index) {
		int res[] = new int[array.length + 1];
		System.arraycopy(array, 0, res, 0, index);
		res[index] = number;
		System.arraycopy(array, index, res, index + 1, array.length - index);
		return res;
	}
	
	/**
	 * 
	 * @param arraySorted
	 * @param number
	 * @return index value if number exists otherwise -1
	 * O[N] - search number in unsorted array
	 * O[LogN] - search number in sorted (binary search)
	 */
	public static int binarySearch(int arraySorted[], int number) {
		int left = 0;
		int right = arraySorted.length - 1;
		while(left < right) {			
			int middle = left + ((right-left) / 2);
			if (number <= arraySorted[middle]) {
				right = middle;
			} else {
				left = middle + 1;
			}
		}
		
		return arraySorted[left] != number ? -(left + 1) : left;
	}
	
	public static boolean isSorted(int[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isOneSwapForSorted(int[] array) {		
		int first = 0, second = 0;
		int count = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {
				count++;
				if (first == 0)
					first = i;
				else
					second = i;
			}
		}
		
	    // If there are more than two elements
	    // are out of order.
	    if (count > 2) {
	    	return false;
	    }
	 
	    // If all elements are sorted already
	    if (count == 0) {
	    	return false;
	    }
	 
	    int[] swappedArray = new int[array.length];
	    System.arraycopy(array, 0, swappedArray, 0, array.length);
	    // Cases like {1, 5, 3, 4, 2}
	    // We swap 5 and 2.
	    if (count == 2) {
	    	swapElements(array, first - 1, second);
	    }
	    // Cases like {1, 2, 4, 3, 5}
	    else if (count == 1) {
	    	swapElements(array, first - 1, first);
	    }
		
		return isSorted(array);
	}
	
	public static void bubbleSort(int[] array) {
		boolean isSwapped = false;
		do {
			isSwapped = moveGreaterRight(array);;
		} while(isSwapped);
	}
	
	private static boolean moveGreaterRight(int[] array) {
		boolean isSwapped = false;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				swapElements(array, i, i + 1);
				isSwapped = true;
			}
		}
		
		return isSwapped;
	}
	
	private static void swapElements(int[] array, int key1, int key2) {
		int buffer = array[key1];
		array[key1] = array[key2];
		array[key2] = buffer;
	}
}

