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

	public String[] doSearch() {
		SearchContains P = new SearchContains(target);
		String[] Result = D.fetch(P);
		if ( Result == null) return new String[0];
		return Result;
	}
	
}


