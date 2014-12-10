package org.uiowa.cs2820.engine;

import java.util.ArrayList;

public class SuffixSearch {

	ArrayList<Node> fieldList;
	Field target;
	Database D;
	
	public SuffixSearch(Field F) {
		D = new LinearDiskDatabase();
		target = F;
	}

	public String[] doSearch() {
		SearchSuffix P = new SearchSuffix(target);
		String[] Result = D.fetch(P);
		if ( Result == null) return new String[0];
		return Result;
	}
	
}
