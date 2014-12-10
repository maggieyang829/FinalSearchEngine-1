package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;
import org.junit.Test;

public class StringIteratorTest {

	@Test
	public void hasNextTest() {
		String[] S = "abcdefg".split("");
		StringIterator<String> I = new StringIterator<String>(S);
		assertEquals(I.hasNext(), true);
	}
	
	@Test
	public void nextTest() {
		String[] S = "1234567".split("");
		StringIterator<String> I = new StringIterator<String>(S);
		assertEquals(I.next(), "2");
	}
	
	@Test
	public void removeTest() {
		String[] S = "abc".split("");
		StringIterator<String> I = new StringIterator<String>(S);
		I.remove();
		assertEquals(I.toString(), S.toString());
	}
}
