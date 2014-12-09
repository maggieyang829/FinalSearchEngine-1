package org.uiowa.cs2820.engine;
import java.util.*;

@SuppressWarnings("hiding")
public class ArrayListIterator<ArrayList> implements Iterator<String>{

	@SuppressWarnings("unchecked")
	public ArrayListIterator<ArrayList> iterator(String[] args) {
		List<String> words = Arrays.asList(args);
		return (ArrayListIterator<ArrayList>) words.iterator();
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