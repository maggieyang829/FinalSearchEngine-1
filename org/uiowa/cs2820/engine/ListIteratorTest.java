package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import java.util.*;

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
	
	//Checks remove method by removing all items except "1" and checking if I.next() = "1"
	@Test
	public void removeTest() {
		String[] S = "000001".split("");
		ListIterator<String> I = new ListIterator<String>(S);
		for(int i=0; i < 5; i++) {
			I.next();
			I.remove();
		}
		assertEquals(I.next(), "1");
	}
	
	//Test for length method
	@Test
	public void lengthTest() {
		String[] S = "123".split("");
		ListIterator<String> I = new ListIterator<String>(S);
		assertEquals(I.length(), 3);
	}
	
	//Test to see if iterator to linked list conversion method works
	@Test
	public void toLinkedListTest() {
		String[] S = "123".split("");
		LinkedList<String> L = new LinkedList<String>(Arrays.asList(S));
		ListIterator<String> I = new ListIterator<String>(S);
		assertEquals(I.toLinkedList(), L);
		
	}
	
	//Test to see if iterator to array list conversion method works
	@Test
	public void toArrayListTest() {
		String[] S = "123".split("");
		ArrayList<String> L = new ArrayList<String>(Arrays.asList(S));
		ListIterator<String> I = new ListIterator<String>(S);
		assertEquals(I.toArrayList(), L);
		
	}
}