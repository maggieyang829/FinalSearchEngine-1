package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

public class ComboSearchTest {

	
	// put in some data
	@Test
	public void setup() {	
		CheckPoint.reset();
		DiskSpace.reset();
		// sample data from file
		HashMap<String,ArrayList<Field>> H = new HashMap<String,ArrayList<Field>>();
		String CurrentIndex = null;
		ArrayList<Field> CurrentFields = null;
	 	try {
		  BufferedReader B = new BufferedReader(new FileReader("Resources/GreaterLessThanTestData.txt"));
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
	
	/*
	 * test to make sure type of ComboSearch is specified:
	 * must be "and" or "or"
	 */
	@Test
	public void testInvalidComboSearch() {
		Field f = new Field("Car", "truck");
		FieldSearch F = new FieldSearch(f);
		Field g = new Field("Part","axle");
		LessThanSearch G = new LessThanSearch(g);
		ComboSearch C = new ComboSearch(F, G, "invalid");
		String [] S = C.doSearch();
		assertNull(S);
	    }  
	
	/*
	 * test for andSearch
	 * disjoint: expect 0 identifiers to be returned
	 * Field < ("Car","truck") and Field > ("Part","gear")
	 */
	@Test
	public void testAndNone() {
		Field f = new Field("Car","truck");
		LessThanSearch F = new LessThanSearch(f);
		Field g = new Field("Part","gear");
		GreaterThanSearch G = new GreaterThanSearch(g);
		ComboSearch C = new ComboSearch(F, G, "and");
		String [] S = C.doSearch();
		assertEquals(S.length,0);
		for (String s: S) System.out.println(s);
	    } 
	
	/*
	 * test for orSearch
	 * returns identifiers that have Field = ("Car", "truck")
	 * or Field < ("Part","axle")
	 */
	@Test
	public void testOr() {
		Field f = new Field("Car", "truck");
		FieldSearch F = new FieldSearch(f);
		Field g = new Field("Part","axle");
		LessThanSearch G = new LessThanSearch(g);
		ComboSearch C = new ComboSearch(F, G, "or");
		String [] S = C.doSearch();
		assertEquals(S.length,5);
		for (String s: S) System.out.println(s);
	    } 
	
	/*
	 * test for andSearch
	 * disjoint: expect 2 identifiers to be returned
	 * 7.txt, 5.txt for box, gear
	 * Field < ("Part","rod") and Field > ("Part","axle")
	 */
	@Test
	public void testAnd() {
		Field f = new Field("Part","rod");
		LessThanSearch F = new LessThanSearch(f);
		Field g = new Field("Part","axle");
		GreaterThanSearch G = new GreaterThanSearch(g);
		ComboSearch C = new ComboSearch(F, G, "and");
		String [] S = C.doSearch();
		assertEquals(S.length,2);
		for (String s: S) System.out.println(s);
	    } 
	    
	 
	    


}
