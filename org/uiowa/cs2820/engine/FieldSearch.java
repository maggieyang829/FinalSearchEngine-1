package org.uiowa.cs2820.engine;

import org.uiowa.cs2820.engine.ArrayListIterator;

public class FieldSearch extends Search{
  Field target;
  Node h;
  Database D;
  
  public FieldSearch(Field f) { 
	D = new LinearDiskDatabase();
	target = f; 
	}


public String[] doSearch() {
	SearchField S = new SearchField(target);
	String [] R = D.fetch(S);
	if (R == null) R = new String[0];
	//ArrayListIterator<String> A = new ArrayListIterator<String>(R);
	return R;
	}

}