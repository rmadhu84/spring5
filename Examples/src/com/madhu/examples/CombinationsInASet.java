/**
 * 
 */
package com.madhu.examples;

/**
 * @author Madhu
 *
 */
public class CombinationsInASet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3};
		for(int i = 0; i<arr.length;i++) {
			for(int j = i+1;j<arr.length;j++) {
				if(j>arr.length)
					j=0;
				else if(j==i)
					break;
				System.out.println(arr[i]+","x);
			}
		}
	}

}
