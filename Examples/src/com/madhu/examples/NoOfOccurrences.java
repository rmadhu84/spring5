/**
 * 
 */
package com.madhu.examples;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author ramachandranm1
 *
 */
public class NoOfOccurrences {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "geeks for geeks";
		System.out.println(str.toString());
		countOccurrances(str);

	}

	private static void countOccurrances(String str) {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char a = str.charAt(i);
			String s = String.valueOf(a).trim();
			if(s == null || s.length() == 0)
				continue;
			
			if (map.containsKey(a))
				map.put(a, map.get(a) + 1);
			else
				map.put(a, 1);
			
			
		}
		
		for(Entry<Character, Integer> m:map.entrySet()) {
			System.out.println(String.format(m.getKey()+" occurs %d" +" times ",m.getValue()));
		}
		

	}

}
