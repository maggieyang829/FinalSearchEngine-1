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
	
	@Test
	public void removeTest() {
		String[] S = "a".split("");
		ArrayListIterator<String> I = new ArrayListIterator<String>(S);
		I.remove();
		String[] S2 = "".split("");
		ArrayListIterator<String> I2 = new ArrayListIterator<String>(S2);
		assertEquals(I, I2);
	}
}