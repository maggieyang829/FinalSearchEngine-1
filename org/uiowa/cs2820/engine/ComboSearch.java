package org.uiowa.cs2820.engine;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ComboSearch extends Search {
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
		
		// declare string arrays ids1, ids2
		String[] ids1 = null;
		String[] ids2 = null;
		String[] result = null;
		
		// perform searches
		ids1 = this.obj1.doSearch();
		ids2 = this.obj2.doSearch();
		
		// declare Hashsets to find union
		Set<String> set1 = new HashSet<String>(Arrays.asList(ids1));
		Set<String> set2 = new HashSet<String>(Arrays.asList(ids2));
		Set<String> union = new HashSet<String>(set1);
		
		// find union
		union.addAll(set2);
		
		// convert back into string array to return
		result = union.toArray(new String[union.size()]);
		
		return result;
		
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
		String[] result = null;
		// check if orSearch or andSearch
		if ( this.s == "or" ) {
			result = this.orSearch();
		}
		else if ( this.s == "and" ) {
			result = this.andSearch();
		}
		else {
			System.out.println("Specify 'and' or 'or' search");
		}
		return result;
	}
	
	public String toString() {
		return "ComboSearch: (" + obj1.toString() + ")" + " " + s + " " + "(" + obj2.toString() + ")";
	}
	
}
