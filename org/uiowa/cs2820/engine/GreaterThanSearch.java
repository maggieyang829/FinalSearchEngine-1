package org.uiowa.cs2820.engine;

import java.util.ArrayList;

public class GreaterThanSearch implements Traverser{
	
	Field target;
	//Node h;
	ArrayList<Field> fieldLst;
	Database D;
	
	public GreaterThanSearch(Field f){
		D = new LinearDiskDatabase();
		target = f;
		fieldLst = null;
	}


	public String[] doSearch() {
		String [] R = D.fetch(target);
		if (R == null) R = new String[0];
		return R;
	}
	
	public boolean process(Item I) {
		Node F = (Node) I; 
		String itemValue = (String) F.Key.getFieldValue();
		String fieldValue = (String) target.getFieldValue();
	    if (F.Key.getFieldName().equals(target.getFieldName())
	    		&& itemValue.compareTo(fieldValue)>0) {
	    	fieldLst.add(F.Key);
	    }
		return true;
	}
	
	//this is only for test and debugging
	public String toString() {
		return "GreaterThanSearch (" + target.getFieldName() + "," + target.getFieldValue().toString() + ")";
	}
	

}
