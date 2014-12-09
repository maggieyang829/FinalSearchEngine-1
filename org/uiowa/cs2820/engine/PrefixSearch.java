package org.uiowa.cs2820.engine;

public class PrefixSearch implements Traverser,Search {

	Field field;
	Database D;
	
	public PrefixSearch(Field F) {
		D = new LinearDiskDatabase();
		field = F;
	}

	@Override
	public String[] doSearch() {
		// TODO Auto-generated method stub
		return null;
	}
	/*/
	@Override
	public String[] doSearch() {
		Node n = Node.findNode(field);
		String[] R = Identifier.getAllIds(n.identlist);
		if (R == null) return new String[0];
		return R;
	}
	
	 public static Node findNode(Field f) {
		setup();
		SearchField S = new SearchField(f);  // make custom traverser 
		D.traverse(S);  // go through the linked list
		return S.h;     // either null or the found Node
	}
/*/

	@Override
	public boolean process(Item I) {
		// TODO Auto-generated method stub
		return false;
	}
}
