/**
 * 
 */
package com.madhu.examples;

/**
 * @author ramachandranm1
 *
 */
public class Recursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(3);
	}
	
	
	static void print(int i) {
		if(i < 1)
			return;
		else {
			System.out.printf(String.format("%d ", i));
			print(i-1);
			System.out.printf(String.format("%d ", i));
			return;
		}
	}

}
