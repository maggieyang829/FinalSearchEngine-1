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
		Field f = new Field("Year","2005");
		FieldSearch F = new FieldSearch(f);
		Field g = new Field("Feature", "swipe");
		FieldSearch G = new FieldSearch(g);
		ComboSearch C = new ComboSearch(F, G, "or");
		String [] S = C.doSearch();
		assertEquals(S.length,3);
		for (String s: S) System.out.println(s);
	    } 
	
	// test for andSearch
	@Test
	public void test2() {
		Field f = new Field("Year","2005");
		FieldSearch F = new FieldSearch(f);
		Field g = new Field("Feature", "swipe");
		FieldSearch G = new FieldSearch(g);
		ComboSearch C = new ComboSearch(F, G, "and");
		String [] S = C.doSearch();
		assertEquals(S.length,3);
		for (String s: S) System.out.println(s);
	    } 

}
