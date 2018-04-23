package dataStructures;

import java.util.Comparator;

// An implementation of a sorted map using a splay tree. 
public class SplayTreeMap<K,V> extends TreeMap<K,V> {
	// Constructs an empty map using the natural ordering of keys. 
	public SplayTreeMap() { super(); }
	// Constructs an empty map using the given comparator to order keys. 
	public SplayTreeMap(Comparator<K> comp) { super(comp); }
	// Utility used to rebalance after a map operation. 
	private void splay(Position<Entry<K,V>> p) {
		while (!tree.isRoot(p)) {
			Position<Entry<K,V>> parent = tree.parent(p);
			Position<Entry<K,V>> grand = tree.parent(parent);
			if (grand == null) // zig case
				tree.rotate(p);
			else if ((parent == tree.left(grand)) == (p == tree.left(parent))) { // zig-zig case
				tree.rotate(parent); // move PARENT upward
				tree.rotate(p); // then move p upward
			} else { // zig-zag case
				tree.rotate(p); // move p upward
				tree.rotate(p); // move p upward again
			}
		}
	}
	// override the various TreeMap rebalancing hooks to perform the appropriate splay
	protected void rebalanceAccess(Position<Entry<K,V>> p) {
		if (tree.isExternal(p)) p = tree.parent(p);
		if (p != null) splay(p);
	}
	protected void rebalanceInsert(Position<Entry<K,V>> p) {
		splay(p);
	}
	protected void rebalanceDelete(Position<Entry<K,V>> p) {
		if (!tree.isRoot(p)) splay(tree.parent(p));
	}
}
