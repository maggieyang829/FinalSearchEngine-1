package org.uiowa.cs2820.engine;

<<<<<<< HEAD
public class ContainsSearch extends Search {
=======
import java.util.ArrayList;
>>>>>>> 481a9252bdb0046f70e39f05b05ee6c7e3773140

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


