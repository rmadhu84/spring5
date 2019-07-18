/**
 * 
 */
package com.madhu.examples;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Madhu
 *
 */
public class CombinationsInASet {

	/**
	 * @param args
	 */
	/* arr[]  ---> Input Array 
    data[] ---> Temporary array to store current combination 
    start & end ---> Staring and Ending indexes in arr[] 
    index  ---> Current index in data[] 
    r ---> Size of a combination to be printed */
	static void combinationUtil(int arr[], int data[], int start, int end, int index, int r) {
		// Current combination is ready to be printed, print it
		if (index == r) {
			printArray(data);
			return;
		}

		// replace index with all possible elements. The condition
		// "end-i+1 >= r-index" makes sure that including one element
		// at index will make a combination with remaining elements
		// at remaining positions
		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			data[index] = arr[i];
//			printArray(data);
			System.out.println(String.format("i=%d, start=%d, end=%d, r=%d, index=%d",i, start, end, r, index));
			//combinationUtil(arr, data, start, end, index, r);
			combinationUtil(arr, data, i + 1, end, index + 1, r);
		}
	}

	// The main function that prints all combinations of size r
	// in arr[] of size n. This function mainly uses combinationUtil()
	static void printCombination(int arr[], int n, int r) {
		// A temporary array to store all combination one by one
		int data[] = new int[r];

		// Print all combination using temprary array 'data[]'j
		combinationUtil(arr, data, 0, n - 1, 0, r);
	}

	static void printArray(int[] data) {
		System.out.println(Arrays.toString(data));
	}
	
	/* Driver function to check for above function */
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int r = 3;
		int n = arr.length;
		printCombination(arr, n, r);
	}
}