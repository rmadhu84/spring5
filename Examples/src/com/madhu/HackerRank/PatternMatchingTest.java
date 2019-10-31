/**
 * 
 */
package com.madhu.HackerRank;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * @author ramachandranm1
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
		int matches = runTest("01 Uppercase alphabets 34 overall","[A-Z]");
		assertTrue(matches > 0);
	}
	
	@Test
	public void rangeClassTest6() {
		int matches = runTest("01 Numbers 02 overall","[0-9][0-9]");
		assertTrue(matches > 0);
	}
	
	@Test
	public void subtractionClassTest() {
		int matches = runTest("123456789", "[0-9&&[^2468]]");
		assertEquals(matches,5);
	}
	
	@Test
	public void unionClassTest() {
		int matches = runTest("123456789", "[123[789]]");
		assertEquals(matches, 6);
	}
	
	@Test
	public void intersectionClassTest() {
		int matches = runTest("123456789", "[1-6&&[5-9]]");
		assertEquals(matches, 2);
	}
	
	
	/**
	 * \\d - digits
	 * \\D -Non-digits
	 * \\s - white space
	 * \\S - non-white space
	 */
	@Test
	public void preDefinedCharacterClassTest1() {
		int matches = runTest("1234", "\\d");
		assertEquals(matches, 4);
	}
	
	@Test
	public void preDefinedCharacterClassTest2() {
		int matches = runTest("12A34B56C", "\\D");
		assertEquals(matches, 3);
	}
	
	@Test
	public void preDefinedCharacterClassTest3() {
		int matches = runTest("A B C","\\s");
		assertEquals(matches, 2);
	}
	
	@Test
	public void preDefinedCharacterClassTest4() {
		int matches = runTest("A B C", "\\S");
		assertEquals(matches, 3);
	}
	
	@Test
	public void preDefinedCharacterClassTest5() {
		assertTrue(runTest("Hello all!", "\\w")>0);
	}
	
	@Test
	public void preDefinedCharacterClassTest6() {
		int matches = runTest("Hello all!", "\\W");
		assertTrue(matches > 0);
	}
	
	@Test
	public void givenZeroOrOneQuantifier_whenMatches_thenCorrect() {
	    int matches = runTest("aa", "a?+");
	  
	    assertTrue(matches > 0);
	}
	
	@Test
	public void givenZeroOrOneQuantifier_whenMatches_thenCorrect2() {
	    int matches = runTest("aa", "a{0,1}");
	  
	    assertTrue(matches > 0);
	}
	
	@Test
	public void tagcontent() {
		String input = "<html><h1><b>Hello World</b></h1><body>This is the content from html</body></html>";
		String regex = "<(\\w+)>([^<]+)</\\1>";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		while(m.find()) {
			System.out.println(m.group(2));
		}
			
	
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
