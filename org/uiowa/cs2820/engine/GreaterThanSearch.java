package org.uiowa.cs2820.engine;

import java.util.ArrayList;

public class GreaterThanSearch extends Search{
	Field target;
	Database D;
	
	public GreaterThanSearch(Field f){
		D = new LinearDiskDatabase();
		target = f;
	}

	public String[] doSearch() {
		SearchGreater S = new SearchGreater(target);
		String [] R = D.fetch(S);
		if (R == null) R = new String[0];
		return R;
	}	
	
	//this is only for test and debugging
	public String toString() {
		return "GreaterThanSearch (" + target.getFieldName() + "," + target.getFieldValue().toString() + ")";
	}
	

}
