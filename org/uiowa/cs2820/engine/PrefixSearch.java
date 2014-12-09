package org.uiowa.cs2820.engine;

import java.util.ArrayList;

public class PrefixSearch extends Search {

	ArrayList<Node> fieldList;
	Field target;
	Database D;
	
	public PrefixSearch(Field F) {
		D = new LinearDiskDatabase();
		target = F;
	}

	public String[] doSearch() {
		SearchPrefix P = new SearchPrefix(target);
		String[] Result = D.fetch(P);
		if ( Result == null) return new String[0];
		return Result;
	}
	
}
