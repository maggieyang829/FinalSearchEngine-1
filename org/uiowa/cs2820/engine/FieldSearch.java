package org.uiowa.cs2820.engine;

import org.uiowa.cs2820.engine.ListIterator;

public class FieldSearch extends Search{
  Field target;
  Node h;
  Database D;
  
  public FieldSearch(Field f) { 
	D = new LinearDiskDatabase();
	target = f; 
	}


public ListIterator<String> doSearch() {
	SearchField S = new SearchField(target);
	String [] R = D.fetch(S);
	if (R == null) R = new String[0];
	ListIterator<String> L = new ListIterator<String>(R);
	return L;
	}

}