package org.uiowa.cs2820.engine;

public class FieldSearch implements Search {
  Field target;
  Database D;
  public FieldSearch(Field f) { 
	D = new LinearDiskDatabase();
	target = f; 
	}
  
  public String[] doSearch() {
	String [] R = D.fetch(target);
	if (R == null) R = new String[0];
	return R;
	}
  
}