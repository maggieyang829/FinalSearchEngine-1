package org.uiowa.cs2820.engine;

public class PrefixSearch implements Search {

	Field field;
	Database D;
	
	public PrefixSearch(Field F) {
		D = new LinearDiskDatabase();
		field = F;
	}

	@Override
	public String[] doSearch() {
		// TODO Auto-generated method stub
		return null;
	}

}
