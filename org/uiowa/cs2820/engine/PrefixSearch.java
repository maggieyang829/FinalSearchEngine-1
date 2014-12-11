package org.uiowa.cs2820.engine;

public class PrefixSearch extends Search {

	Field target;
	Database D;
	
	public PrefixSearch(Field F) {
		D = new LinearDiskDatabase();
		target = F;
	}


	public String[] doSearch() {
		SearchPrefix S = new SearchPrefix(target);
		String [] R = D.fetch(S);
		if (R == null) R = new String[0];
		//ArrayListIterator<String> A = new ArrayListIterator<String>(R);
		return R;
	}
}
