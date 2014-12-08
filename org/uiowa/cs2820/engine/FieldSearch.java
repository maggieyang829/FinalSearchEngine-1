package org.uiowa.cs2820.engine;

import java.util.ArrayList;

public class FieldSearch implements Traverser {
  Field target = null;
  Node h = null;
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
  
  public boolean process(Item I) { 
	    Node F = (Node) I;  // we are traversing Nodes 
	    if (F.Key.equals(target)) {
	      h = F; // remember this node
	      return false;  // stop traversing; 
	    }
	    return true;
  }
}