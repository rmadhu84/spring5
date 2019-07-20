package com.madhu.practice.Arrays;

import java.util.Arrays;

public class BubbleSort {
	static boolean swapped = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inputArr = {26,52,35,11,10};
		
		System.out.println("Input :" + Arrays.toString(inputArr));
		
		int unsortedPartionindex = inputArr.length - 1;

		for (;unsortedPartionindex > 0; unsortedPartionindex--) {
			swapped = false;
			for (int i = 0; i < unsortedPartionindex; i++) {
				//System.out.println(Arrays.toString(inputArr));
				if (inputArr[i] > inputArr[i + 1]) {
					inputArr = swap(inputArr, i, i + 1);
				}
			}
			
			//System.out.println(String.format("Swapped : %b", swapped));
//			System.out.println(Arrays.toString(inputArr));
			if(!swapped)
				break;
		}
	
		System.out.println("Sorted Array: " + Arrays.toString(inputArr));
	}

	private static int[] swap(int[] inputArr, int i, int j) {
		int temp = inputArr[j];
		inputArr[j] = inputArr[i];
		inputArr[i] = temp;
		swapped = true;
		return inputArr;
	}

}
