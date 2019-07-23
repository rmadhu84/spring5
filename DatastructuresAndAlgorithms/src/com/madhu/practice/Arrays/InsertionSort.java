package com.madhu.practice.Arrays;

import java.util.Arrays;

/**
 * 
 * @author Madhu
 *
 */
public class InsertionSort {
	
	

	public static void main(String[] args) {
		int[] a = { 20, 35, -15, 7, 55, -22 };

		int lastSortedIndex = 0;
		int lastIndex = a.length - 1;
		for (int b = lastSortedIndex + 1; b <= lastIndex; b++) {
			if (a[b] > a[lastSortedIndex]) {
				lastSortedIndex++;
				continue;
			} else {
				int k = a[b];
				for (int i = lastSortedIndex; i >= 0; i--) {
					printArray(a);
					if (i == 0) {
						a[i + 1] = a[i];
						a[i] = k;
					}else if(a[i] <=k) {
						a[i+1] = a[i];
						a[i] = k;
					}
					else if (a[i] > k) {
						a[i + 1] = a[i];
					}
				}
				lastSortedIndex++;
			}
		}
	}
	
	static void printArray(int[] a){
		System.out.println(Arrays.toString(a));
	}

}
