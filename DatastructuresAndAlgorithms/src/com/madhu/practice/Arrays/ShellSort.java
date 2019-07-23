package com.madhu.practice.Arrays;

import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {

		int[] a = { 20, 35, -15, 7, 55, 1, -22 };
		printArray(a);
		int gap = 3;
		int len = a.length - 1;
		for (; gap >= 1; gap = gap / 2) {
			int i;
			int k = a[gap];
			for (i = gap; i <= len; i++) {
				k = a[i];
				int j;
				for (j = i; j - gap >= 0 && k < a[j - gap]; j = j - gap) {
					a[i] = a[j - gap];
					printArray(a);
				}
				a[j] = k;
				printArray(a);
			}
		}

	}

	static void printArray(int[] a) {
		System.out.println(Arrays.toString(a));
	}

}
