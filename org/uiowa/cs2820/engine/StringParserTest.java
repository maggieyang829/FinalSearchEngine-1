package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringParserTest {

	@Test
	public void test() {
		StringParser sp1 = new StringParser("Search (greater (\"Word\",\"pre\")) and (less (\"Temperature\",85))");
		Search s1 = sp1.analyse();
		
		StringParser sp2 = new StringParser("Search (less (\"Word\",\"pre\")");
		Search s2 = sp2.analyse();
		
		assertTrue(s1.toString().equals("ComboSearch: (GreaterThanSearch (Word,pre)) and (LessThanSearch (Temperature,85))"));
		assertTrue(s2.toString().equals("LessThanSearch (Word,pre)"));
	}

}
