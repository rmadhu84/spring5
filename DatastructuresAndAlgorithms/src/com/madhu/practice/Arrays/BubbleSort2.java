package com.madhu.practice.Arrays;

import java.util.Arrays;

/**
 *  @author ramachandranm1
 *  This is a condensed version of BubbleSort.java
 *
 */
public class BubbleSort2 {
	static boolean swapped = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inputArr = {26,52,35,11,10};
		System.out.println("Input :" + Arrays.toString(inputArr));
		int unsortedPartionindex = inputArr.length - 1;
		for (;unsortedPartionindex > 0; unsortedPartionindex--) {
			swapped = false;
			for (int i = 0; i < unsortedPartionindex; i++) {
//				System.out.println(Arrays.toString(inputArr));
				if (inputArr[i] > inputArr[i + 1]) {
					int temp = inputArr[i + 1];
					inputArr[i + 1] = inputArr[i];
					inputArr[i] = temp;
					swapped = true;
				}
			}
//			System.out.println(String.format("Swapped : %b", swapped));
			if(!swapped)
				break;
		}
		System.out.println("Sorted Array: " + Arrays.toString(inputArr));
	}
}
