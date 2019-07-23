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
			int k = a[lastSortedIndex];
			int i;
			for (i = lastSortedIndex; i > 0 && a[i - 1] > k; i--) {
				a[i] = a[i - 1];
			}
			a[i] = k;
		}
		printArray("Sorted Array: %s", a);
	}

	static void printArray(String m, int[] a) {
		System.out.println(String.format(m, Arrays.toString(a)));
	}

}
