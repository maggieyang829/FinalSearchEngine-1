package org.uiowa.cs2820.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LinearDiskDatabase implements Database {

	  public void store(Field f, String id) {
	    Storage.add(f,id);
	    }

	  public void remove(String id) {
	    Node.remove(id);
	    }
	  
	  public String[] fetch(Traverser f) {

	    ArrayList<Node> n = Node.findNodeLst(f);
	    
	  //  System.out.println("arraylist length: "+n.size());
	  //  System.out.println("They are: "+ n.get(0).Key.getFieldName());
	    if (n == null) return new String[0];
	    String[] first = Identifier.getAllIds((n.get(0)).identlist);
	    if(n.size() == 1) return first;

	    Set<String> idSet = new HashSet<String>(Arrays.asList(first));	    
	    for(int i=1; i<n.size();i++){
	    	String[] arr = Identifier.getAllIds((n.get(i)).identlist);
	    	Set<String> moreSet = new HashSet<String>(Arrays.asList(arr));
	    	idSet.addAll(moreSet);
	    }
	     
	    return idSet.toArray(new String[idSet.size()]);
	    }


	  }
		  
