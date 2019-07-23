package com.madhu.practice.Arrays;

import java.util.Arrays;

/**
 * 
 * @author Madhu
 *
 */
public class InsertionSort {
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 20, 35, -15, 7, 55, -22 };

		int lastSortedIndex = 0;
		int lastIndex = a.length - 1;
		printArray("Input Array: %s", a);
		for (int b = lastSortedIndex + 1; b <= lastIndex; b++) {
			if (a[b] > a[lastSortedIndex]) {
				lastSortedIndex++;
				continue;
			} else {
				int k = a[b];
				for (int i = lastSortedIndex; i >= 0; i--) {
					if (i == 0 && a[i] > k) {
						a[i + 1] = a[i];
						a[i] = k;
					}else if(a[i] <=k) {
						a[i+1] = k;
					}
					else if (a[i] > k) {
						a[i + 1] = a[i];
					}
				}
				lastSortedIndex++;
			}
		}
		printArray("Sorted Array: %s", a);
	}
	
	static void printArray(String m, int[] a){
		System.out.println(String.format(m, Arrays.toString(a)) );
	}

}
