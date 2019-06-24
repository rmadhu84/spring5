/**
 * 
 */
package com.madhu.examples;

import java.util.Stack;

/**
 * @author ramachandranm1
 *
 */
public class StackEvaluatePostFixNotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exp = "312+*";
		System.out.println(calculate(exp));

	}

	private static int calculate(String exp) {
		// TODO Auto-generated method stub

		Stack<Integer> stack = new Stack();

		int len = exp.length();
		for (int i = 0; i < len; i++) {
			char c = exp.charAt(i);
			if (Character.isDigit(c)) {
				stack.push(Integer.parseInt(String.valueOf(c)));
			} else {
				int a = stack.pop();
				int b = stack.pop();

				switch (c) {
				case '+': {
					stack.push(a + b);
					break;
				}

				case '-':{
					stack.push(a - b);
					break;
				}
				case '*':{
					stack.push(a * b);
					break;
				}
				case '/':{
					stack.push(a / b);
					break;
					}
				}
			}
		}

		return stack.pop();
	}

}
