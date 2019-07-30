package com.madhu.practice.Arrays;

import java.util.Arrays;

import com.madhu.practice.Arrays.Utils.Utility;

public class BubbleShellSort {
	static Boolean swapped = false;

	public static void main(String[] args) {

		Utility util = new Utility();

		int[] a = { 20, 35, -15, 7, 55, -22, 1 };

		util.printArray("Unsorted Array", a);
		int len = a.length;

		for (int gap = len / 2; gap > 0; gap = gap / 2) {
			for (int i = gap; i < len; i++) {
				for (int j = i; j - gap >= 0 && a[j]<a[j-gap]; j = j - gap) {
						swap(a, j, j - gap);
						util.printArray("Partial Sorted Array", a);
				}
			}
		}

		util.printArray("Sorted Array", a);
	}

	private static int[] swap(int[] inputArr, int i, int j) {
		System.out.println(String.format("Swapping the locations of %d and %d", inputArr[i], inputArr[j]));
		int temp = inputArr[j];
		inputArr[j] = inputArr[i];
		inputArr[i] = temp;
		swapped = true;
		return inputArr;
	}
}
