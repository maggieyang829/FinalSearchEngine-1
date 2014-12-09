package org.uiowa.cs2820.engine;

import java.util.ArrayList;

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
	return R;
	}
  
//  public boolean process(Item I) { 
//	  if(lst == null) lst = new ArrayList<Node>();
//	  Node F = (Node) I;  // we are traversing Nodes 
//	  if (F.Key.equals(target)) {
//		  System.out.println("the same, list len is: "+lst.size());
//	      lst.add(F); // remember this node
//	      System.out.println("it adds "+F.Key.getFieldName());
//	      return false;  // stop traversing; 
//	    }
//	    return true;
//  }

}