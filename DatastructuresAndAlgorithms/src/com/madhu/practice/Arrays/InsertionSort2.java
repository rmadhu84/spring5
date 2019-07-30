package com.madhu.practice.Arrays;

import java.util.Arrays;

/**
 * 
 * @author Madhu Modified the Original using the one from the video. :)
 *
 */
public class InsertionSort2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 20, 35, -15, 7, 55, -22 };

		int lastIndex = a.length;
		printArray("Input Array: %s", a);
		for (int lastSortedIndex = 1; lastSortedIndex < lastIndex; lastSortedIndex++) {
			int k = a[lastSortedIndex]; //Element to be inserted in its proper place in the sorted array.
			int i;
			/*Finding the insertion point. The loop will continue, as long as "i" is not at the last element and element ahead of "i" is greater than "k".
			 * The loop will exit when "i" reaches zero or "i-1"th element is less than "k". 
			 *
			 */
			for (i = lastSortedIndex; i > 0 && a[i - 1] > k; i--) {
				a[i] = a[i - 1];
				printArray("Partially Sorted %s", a);
			}
			a[i] = k;
			printArray("Partially Sorted %s", a);
		}
		printArray("Sorted Array: %s", a);
	}

	static void printArray(String m, int[] a) {
		System.out.println(String.format(m, Arrays.toString(a)));
	}

}
