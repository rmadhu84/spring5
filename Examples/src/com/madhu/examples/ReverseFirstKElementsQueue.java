/**
 * 
 */
package com.madhu.examples;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author ramachandranm1
 *
 */
public class ReverseFirstKElementsQueue {

	static Queue<Integer> queue;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		queue = new LinkedList<Integer>();
		for (int i = 10; i <= 100; i = i + 10) {
			queue.add(i);
		}
		int k = 5;
		reverseQueueFirstKElements(k);
		print();

	}

	private static void print() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		while (!queue.isEmpty()) {
			if (str.length() == 0)
				str.append(queue.poll().toString());
			else {
				str.append(",");
				str.append(queue.poll().toString());
			}
		}
		System.out.println(str.toString());
	}

	private static void reverseQueueFirstKElements(int k) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < k; i++) {
			stack.add(queue.poll());
		}

		while (!stack.isEmpty()) {
			queue.add(stack.pop());
		}
		
		for(int i = 0;i<queue.size()-k;i++){
			queue.add(queue.poll());
		}


	}

}
