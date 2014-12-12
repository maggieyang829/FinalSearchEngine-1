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
	//Uses already implemented next method from Iterator
	@Override
	public String next() {
		return I.next();
	}
	//Uses already implemented hasNext method from Iterator
	@Override
	public boolean hasNext() {
		return I.hasNext();
	}
	//Uses already implemented remove method from Iterator
	@Override
	public void remove() {
		I.remove();	
	}
	//Length method using LinkedList conversion
	public int length() {
		int length = toLinkedList().size();
		return length;
	}
	//LinkedList converson
	public LinkedList<String> toLinkedList() {
		LinkedList<String> L = new LinkedList<String>();
		while(hasNext()) L.add(next());
		I = L.iterator(); //re-initialize iterator to reset pointer
		return L;
	}
	//ArrayList conversion
	public ArrayList<String> toArrayList() {
		ArrayList<String> A = new ArrayList<String>();
		while(hasNext()) A.add(next());
		LinkedList<String> L = new LinkedList<String>(A);
		I = L.iterator(); //re-initialize iterator to reset pointer
		return A;
	}
	//String[] conversion
	public java.lang.String[] toStringArray() {
		ArrayList<String> A = toArrayList();
		java.lang.String[] S = new java.lang.String[length()];
		for(int i=0; i < length(); i++) {
			S[i] = (java.lang.String) A.get(i);
		}
		return S;
	}
}