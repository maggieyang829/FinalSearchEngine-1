package org.uiowa.cs2820.engine;

import java.util.Arrays;

public class StringParser {
	
	private String phrase;
	final String delims = "[ ,\"\\(\\)]+"; 
	
	public StringParser(String bigString){
		phrase = bigString;
	}
	
	public Search analyse(){
		//check to see if we are parsing empty string
		if (phrase.isEmpty()) return null;
		
		Search s = null;		
		String[] tokens = phrase.split(delims);
		int arrLen = tokens.length;
		
		//check to see if it's a single or combo search
		if(arrLen == 4) {
			s = packaging(Arrays.copyOfRange(tokens, 1, 4));
		} else if (arrLen == 8) {
			String comboLink = tokens[4];

			Search s1 = packaging(Arrays.copyOfRange(tokens, 1, 4));	//s1 gets the first search 			
			Search s2 = packaging(Arrays.copyOfRange(tokens, 5, 8));	//s2 gets the second search
			
			s = new ComboSearch(s1, s2, comboLink);
			
		} else {
			System.out.println("Please input valid search string");
		}

		return s;
	}
	
	//do a simple packaging from string array to Search object
	private Search packaging(String[] arr) {
		String function = arr[0];
		
		Field f = new Field (arr[1], arr[2]);
		Search s = null;

		if (function.equals("prefix"))        s = new PrefixSearch(f);
		//else if (function.equals("suffix"))   s = new SuffixSearch(f);
		else if (function.equals("contains")) s = new ContainsSearch(f);
		else if (function.equals("equals"))   s = new FieldSearch(f);
		else if (function.equals("greater"))  s = new GreaterThanSearch(f);
		else if (function.equals("less"))	  s = new LessThanSearch(f);
		
		return s;
	}
}
