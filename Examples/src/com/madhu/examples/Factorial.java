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
		System.out.println(String.format("Factorial of %d is %f", input, factorial(input)));
	}

	private static double factorial(int input) {

		if (input == 1 || input == 0) {
			System.out.print(String.format("%d", input));
			System.out.println("");
			return 1;
		} else {
			System.out.print(String.format("%d * ", input));
			return (input * factorial(--input));
		}
	}

}
