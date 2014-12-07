package org.uiowa.cs2820.engine;

public class GreaterThanSearch implements Search{
	
	Field target;
	Database D;
	
	public GreaterThanSearch(Field f){
		D = new LinearDiskDatabase();
		target = f;
	}

	@Override
	public String[] doSearch() {
		String [] R = D.fetch(target);
		if (R == null) R = new String[0];
		return R;
	}

}
