package com.madhu.practice.Arrays;

import java.util.Arrays;

import org.apache.commons.lang3.time.StopWatch;

import com.madhu.practice.Arrays.Utils.Utility;

public class SortingAlgorithmsTest {

	static Utility util = new Utility();
	static StopWatch watch = new StopWatch();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = { 20, 35, -15, 7, 55, -22 };
		bubbleSort(a);
		insertionSort(a);

	}

	private static void insertionSort(int[] a) {
		int[] b = Arrays.copyOf(a, a.length);
		util.printArray("Unsorted Array", b);

		
		watch.start();

		int lastIndex = b.length-1;
		for (int lastSortedIndex = 1; lastSortedIndex <= lastIndex; lastSortedIndex++) {
			int newElement = b[lastSortedIndex];
			int i;
			for (i = lastSortedIndex; i > 0 && b[i - 1] > newElement; i--) {
				b[i] = b[i - 1];
			}
			b[i] = newElement;
		}
		watch.stop();
		System.out.println("Time taken to Insertion sort : " + watch.getNanoTime());
		watch.reset();
		util.printArray("Insertion sorted array", b);

	}

	public static void bubbleSort(int[] a) {
		int[] b = Arrays.copyOf(a, a.length);
		util.printArray("UnSorted Array", b);
		int lastUnsortedIndex = a.length - 1;
		
		watch.start();
		for (; lastUnsortedIndex >= 0; lastUnsortedIndex--) {
			for (int i = 0; i < lastUnsortedIndex; i++) {
				if (b[i] > b[i + 1]) {
					swap(b, i, i + 1);
				}
			}
		}
		watch.stop();
		System.out.println("Time taken to Bubble sort : " + watch.getNanoTime());
		watch.reset();
		util.printArray("Bubble Sorted Array", b);
	}

	public static int[] swap(int[] a, int i, int j) {
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
		return a;
	}
}
