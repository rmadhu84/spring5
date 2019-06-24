/**
 * 
 */
package com.madhu.examples;

/**
 * @author ramachandranm1
 *
 */
public class ArrayMinAndSecondMin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {23,54,12,98,77,14,66,113,44,13};
		print2Smallest(arr);

	}

	private static void print2Smallest(int[] arr) {
		int second, first;
		int arr_size = arr.length;
		// TODO Auto-generated method stub
		first = second = Integer.MAX_VALUE;
		for(int a:arr) {
			if(a < first) {
				second = first;
				first = a;
				
			}
			else if(a < second && a > first)
				second = a;
		}
		
		System.out.println("The smallest element is " + first +" and the second smallest element is " + second);
	}

}
