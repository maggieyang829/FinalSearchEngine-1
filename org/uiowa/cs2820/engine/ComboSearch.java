package org.uiowa.cs2820.engine;

public class ComboSearch extends Search {
	Search obj1;
	Search obj2;
	String s;			// s = "and" or "or"
	
	public ComboSearch(Search f1, Search f2, String s){
		obj1 = f1;
		obj2 = f2;
		this.s = s;
	}

	public String[] orSearch(){
		
		return null;
	}
	
	public String[] andSearch(){
		
		return null;
	}
	
	@Override
	public String[] doSearch() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString() {
		return "ComboSearch: (" + obj1.toString() + ")" + " " + s + " " + "(" + obj2.toString() + ")";
	}
	
}
