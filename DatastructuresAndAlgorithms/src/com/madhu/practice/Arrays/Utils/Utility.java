/**
 * 
 */
package com.madhu.practice.Arrays.Utils;

/**
 * @author ramachandranm1
 *
 */
public class Utility {

	public int[] swap(int[] inputArr, int i, int j) {
		int temp = inputArr[j];
		inputArr[j] = inputArr[i];
		inputArr[i] = temp;
		return inputArr;
	}
}
