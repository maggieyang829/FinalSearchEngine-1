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
		int length = toLinkedList().size();
		return length;
	}
	
	public LinkedList<String> toLinkedList() {
		LinkedList<String> L = new LinkedList<String>();
		while(hasNext()) L.add(next());
		I = L.iterator();
		return L;
	}
	
	public ArrayList<String> toArrayList() {
		ArrayList<String> A = new ArrayList<String>();
		while(hasNext()) A.add(next());
		LinkedList<String> L = new LinkedList<String>(A);
		I = L.iterator();
		return A;
	}
}