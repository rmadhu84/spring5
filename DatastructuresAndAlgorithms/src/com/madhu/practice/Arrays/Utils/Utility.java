/**
 * 
 */
package com.madhu.practice.Arrays.Utils;

import java.util.Arrays;

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
	
	public void printArray(String message, int[] a) {
		
		System.out.println(String.format("%s : %s", message, Arrays.toString(a)));
	}

}
