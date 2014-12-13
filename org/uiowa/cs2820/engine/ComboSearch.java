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
	
	public ListIterator<String> orSearch(Set<String> s1, Set<String> s2){
				
		// make copy of s1
		Set<String> union = new HashSet<String>(s1);
		
		// find union
		union.addAll(s2);
		
		String[] result = null;
		
		// convert back into string array
		result = union.toArray(new String[union.size()]);
		// convert to ListIterator<String> to return
		ListIterator<String> resultIterator = new ListIterator<String>(result);
		return resultIterator;
		
	}
	
	public ListIterator<String> andSearch(Set<String> s1, Set<String> s2){
				
		// make copy of s1
		Set<String> intersection = new HashSet<String>(s1);
		
		// find intersection
		intersection.retainAll(s2);
		
		String[] result = null;
		
		// convert back into string array
		result = intersection.toArray(new String[intersection.size()]);
		// convert to ListIterator<String> to return
		ListIterator<String> resultIterator = new ListIterator<String>(result);
		return resultIterator;

	}
	
	/*
	 *  perform both searches, s1, s2
	 *  call appropriate combining method: orSearch or andSearch
	 */
	@Override
	public ListIterator<String> doSearch() throws NullPointerException{
		ListIterator<String> resultIterator = null;
		
		// declare string arrays ids1, ids2
		String[] ids1 = null;
		String[] ids2 = null;
		String[] result = null;
		
		// perform searches	
		ids1 = this.obj1.doSearch().toStringArray();
		ids2 = this.obj2.doSearch().toStringArray();
		
		// declare Hashsets to find union or intersection
		Set<String> set1 = new HashSet<String>(Arrays.asList(ids1));
		Set<String> set2 = new HashSet<String>(Arrays.asList(ids2));
		
		// find out what kind of search it is: orSearch or andSearch
		if ( this.s.equals("or")) {
			resultIterator = this.orSearch(set1, set2);
		}
		else if ( this.s.equals("and")) {
			resultIterator = this.andSearch(set1, set2);
		}
		// invalid search
		else {
			System.out.println("Specify 'and' or 'or' search");
		}
		return resultIterator;
	}
		
	
	public String toString() {
		return "ComboSearch: (" + obj1.toString() + ")" + " " + s + " " + "(" + obj2.toString() + ")";
	}
	
}
