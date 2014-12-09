package org.uiowa.cs2820.engine;

import java.util.ArrayList;

public class LinearDiskDatabase implements Database {

	  public void store(Field f, String id) {
	    Storage.add(f,id);
	    }

	  public void remove(String id) {
	    Node.remove(id);
	    }
	  
	  public String[] fetch(Traverser f) {
		  ArrayList<String> lst = null;
	    ArrayList<Node> n = Node.findNodeLst(f);
	    if (n == null) return new String[0];
	    if(n.size() == 1) return Identifier.getAllIds((n.get(0)).identlist);
	    
	    for(int i=0; i<n.size();i++){
	    	
	    }
	    return lst.toArray(new String[lst.size()]);
	    }


	  }
		  
