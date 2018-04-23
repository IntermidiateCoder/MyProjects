package dataStructures;

import java.util.Comparator;

// An implementation of a sorted map using an AVL tree. 
public class AVLTreeMap<K,V> extends TreeMap<K,V> {
	// Constructs an empty map using the natural ordering of keys. 
	public AVLTreeMap() { super(); }
	//  Constructs an empty map using the given comparator to order keys. 
	public AVLTreeMap(Comparator<K> comp) { super(comp); }
	// Returns the height of the given tree position. 
	protected int height(Position<Entry<K,V>> p) {
		return tree.getAux(p);
	}
	// Recomputes the height of the given position based on its children's heights. 
	protected void recomputeHeight(Position<Entry<K,V>> p) {
		tree.setAux(p, 1 + Math.max(height(tree.left(p)), height(tree.right(p))));
	}
	// Returns whether a position has balance factor between -1 and 1 inclusive. 
	protected boolean isBalanced(Position<Entry<K,V>> p) {
		return Math.abs(height(tree.left(p)) - height(tree.right(p))) <= 1;
	}
	// Returns a child of p with height no smaller than that of the other child. 
	protected Position<Entry<K,V>> tallerChild(Position<Entry<K,V>> p) {
		if (height(tree.left(p)) > height(tree.right(p))) return tree.left(p); // clear winner
		if (height(tree.left(p)) < height(tree.right(p))) return tree.right(p); // clear winner
		// equal height children; break tie while matching parent's orientation
		if (tree.isRoot(p)) return tree.left(p); // choice is irrelevant
		if (p == tree.left(tree.parent(p))) return tree.left(p); // return aligned child
		else return tree.right(p);
	}
	// Utility used to rebalance after an insert or removal operation. This traverses the
	// path upward from p, performing a trinode restructuring when imbalance is found,
	// continuing until balance is restored.
	protected void rebalance(Position<Entry<K,V>> p) {
		int oldHeight, newHeight;
		do {
			oldHeight = height(p); // not yet recalculated if internal
			if (!isBalanced(p)) { // imbalance detected
				// perform trinode restructuring, setting p to resulting root,
				// and recompute new local heights after the restructuring
				p = tree.restructure(tallerChild(tallerChild(p)));
				recomputeHeight(tree.left(p));
				recomputeHeight(tree.right(p));
			}
			recomputeHeight(p);
			newHeight = height(p);
			p = tree.parent(p);
		} while (oldHeight != newHeight && p != null);
	}
	// Overrides the TreeMap rebalancing hook that is called after an insertion. 
	protected void rebalanceInsert(Position<Entry<K,V>> p) {
		rebalance(p);
	}
	// Overrides the TreeMap rebalancing hook that is called after a deletion. 
	protected void rebalanceDelete(Position<Entry<K,V>> p) {
		if (!tree.isRoot(p))
			rebalance(tree.parent(p));
	}
}