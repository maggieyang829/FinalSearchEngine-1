package org.uiowa.cs2820.engine;

public class ContainsSearch implements Search {

	Field target;
	Database D;
	
	public ContainsSearch(Field f) {
		D = new LinearDiskDatabase();
		target = f;
	}

	@Override
	public String[] doSearch() {
		// TODO Auto-generated method stub
		return null;
	}

}
