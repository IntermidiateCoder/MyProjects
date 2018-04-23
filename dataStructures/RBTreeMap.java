package dataStructures;

import java.util.Comparator;

public class RBTreeMap<K,V> extends TreeMap<K,V> {
	// Constructs an empty map using the natural ordering of keys. 
	public RBTreeMap() { super(); }
	// Constructs an empty map using the given comparator to order keys. 
	public RBTreeMap(Comparator<K> comp) { super(comp); }
	// we use the inherited aux field with convention that 0=black and 1=red
	// (note that new leaves will be black by default, as aux=0)
	private boolean isBlack(Position<Entry<K,V>> p) { return tree.getAux(p)==0;}
	private boolean isRed(Position<Entry<K,V>> p) { return tree.getAux(p)==1; }
	private void makeBlack(Position<Entry<K,V>> p) { tree.setAux(p, 0); }
	private void makeRed(Position<Entry<K,V>> p) { tree.setAux(p, 1); }
	private void setColor(Position<Entry<K,V>> p, boolean toRed) {
		tree.setAux(p, toRed ? 1 : 0);
	}
	// Overrides the TreeMap rebalancing hook that is called after an insertion. 
	protected void rebalanceInsert(Position<Entry<K,V>> p) {
		if (!tree.isRoot(p)) {
			makeRed(p); // the new internal node is initially colored red
			resolveRed(p); // but this may cause a double-red problem
		}
	 }
	// Remedies potential double-red violation above red position p. 
	private void resolveRed(Position<Entry<K,V>> p) {
		Position<Entry<K,V>> parent,uncle,middle,grand; // used in case analysis
		parent = tree.parent(p);
		if (isRed(parent)) { // double-red problem exists
			uncle = tree.sibling(parent);
			if (isBlack(uncle)) { // Case 1: misshapen 4-node, The Sibling s of y is Black.
				middle = tree.restructure(p); // do trinode restructuring
				makeBlack(middle);
				makeRed(tree.left(middle));
				makeRed(tree.right(middle));
			} else {	// Case 2: overfull 5-node, The Sibling s of y is Red.
				makeBlack(parent); // perform recoloring
				makeBlack(uncle);
				grand = tree.parent(parent);
				if (!tree.isRoot(grand)) {
					makeRed(grand); // grandparent becomes red
					resolveRed(grand);
				}
			}
		}
	}
	// Overrides the TreeMap rebalancing hook that is called after a deletion. 
	protected void rebalanceDelete(Position<Entry<K,V>> p) {
		if (isRed(p)) // deleted parent was black
			makeBlack(p); // so this restores black depth
		else if (!tree.isRoot(p)) {
			Position<Entry<K,V>> sib = tree.sibling(p);
			if (tree.isInternal(sib) && (isBlack(sib) || tree.isInternal(tree.left(sib))))
				remedyDoubleBlack(p); // sib's subtree has nonzero black height
		}
	}
	// Remedies a presumed double-black violation at the given (nonroot) position. 
	private void remedyDoubleBlack(Position<Entry<K,V>> p) {
		Position<Entry<K,V>> z = tree.parent(p);
		Position<Entry<K,V>> y = tree.sibling(p);
		if (isBlack(y)) {
			// The Sibling y of p is Black and has a Red Child x.
			if (isRed(tree.left(y)) || isRed(tree.right(y))) { // Case 1: trinode restructuring, 
				Position<Entry<K,V>> x = (isRed(tree.left(y)) ? tree.left(y) : tree.right(y));
				Position<Entry<K,V>> middle = tree.restructure(x);
				setColor(middle, isRed(z)); // root of restructured subtree gets z's old color
				makeBlack(tree.left(middle));
				makeBlack(tree.right(middle));
			} else { // Case 2: recoloring, The Sibling y of p is Black and Both Children of y are Black.
				makeRed(y);
				if (isRed(z))
					makeBlack(z); // problem is resolved
				else if (!tree.isRoot(z))
					remedyDoubleBlack(z); // propagate the problem
			}
		} else {	// Case 3: reorient 3-node, Sibling y of p is Red.
			tree.rotate(y);
			makeBlack(y);
			makeRed(z);
			remedyDoubleBlack(p); // restart the process at p
		}
	}
}
