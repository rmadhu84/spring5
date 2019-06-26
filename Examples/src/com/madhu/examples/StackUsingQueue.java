/**
 * 
 */
package com.madhu.examples;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ramachandranm1
 *
 */
public class StackUsingQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());

	}
	
	static class Stack{
		
		static int curr_size;
		static Queue<Integer> q1 = new LinkedList<Integer>();
		static Queue<Integer> q2 = new LinkedList<Integer>();
		
		
		static int pop() {
			curr_size--;
			return q1.poll();
		}
		
		static void push(int a) {
			System.out.println("(1) size of Q2 = " + q2.size());
			q2.add(a);
			while(!q1.isEmpty()) {
				q2.add(q1.poll());
			}
			Queue<Integer> q = q1;
			q1 = q2;
			q2 = q;
			curr_size++;
			System.out.println("(2)size of Q2 = " + q2.size());
		}
		
		Stack(){
			curr_size = 0;
		}
		
		static int size() {
			return curr_size;
		}
	}

}
