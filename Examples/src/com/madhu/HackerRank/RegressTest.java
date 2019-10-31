/**
 * 
 */
package com.madhu.HackerRank;

import java.io.Console;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ramachandranm1
 *
 */
public class RegressTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Enter your regex: ");
			String regex = sc.nextLine();
			System.out.println("Enter your string: ");
			String input = sc.nextLine();
			Pattern pattern = Pattern.compile(regex);

			Matcher matcher = pattern.matcher(input);

			boolean found = false;
			while (matcher.find()) {

				System.out.println(String.format("I found the text /Q%s/E starting at index %d and ending at index %d.%n",
						matcher.group(), matcher.start(), matcher.end()));

				found = true;
			}
			if (!found) {
				System.out.println(String.format("No match found.%n"));

			}
		}
	}
}
