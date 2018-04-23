package dataStructures;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E>, Cloneable {
	// Returns an iterable collection of the Positions representing p's children. 
	public Iterable<Position<E>> children(Position<E> p) {
		List<Position<E>> snapshot = new ArrayList<>(2); // max capacity of 2
		if (left(p) != null)
			snapshot.add(0, left(p));
		if (right(p) != null)
			snapshot.add(1, right(p));
		return snapshot;
	}
	// Returns the Position of p's sibling (or null if no sibling exists). 
	public Position<E> sibling(Position<E> p) {
		Position<E> parent = parent(p);
		if (parent == null) return null; // p must be the root
		if (p == left(parent)) // p is a left child
			return right(parent); // (right child might be null)
		else // p is a right child
			return left(parent); // (left child might be null)
	}
	// Returns the number of children of Position p. 
	public int numChildren(Position<E> p) {
		int count=0;
		if (left(p) != null)
			count++;
		if (right(p) != null)
			count++;
		return count;
	}
	public Iterable<Position<E>> positions() { return inorder();}
	
	private void inorderSubtree(Position<E> p, List<Position<E>> snapshot) {
		if(left(p) != null) 
			inorderSubtree(left(p), snapshot);
		snapshot.add(p);
		if(right(p) != null)
			inorderSubtree(right(p), snapshot);
	}
	
	public Iterable<Position<E>> inorder() {
		List<Position<E>> snapshot = new ArrayList<>( );
		if(!isEmpty())
			inorderSubtree(root(), snapshot);
		return snapshot;
	}

}