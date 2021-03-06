package org.uiowa.cs2820.engine;

public class PrefixSearch extends Search {

	Field target;
	Database D;
	
	public PrefixSearch(Field F) {
		D = new LinearDiskDatabase();
		target = F;
	}

	public ListIterator<String> doSearch() {
		SearchPrefix S = new SearchPrefix(target);
		String [] R = D.fetch(S);
		if (R == null) { R = new String[0];}
		ListIterator<String> L = new ListIterator<String>(R);
		return L;
	}
}
