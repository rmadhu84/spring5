/**
 * 
 */
package com.madhu.examples;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ramachandranm1
 *
 */
public class ArrayFindNonRepeatingElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1,2,2,3,3,4};
		printNonRepeatingElements(arr);

	}

	private static void printNonRepeatingElements(int[] arr) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> map = new HashMap<>();
		for(int a : arr) {
			if(map.containsKey(a))
			{
				map.put(a, map.get(a)+1);
			}
			else
				map.put(a, 1);
		}
		for(Map.Entry<Integer, Integer> entry:map.entrySet())
			if(entry.getValue()==1)
				System.out.println(entry.getKey());
		
	}

}
