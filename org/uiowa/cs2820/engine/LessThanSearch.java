package org.uiowa.cs2820.engine;

public class LessThanSearch extends Search{

	Field target;
	Database D;
	
	public LessThanSearch(Field f){
		D = new LinearDiskDatabase();
		target = f;
	}
	
	@Override
	public String[] doSearch() {
		SearchLess S = new SearchLess(target);
		String [] R = D.fetch(S);
		if (R == null) R = new String[0];
		return R;
	}
	
	//this is only for test and debugging
	public String toString() {
		return "LessThanSearch (" + target.getFieldName() + "," + target.getFieldValue().toString() + ")";
	}

}
