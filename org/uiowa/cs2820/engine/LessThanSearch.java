package org.uiowa.cs2820.engine;

public class LessThanSearch implements Search{

	Field target;
	Database D;
	
	public LessThanSearch(Field f){
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
