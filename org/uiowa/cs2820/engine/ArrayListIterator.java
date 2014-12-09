package org.uiowa.cs2820.engine;
import java.util.*;

@SuppressWarnings("hiding")
public class ArrayListIterator<ArrayList> implements Iterator<String>{

	public Iterator<String> iterator(String[] args) {
		List<String> words = Arrays.asList(args);
		return words.iterator();
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String next() {
		// TODO Auto-generated method stub
		return null;
	}
	
}