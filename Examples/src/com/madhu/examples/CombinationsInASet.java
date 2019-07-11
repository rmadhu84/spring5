/**
 * 
 */
package com.madhu.examples;

/**
 * @author Madhu
 *
 */
public class CombinationsInASet {

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		int n = arr.length;
		int r = arr.length;
		printCominations(arr, n, r);
	

}
/**
 * 
 * @param arr
 * @param n
 * @param r
 */
	private static void printCominations(int[] arr, int n, int r) {
		int[] data = new int[r];
		combinationsUtil(arr, data, 0,n-1, r);
	}
/**
 * 
 * @param arr
 * @param data
 * @param index
 * @param start
 * @param r
 */
	private static void combinationsUtil(int[] arr, int[] data, int index, int start, int r) {
		
	}
}