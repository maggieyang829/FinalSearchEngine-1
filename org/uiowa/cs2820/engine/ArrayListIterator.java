package org.uiowa.cs2820.engine;
import java.util.*;

@SuppressWarnings("hiding")
public class ArrayListIterator<String> implements Iterator<String>{
	Iterator<String> I;
	String[] S;
	int current;
	int next;
	int size;
	public ArrayListIterator(String[] s) {
		this.S = s;
		List<String> words = Arrays.asList(S);
		this.size = words.size();
		this.I = (ArrayListIterator<String>) words.iterator();
	}
	
	@Override
	public boolean hasNext() {
		return next() != null;
	}

	@Override
	public String next() {
		if(!hasNext()){throw new NoSuchElementException();}
		// TODO
		return null;
	}
	
}