package org.uiowa.cs2820.engine;

public class GreaterThanSearch extends Search{
	Field target;
	Database D;
	
	public GreaterThanSearch(Field f){
		D = new LinearDiskDatabase();
		target = f;
	}

	public ListIterator<String> doSearch() {
		SearchGreater S = new SearchGreater(target);
		String [] R = D.fetch(S);
		if (R == null) R = new String[0];
		ListIterator<String> L = new ListIterator<String>(R);
		return L;
	}	
	
	//this is only for test and debugging
	public String toString() {
		return "GreaterThanSearch (" + target.getFieldName() + "," + target.getFieldValue().toString() + ")";
	}
	

}
