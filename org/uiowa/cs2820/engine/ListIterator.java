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
		while(hasNext()) {
			count += 1;
		}
		return count;
	}
	
	@SuppressWarnings("unchecked")
	public String[] toStringArray() {
		String[] S = (String[]) new java.lang.String[length()];
		for(int i=0; i < length(); i++) {
			S[i] = next();
		}
		return S;
	}
}