package org.uiowa.cs2820.engine;

import java.util.ArrayList;

<<<<<<< Updated upstream
public class SuffixSearch extends Search {
=======
public class SuffixSearch extends Search{
>>>>>>> Stashed changes

	ArrayList<Node> fieldList;
	Field target;
	Database D;
	
	public SuffixSearch(Field F) {
		D = new LinearDiskDatabase();
		target = F;
	}

	public ListIterator<String> doSearch() {
		SearchSuffix P = new SearchSuffix(target);
		String[] Result = D.fetch(P);
		if ( Result == null) Result = new String[0];
		ListIterator<String> L = new ListIterator<String>(Result);
		return L;
	}
	
}
