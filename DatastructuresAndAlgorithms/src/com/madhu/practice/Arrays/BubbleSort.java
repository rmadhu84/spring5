package com.madhu.practice.Arrays;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inputArr = { 1, 6, 3, 2, 5 };

		int unsortedPartionindex = inputArr.length - 1;

		for (int a = 0; a <= unsortedPartionindex; a++) {
			for (int i = 0; i <= unsortedPartionindex - 1; i++) {
				System.out.println(Arrays.toString(inputArr));
				if (inputArr[i] > inputArr[i + 1]) {
					inputArr = swap(inputArr, i, i + 1);
				}
				if (i == unsortedPartionindex)
					unsortedPartionindex--;
			}
			System.out.println(Arrays.toString(inputArr));
		}
	}

	private static int[] swap(int[] inputArr, int i, int j) {
		int temp = inputArr[j];
		inputArr[j] = inputArr[i];
		inputArr[i] = temp;
		return inputArr;
	}

}
