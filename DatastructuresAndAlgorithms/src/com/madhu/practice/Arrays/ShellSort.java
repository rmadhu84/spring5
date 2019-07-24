package com.madhu.practice.Arrays;

import java.util.Arrays;

/**
 * This is shell sort optimizing the insertion sort.
 * @author ramachandranm1
 * 
 *
 */
public class ShellSort {

	static int lineNo = 0;
	public static void main(String[] args) {

		int[] a = { 20, 35, -15, 7, 55, -22, 1};
		printArray(a);
		int gap = a.length / 2;
		int len = a.length - 1;
		for (; gap >= 1; gap = gap / 2) {
			System.out.println(String.format("Gap = %d", gap));
			int i;
			int k = a[gap];
			for (i = gap; i <= len; i++) {
				k = a[i];
				int j;
				for (j = i; j - gap >= 0 && k < a[j - gap]; j = j - gap) {
					a[j] = a[j - gap];
					//printArray(a);
				}
				a[j] = k;
				printArray(a);
			}
		}

	}

	static void printArray(int[] a) {
		
		System.out.println(String.format("Line %d : %s", lineNo++, Arrays.toString(a)));
	}

}
