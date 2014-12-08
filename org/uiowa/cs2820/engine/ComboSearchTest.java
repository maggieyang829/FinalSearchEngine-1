package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComboSearchTest {

	// put in some data
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	// test for orSearch
	@Test
	public void test1() {
		Search f = (Search) new Field("Year","2005");
		Search g = (Search) new Field("Feature", "swipe");
		ComboSearch C = new ComboSearch(f, g, "or");
		String [] S = C.doSearch();
		assertEquals(S.length,3);
		for (String s: S) System.out.println(s);
	    } 
	
	// test for andSearch
	@Test
	public void test2() {
		Search f = (Search) new Field("Year","2005");
		Search g = (Search) new Field("Feature", "swipe");
		ComboSearch C = new ComboSearch(f, g, "and");
		String [] S = C.doSearch();
		assertEquals(S.length,3);
		for (String s: S) System.out.println(s);
	    } 

}
