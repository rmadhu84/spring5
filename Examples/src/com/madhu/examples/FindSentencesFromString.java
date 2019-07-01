/**
 * 
 */
package com.madhu.examples;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Madhu
 *
 */
public class FindSentencesFromString {

	static Set<String> dictionary = new HashSet<String>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String input = "Thisisatest";

		dictionary.add("This");
		dictionary.add("tea");
		dictionary.add("is");
		dictionary.add("hot");
		dictionary.add("a");
		dictionary.add("test");

		HashSet words = wordBreak(input, dictionary);
		printWords(words);
	}

	private static HashSet<String> wordBreak(String input, Set<String> dictionary2) {
		HashSet<String> words = new HashSet<String>();
		//Check for single letter words.
		for(int i=0;i<input.length();i++) {
			String s = String.valueOf(input.charAt(i));
			if(!words.contains(s) && dictionary.contains(s) ) {
				words.add(s);
			}
		}
		
		//Check for string of letters words.
		System.out.println("Length of input: " + input.length());
		for(int i = 0;i < input.length();i++) {
			for(int j = i+1;i < input.length();j++) {
				if(j>input.length())
					break;
				String s = input.substring(i, j);
				if(!words.contains(s) && dictionary.contains(s) ) {
					words.add(s);
				}
			}
		}
		
		return words;
	
	}
	
	static void printWords(HashSet s){
		Iterator<String> it = s.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
