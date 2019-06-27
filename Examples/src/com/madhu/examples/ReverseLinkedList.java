/**
 * 
 */
package com.madhu.examples;

import java.security.Principal;
import java.util.LinkedList;

/**
 * @author ramachandranm1
 *
 */
public class ReverseLinkedList {

	static Node head;

	static class Node {
		int data;
		Node next;
		Node(int d) {
			this.data = d;
			this.next = null;
		}
	}

	Node reverse(Node node) {
		Node prev = null;
		Node current = node;
		Node next = null;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}
	
	static void printList(Node node) {
		while(node != null) {
			System.out.print(node.data +"->");
			node = node.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLinkedList list = new ReverseLinkedList();
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(3);
		printList(head);
		head = list.reverse(head);
		System.out.println();
		printList(head);
	}

}
