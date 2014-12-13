package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FinalIntegrationTest {

	@Test
	public void setup() {	
		CheckPoint.reset();
		DiskSpace.reset();
		// sample data from file
		HashMap<String,ArrayList<Field>> H = new HashMap<String,ArrayList<Field>>();
		String CurrentIndex = null;
		ArrayList<Field> CurrentFields = null;
	 	try {
		  BufferedReader B = new BufferedReader(new FileReader("Resources/PrefixSuffixContains.txt"));
		  String line;
		  String[] tokens;
		  // NOTE: has a bug (EOF not handled well); use extra fake input line at end
		  while ((line = B.readLine()) != null) {
			tokens = line.split("\\s+");
			if (CurrentIndex == null || !CurrentIndex.equals(tokens[0])) {
			  if (CurrentIndex != null) H.put(CurrentIndex,CurrentFields);
			  CurrentIndex = tokens[0];
			  CurrentFields = new ArrayList<Field>();
			  }
			CurrentFields.add(new Field(tokens[1],tokens[2]));
			}
		  B.close();
		  }
		catch (Exception e) { }
		// put dummy data into the database
		Iterator I = H.entrySet().iterator();
		while (I.hasNext()) {
		  Map.Entry pairs = (Map.Entry)I.next();
		  Indexer N = new Indexer((String)pairs.getKey());
		  CurrentFields = (ArrayList<Field>)pairs.getValue();
		  for (Field f: CurrentFields) {
		    N.addField(f);
		    //System.out.println("Added "+N+' '+f);
		    }
		  }
	}
	

	@Test
	public void StringParserToComboAnd() {
		String query = "Search (less (\"Noun\",\"Plant\")) and (equals (\"Noun\",\"Danish\"))";
		StringParser sp = new StringParser(query);
		ComboSearch s = (ComboSearch)sp.analyse();
		ListIterator<String> li = s.doSearch();
		
		ArrayList<String> compare = new ArrayList<String>();
		compare.add("3.txt");
		assertEquals(li.length(),1);
		assert(li.toArrayList().contains(compare));
	 } 
	
	@Test
	public void StringParserToComboOr() {
		String query = "Search (prefix (\"Noun\",\"Dan\")) and (contains (\"Noun\",\"i\"))";
		StringParser sp = new StringParser(query);
		ComboSearch s = (ComboSearch)sp.analyse();
		ListIterator<String> li = s.doSearch();
		
		ArrayList<String> compare = new ArrayList<String>();
		compare.add("3.txt");
		compare.add("5.txt");

		assertEquals(li.length(),2);
		assert(li.toArrayList().contains(compare));
	 }
	
	@Test
	public void StringParseToComboReturnNull() {
		String query = "Search (prefix (\"Noun\",\"null\")) or (contains (\"Noun\",\"null\"))";
		StringParser sp = new StringParser(query);
		ComboSearch s = (ComboSearch)sp.analyse();
		ListIterator<String> li = s.doSearch();

		ArrayList<String> compare = new ArrayList<String>();
		assertEquals(li.toArrayList(),compare);
	}
}



