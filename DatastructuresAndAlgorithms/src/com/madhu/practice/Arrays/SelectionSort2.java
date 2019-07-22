/**
 * 
 */
package com.madhu.practice.Arrays;

import java.util.Arrays;

/**
 * @author Madhu
 * This is a condensed version of SelectionSort.java.
 *
 */
public class SelectionSort2 {

	public static void main(String[] args) {
		int[] inputArr = {1,2,3,4,5,7,6};
		int unsortedPartitionIndex = inputArr.length-1;
		System.out.println(Arrays.toString(inputArr));
		for(;unsortedPartitionIndex > 0; unsortedPartitionIndex--) {
			int largest = 0;
			for (int i = 1; i <= unsortedPartitionIndex; i++) {
				if(inputArr[i] > inputArr[largest]) {
					largest = i;
				}
			}
			int temp = inputArr[unsortedPartitionIndex];
			inputArr[unsortedPartitionIndex] = inputArr[largest];
			inputArr[largest] = temp;
		}
		System.out.println(Arrays.toString(inputArr));
	}

}
