package org.uiowa.cs2820.engine;
import java.util.*;

@SuppressWarnings("hiding")
public class StringIterator<String> implements Iterator<String>{
	Iterator<String> I;
	
	public StringIterator(String[] s) {
		I = Arrays.asList(s).iterator();
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
}