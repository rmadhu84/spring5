/**
 * 
 */
package com.madhu.examples;

import java.util.Arrays;

/**
 * @author Madhu
 *
 */
public class ZeroSumCombination {

	/**
	 * @param args
	 */
	// TODO Auto-generated method stub
	static Boolean found = false;

	static void combinationUtil(int arr[], int data[], int start, int end, int index, int r) {
		// Current combination is ready to be printed, print it
		if (index == r) {
			printArray(data);
			int sum = Arrays.stream(data).sum();
			System.out.println(String.format("Sum of data = %d", sum));
			if (!found && sum == 0) {
				found = true;
				System.out.println("A zero sum combination exists");
			}
			return;
		}

		// replace index with all possible elements. The condition
		// "end-i+1 >= r-index" makes sure that including one element
		// at index will make a combination with remaining elements
		// at remaining positions
		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			if (!found) {
				data[index] = arr[i];
				System.out.println(String.format("i=%d, start=%d, end=%d, r=%d, index=%d", i, start, end, r, index));
				combinationUtil(arr, data, i + 1, end, index + 1, r);
			}

		}
	}

	// The main function that prints all combinations of size r
	// in arr[] of size n. This function mainly uses combinationUtil()
	static void printCombination(int arr[], int n, int r) {
		// A temporary array to store all combination one by one
		int data[] = new int[r];

		// Print all combination using temprary array 'data[]'j
		combinationUtil(arr, data, 0, n - 1, 0, r);
		if (!found) {
			System.out.println("A zero sum combination does not exists");
		}
	}

	static void printArray(int[] data) {
		System.out.println(Arrays.toString(data));
	}

	/* Driver function to check for above function */
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, -4, 5 };
		int r = 3;
		int n = arr.length;
		printCombination(arr, n, r);
	}
}