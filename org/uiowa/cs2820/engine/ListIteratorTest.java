package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ListIteratorTest {

	//This tests the hasNext method
	@Test
	public void hasNextTest() {
		String[] S = "abcdefg".split("");
		ListIterator<String> I = new ListIterator<String>(S);
		assertTrue(I.hasNext());
	}
	
	//This tests the next method, the first call should be the first item
	@Test
	public void nextTest() {
		String[] S = "1234567".split("");
		ListIterator<String> I = new ListIterator<String>(S);
		assertEquals(I.next(), "1");
	}
	
	/*This tests to see if iterator is working by comparing the last index of 
	 the created array list to the last element in S and if the iterator I is at 
	 the end of the list */
	@Test
	public void indexTest() {
		String[] S = "01234567".split("");
		ListIterator<String> I = new ListIterator<String>(S);
		ArrayList<String> L = new ArrayList<String>();
		for(int i=0; i < S.length; i++) {
			L.add(I.next());
		}
		assertEquals(L.get(7), "7");
		assertFalse(I.hasNext());
	}
	
	//This checks the remove method by removing all items and checking hasNext
	@Test
	public void removeTest() {
		String[] S = "000000".split("");
		ListIterator<String> I = new ListIterator<String>(S);
		while(I.hasNext()) {
			String s = I.next();
			if(s.equals("0")) {
				I.remove();
			}
		}
		assertFalse(I.hasNext());
	}
}