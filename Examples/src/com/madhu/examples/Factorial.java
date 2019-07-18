/**
 * 
 */
package com.madhu.examples;

import java.io.Console;
import java.util.Scanner;

/**
 * @author ramachandranm1
 *
 */
public class Factorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		System.out.println(String.format("Factorial of %d is %d", input, factorial(input)));
	}
	
	static int factorial(int n) {
		int result = 1;
		while(n>0) {
			System.out.println(n);
			result = result*n;
			n--;
		}
		return result;
	}
	
	static int factorialWithRecursion(int n) {
		
		 
		
		while (n!=1) {
			return factorialWithRecursion(n-1) ;
		}
		
		}

}
