package dataStructures;

import java.util.Iterator;

public abstract class AbstractTree<E> implements Tree<E> {
	//---------------- nested ElementIterator class ----------------
	// This class adapts the iteration produced by positions() to return elements. 
		private class ElementIterator implements Iterator<E> {
			Iterator<Position<E>> posIterator = positions().iterator();
			public boolean hasNext() { return posIterator.hasNext(); }
			public E next() { return posIterator.next().getElement(); } // return element!
			public void remove() { posIterator.remove(); }
		}
		
	//Adds positions of the subtree rooted at Position p to the given snapshot. 
	private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
		snapshot.add(p); // for preorder, we add position p before exploring subtrees
		for (Position<E> c : children(p))
			preorderSubtree(c, snapshot);
	}
	
	public Iterable<Position<E>> preorder() {
		List<Position<E>> snapshot = new ArrayList<>();
		if(!isEmpty())
			preorderSubtree(root(), snapshot);
		return snapshot;
	}
	
	private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
		for(Position<E> c : children(p)) 
			postorderSubtree(c, snapshot);
		snapshot.add(p);
	}
	
	public Iterable<Position<E>> postorder() {
		List<Position<E>> snapshot = new ArrayList<>();
		if(!isEmpty())
			postorderSubtree(root(), snapshot);
		return snapshot;
	}
	
	public Iterable<Position<E>> breadthfirst() {
		List<Position<E>> snapshot = new ArrayList<>();
		if(!isEmpty()) {
			Queue<Position<E>> fringe = new LinkedQueue<>();
			fringe.enqueue(root());
			while(!fringe.isEmpty()) {
				Position<E> p = fringe.dequeue();
				snapshot.add(p);
			for(Position<E> c : children(p))
				fringe.enqueue(c);
			}
		}
		return snapshot;
	}
	
	@Override
	public Iterator<E> iterator() { return new ElementIterator();}

	@Override
	public Iterable<Position<E>> positions() { return preorder();}
	
	public boolean isInternal(Position<E> p) { return numChildren(p) > 0; }
	public boolean isExternal(Position<E> p) { return numChildren(p) == 0; }
	public boolean isRoot(Position<E> p) { return p == root(); }
 	public boolean isEmpty() { return size() == 0; }
 	
 	//Returns the number of levels separating Position p from the root. 
 	public int depth(Position<E> p) {
 		if (isRoot(p))
 			return 0;
 		else
 			return 1 + depth(parent(p));
 	}
 	
 	//Returns the height of the subtree rooted at Position p. 
 	public int height(Position<E> p) {
 		int h = 0; // base case if p is external
 		for (Position<E> c : children(p))
 			h = Math.max(h, 1 + height(c));
 		return h;
 	}
 	
 	//Prints parenthesized representation of subtree of T rooted at p. 
 	public static <E> void parenthesize(Tree<E> T, Position<E> p) {
 		System.out.print(p.getElement( ));
 		if (T.isInternal(p)) {
 			boolean firstTime = true;
 			for (Position<E> c : T.children(p)) {
 				System.out.print( (firstTime ? " (" : ", ") ); // determine proper punctuation
 				firstTime = false; // any future passes will get comma
 				parenthesize(T, c); // recur on child
 			}
 			System.out.print(")");
 		}
 	}
 	
 	public static <E> boolean isIsomorphic(Tree<E> t1, Tree<E> t2, Position<E> p1, Position<E> p2) {
 		if(t1.isEmpty() && t2.isEmpty()) return true;
 		if(t1.size() == 1 && t2.size() == 1) return true;
 		Iterator<Position<E>> positr1 = t1.positions().iterator();
 		Iterator<Position<E>> positr2 = t2.positions().iterator();
 		while(positr1.hasNext() && positr2.hasNext()) {
 			return isIsomorphic(t1, t2, positr1.next(), positr2.next());
 		}
 		return false;
 	}
 	
 	public Position<E> lowestCommonAncestor(Position<E> p, Position<E> q){
 		Position<E> parentp = parent(p); 
 		Position<E> parentq = parent(q); 
 		while(!parentp.equals(parentq)) {
 			parentp = parent(parentp);
 			parentq = parent(parentq);
 		}
 		return parentp;
 	}
 	
}