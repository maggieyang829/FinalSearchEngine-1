package org.uiowa.cs2820.engine;

public class ComboSearch implements Search {
	Search obj1;
	Search obj2;
	String s;			// s = "and" or "or"
	
	public ComboSearch(Search f1, Search f2, String s){
		obj1 = f1;
		obj2 = f2;
		this.s = s;
	}

	/*
	 *  perform both searches, s1, s2
	 *  let ids1 = identifiers returned from s1
	 *  let ids2 = identifiers returned from s2
	 *  for each identifier in ids1, ids2, add to set
	 */
	
	public String[] orSearch(){
		
		return null;
	}
	
	/*
	 *  perform both searches, s1, s2
	 *  let ids1 = identifiers returned from s1
	 *  let ids2 = identifiers returned from s2
	 *  for each identifier in ids1, ids2, add to set
	 */
	public String[] andSearch(){
		
		return null;
	}
	
	/*
	 * perform searches, s1, s2
	 * call appropriate combining method: orSearch or andSearch
	 */
	@Override
	public String[] doSearch() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString() {
		return "ComboSearch: (" + obj1.toString() + ")" + " " + s + " " + "(" + obj2.toString() + ")";
	}
	
}
