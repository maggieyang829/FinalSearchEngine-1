package org.uiowa.cs2820.engine;
import java.util.*;

@SuppressWarnings("hiding")
public class ArrayListIterator<String> implements Iterator<String>{
	Iterator<String> I;
	int current;
	int next;
	int size;
	public ArrayListIterator(String[] S) {
		List<String> words = Arrays.asList(S);
		this.size = words.size();
		this.I = (ArrayListIterator<String>) words.iterator();
	}
	
	@Override
	public boolean hasNext() {
		for(int i = current+1; i < size; i++) {
			// TODO
		}
		return false;
	}

	@Override
	public String next() {
		// TODO Auto-generated method stub
		return null;
	}
	
}