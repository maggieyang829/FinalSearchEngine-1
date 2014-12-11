package org.uiowa.cs2820.engine;
import java.util.*;

@SuppressWarnings("hiding")
public class ListIterator<String> implements Iterator<String>{
	Iterator<String> I;
	
	public ListIterator(String[] s) {
		/*I first converted s to an ArrayList but it didn't support remove()
		  so I convert s to a Linkedlist instead*/
		LinkedList<String> L = new LinkedList<String>(Arrays.asList(s));
		I = L.iterator();
	}
	
	@Override
	public String next() {
		return I.next();
	}
	
	@Override
	public boolean hasNext() {
		return I.hasNext();
	}
	
	@Override
	public void remove() {
		I.remove();
		
	}
	
	public int length() {
		int count = 0;
		while(I.hasNext()) {
			count += 1;
		}
		return count;
	}
	
	@SuppressWarnings("unchecked")
	public String[] toStringArray() {
		java.lang.String[] S = new java.lang.String[((CharSequence) I).length()];
		for(int i=0; i < S.length; i++) {
			S[i] = (java.lang.String) I.next();
		}
		return (String[]) S;
	}
}