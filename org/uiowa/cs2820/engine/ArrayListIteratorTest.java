package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayListIteratorTest {

	@Test
	public void hasNextTest() {
		String[] S = "abcdefg".split("");
		ArrayListIterator<String> I = new ArrayListIterator<String>(S);
		assertTrue(I.hasNext());
	}
	
	@Test
	public void nextTest() {
		String[] S = "1234567".split("");
		ArrayListIterator<String> I = new ArrayListIterator<String>(S);
		assertEquals(I.next(), "1");
	}
	
}