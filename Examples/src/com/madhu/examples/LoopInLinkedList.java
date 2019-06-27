/**
 * 
 */
package com.madhu.examples;

import java.util.HashSet;

/**
 * @author ramachandranm1
 *
 */
public class LoopInLinkedList {

	static Node head;

	static class Node {

		int data;
		Node next;

		Node(int a) {
			this.data = a;
			this.next = null;
		}
	}

	static void add(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoopInLinkedList llist = new LoopInLinkedList();
		llist.add(1);
		llist.add(2);
		llist.add(3);
		llist.add(4);
		llist.add(5);
		llist.head.next.next.next.next = llist.head.next.next;
		if(!detectLoop(llist.head))
			printlist(llist.head);
		else
			System.out.println("Loop Detected");
	}

	private static Boolean detectLoop(Node head2) {
		// TODO Auto-generated method stub
		HashSet<Node> s = new HashSet<Node>();
		while (head2 != null) {
			if (s.contains(head2))
				return true;
			s.add(head2);
			head2 = head2.next;
		}
		return false;
	}

	private static void printlist(Node node) {
		// TODO Auto-generated method stub
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
	}

}
