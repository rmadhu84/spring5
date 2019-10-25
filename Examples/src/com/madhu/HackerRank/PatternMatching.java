/**
 * 
 */
package com.madhu.HackerRank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.junit.Assert.*;

/**
 * @author ramachandranm1
 *
 */
public class PatternMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern pattern = Pattern.compile("foo");
		Matcher matcher = pattern.matcher("foo");
	    assertTrue(matcher.find());
	    System.out.println(matcher.find());

	}

}
