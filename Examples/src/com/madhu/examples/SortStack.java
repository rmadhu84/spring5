/**
 * 
 */
package com.madhu.examples;

import java.util.Stack;

/**
 * @author ramachandranm1
 *
 */
public class SortStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> input = new Stack<Integer>();
		input.push(1);
		input.push(34);
		input.push(20);
		input.push(15);
		input.push(10);

		Stack<Integer> result = sort(input);
		while (!result.empty())
			System.out.println(result.pop());

	}

	private static Stack<Integer> sort(Stack<Integer> input) {
		// TODO Auto-generated method stub

		Stack<Integer> tmpStack = new Stack<Integer>();
		while (!input.empty()) {
			int tmp = input.pop();
			while (!tmpStack.empty() && tmpStack.peek() > tmp) {
				input.push(tmpStack.pop());
			}
			tmpStack.push(tmp);
		}
		return tmpStack;
	}

}
