package org.uiowa.cs2820.engine;
import java.util.ArrayList;

public abstract class IDTraverser {
	
	ArrayList<Node> fieldLst = new ArrayList<Node>();
	// Traverser method is called on each item 
	// of a linked list, like searching the list
	// or summing items in a list, etc. 
	// 
    // process returns true if the traversal 
	// through the linked list should continue
	// (false means quit the traversal)
	public abstract boolean process(Item I);
	public ArrayList<Node> getLst(){
		return fieldLst;
	}
}