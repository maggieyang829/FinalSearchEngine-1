package org.uiowa.cs2820.engine;
import java.util.ArrayList;

import org.uiowa.cs2820.engine.ArrayListIterator;

public class FieldSearch extends Traverser {
  Field target = null;
  Node h;
  //ArrayList<Node> hlst = new ArrayList<Node>();
  Database D;
  public FieldSearch(Field f) { 
	D = new LinearDiskDatabase();
	target = f; 
	}
  
@SuppressWarnings("rawtypes")
public ArrayListIterator<ArrayList> doSearch() {
	String [] R = D.fetch(this);
	if (R == null) R = new String[0];
	ArrayListIterator<ArrayList> A = new ArrayListIterator<ArrayList>();
	return A.iterator(R);
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