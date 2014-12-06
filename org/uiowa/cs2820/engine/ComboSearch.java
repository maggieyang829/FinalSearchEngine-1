package org.uiowa.cs2820.engine;

public class ComboSearch implements Search {
	Search obj1;
	Search obj2;
	Boolean s;			//true stands for And search, false stands for Or search
	
	public ComboSearch(Search f1, Search f2, Boolean s){
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
	
}
