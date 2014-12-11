package org.uiowa.cs2820.engine;
import java.util.*;

@SuppressWarnings("hiding")
public class ListIterator<String> implements Iterator<String>{
	Iterator<String> I;
	String[] S;
	
	public ListIterator(String[] s) {
		/*I first converted s to an ArrayList but it didn't support remove()
		  so I convert s to a Linkedlist instead*/
		S = s;
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
	
	public ArrayList<String> toArrayList() {
		ArrayList<String> L = new ArrayList<String>();
		while(hasNext()) L.add(next());
		return L;
	}
	
	public String[] toStringArray() {
		return S;
	}
}