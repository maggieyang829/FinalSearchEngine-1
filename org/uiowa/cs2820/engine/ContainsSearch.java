package org.uiowa.cs2820.engine;


import java.util.ArrayList;

public class ContainsSearch extends Search {


	ArrayList<Node> fieldList;
	Field target;
	Database D;
	
	public ContainsSearch(Field F) {
		D = new LinearDiskDatabase();
		target = F;
	}

	public ListIterator<String> doSearch() {
		SearchContains P = new SearchContains(target);
		String[] Result = D.fetch(P);
		if ( Result == null) Result = new String[0];
		ListIterator<String> L = new ListIterator<String>(Result);
		return L;
	}
	
}


