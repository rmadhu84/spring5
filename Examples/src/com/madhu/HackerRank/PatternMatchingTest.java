/**
 * 
 */
package com.madhu.HackerRank;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * @author ramachandranm1
 *
 */
public class PatternMatchingTest {

	@Test
	public void fooTest() {
		Pattern pattern = Pattern.compile("foo");
		Matcher matcher = pattern.matcher("foo");
	    assertTrue(matcher.find());
	}
	
	@Test
	public void foofooTest() {
		Pattern pattern = Pattern.compile("foo");
		Matcher matcher = pattern.matcher("foofoo");
		int matches = 0;
	    while(matcher.find()) {
	    	matches++;
	    }
	    assertEquals(matches, 2);
	}
	
	@Test
	public void givenTextMetaDotTest1() {
		int matches = runTest("foo", ".");
		assertTrue(matches > 0);
	}

	@Test
	public void givenTextMetaDotTest2() {
		int matches = runTest("foofoo", "foo.");
		assertEquals(matches, 1);
	}
	
	@Test
	public void givenTextMetaDotTest3() {
		int matches = runTest("foofoo", "foo");
		assertEquals(matches, 2);
	}
	
	
	@Test
	public void OrClassTest1() {
		int matches = runTest("abc","[abc]");
		assertEquals(matches, 3);
	}
	
	@Test
	public void OrClassTest2() {
		int matches = runTest("cat bat rat hat tat tit","[abcrht]at");
		assertEquals(matches, 5);
	}
	
	
	@Test
	public void NorClassTest1() {
		int matches = runTest("de","[^abc]");
		assertTrue(matches > 0);
	}
	
	@Test
	public void rangeClassTest1() {
		int matches = runTest("A quick fox Jumped over the Lazy Brown Dog","[A-Z]");
		assertTrue(matches > 0);
	}

	@Test
	public void rangeClassTest2() {
		int matches = runTest("A quick fox Jumped over the Lazy Brown Dog","[a-z]");
		assertTrue(matches > 0);
	}
	
	@Test
	public void rangeClassTest3() {
		int matches = runTest("1 quick fox Jumped over 2 Lazy Brown Dogs","[0-9]");
		assertEquals(matches, 2);
	}
	
	@Test
	public void rangeClassTest4() {
		int matches = runTest("1 quick fox Jumped over 2 Lazy Brown Dogs","[A-Za-z0-9]");
		assertTrue(matches > 0);
	}
	
	@Test
	public void rangeClassTest5() {
		int matches = runTest("01 Uppercase alphabets 34 overall","[0-9][0-9]");
		assertTrue(matches > 0);
	}
	
	@Test
	public void unionClassTest() {
		int matches = runTest("123789", "[123[789]]");
		assertEquals(matches, 6);
	}
	
	public int runTest(String text, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		int matches = 0;
		StringBuilder strBuild = new StringBuilder();
	    while(matcher.find()) {
	    	if(strBuild == null)
	    		strBuild.append(matcher.group());
	    	else { 
	    		strBuild.append(" ");
	    		strBuild.append(matcher.group());
	    	}
	    	
	    	matches++;
	    }
	    System.out.println(String.format("Text = %s; regex = %s; matches = %d; match = %s", text, regex, matches, strBuild.toString()));
	    return matches;
	}

}
