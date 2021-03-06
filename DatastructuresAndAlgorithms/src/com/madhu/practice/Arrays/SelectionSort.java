/**
 * 
 */
package com.madhu.practice.Arrays;

import java.util.Arrays;

/**
 * @author Madhu
 *
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] inputArr = {1,2,3,4,5,7,6};
		int unsortedPartitionIndex = inputArr.length-1;
		//System.out.println(inputArr[LargestIndex(inputArr, unsortedPartitionIndex)]);
		System.out.println(Arrays.toString(inputArr));
		for(;unsortedPartitionIndex > 0; unsortedPartitionIndex--) {
			
			int largestIndex = LargestIndex(inputArr, unsortedPartitionIndex);
			System.out.println(String.format("UnSorted Partition index = %d, Largest index = %d", unsortedPartitionIndex, largestIndex));
			swap(inputArr, largestIndex, unsortedPartitionIndex);
		}
		
//		System.out.println(Arrays.toString(inputArr));
	}

	private static int[] swap(int[] inputArr, int i, int j) {
//		System.out.println(String.format("Swapping value of %d and %d", i, j));
		int temp = inputArr[j];
		inputArr[j] = inputArr[i];
		inputArr[i] = temp;
		System.out.println(Arrays.toString(inputArr));
		return inputArr;
	}

	private static int LargestIndex(int[] inputArr, int unsortedPartitionIndex) {
		int largest = 0;
		for (int i = 1; i <= unsortedPartitionIndex; i++) {
			if(inputArr[i] > inputArr[largest]) {
				largest = i;
			}
		}
		return largest;
	}
}
