package dataStructures;

import java.util.Comparator;

// An implementation of a sorted map using a binary search tree. 
public class TreeMap<K,V> extends AbstractSortedMap<K,V> {
	
	protected BalanceableBinaryTree<K,V> tree = new BalanceableBinaryTree<>();
	
	// Constructs an empty map using the natural ordering of keys. 
	public TreeMap() {
		super(); // the AbstractSortedMap constructor
		tree.addRoot(null); // create a sentinel leaf as root
	}
	
	// Constructs an empty map using the given comparator to order keys. 
	public TreeMap(Comparator<K> comp) {
		super(comp); // the AbstractSortedMap constructor
		tree.addRoot(null); // create a sentinel leaf as root
	}
	
	@Override
	public int size() {
		return (tree.size() - 1) / 2; // only internal nodes have entries
	}
	
	// Determines whether a key is valid. 
	protected boolean checkKey(K key) throws IllegalArgumentException {
		try {
			return (compare.compare(key,key) == 0); // see if key can be compared to itself
		} catch (ClassCastException e) {
			throw new IllegalArgumentException("Incompatible key");
		}
	}
	// Utility used when inserting a new entry at a leaf of the tree.
	private void expandExternal(Position<Entry<K,V>> p, Entry<K,V> entry) {
		tree.set(p, entry); // store new entry at p
		tree.addLeft(p, null); // add new sentinel leaves as children
		tree.addRight(p, null);
	}
	
	protected Position<Entry<K,V>> root() { return tree.root(); }
	
	// Returns the position in p's subtree having given key (or else the terminal leaf).
	private Position<Entry<K,V>> treeSearch(Position<Entry<K,V>> p, K key) {
		if (tree.isExternal(p))
			return p; // key not found; return the final leaf
		int comp = compare(key, (MapEntry<K, V>) p.getElement());
		if (comp == 0)
			return p; // key found; return its position
		else if (comp < 0)
			return treeSearch(tree.left(p), key); // search left subtree
		else
			return treeSearch(tree.right(p), key); // search right subtree
	}
	
	@Override
	public V get(K key) {
		checkKey(key); // may throw IllegalArgumentException
		Position<Entry<K,V>> p = treeSearch(root(), key);
		rebalanceAccess(p); // hook for balanced tree subclasses
		if (tree.isExternal(p)) return null; // unsuccessful search
		return p.getElement().getValue(); // match found
	}

	@Override
	public V put(K key, V value) {
		checkKey(key); // may throw IllegalArgumentException
		Entry<K,V> newEntry = new MapEntry<>(key, value);
		Position<Entry<K,V>> p = treeSearch(root(), key);
		if (tree.isExternal(p)) { // key is new
			expandExternal(p, newEntry);
			rebalanceInsert(p); // hook for balanced tree subclasses
			return null;
		}else {
			V old = p.getElement().getValue();
			tree.set(p, newEntry);
			rebalanceAccess(p); // hook for balanced tree subclasses
			return old;
		}
	}
	
	public void putIfAbsent(K key, V value) {
		checkKey(key);
		Entry<K,V> newEntry = new MapEntry<>(key, value);
		Position<Entry<K,V>> p = treeSearch(root(), key);
		if(tree.isExternal(p)) {
			expandExternal(p, newEntry);
			rebalanceInsert(p);
		}
	}

	@Override
	public V remove(K key) {
		checkKey(key); // may throw IllegalArgumentException
		Position<Entry<K,V>> p = treeSearch(root(), key);
		if (tree.isExternal(p)) { // key not found
			rebalanceAccess(p); // hook for balanced tree subclasses
			return null;
		}else {
			V old = p.getElement().getValue();
			if (tree.isInternal(tree.left(p)) && tree.isInternal(tree.right(p))) { // both children are internal
				Position<Entry<K,V>> replacement = treeMax(tree.left(p));
				tree.set(p, replacement.getElement());
				p = replacement;
			} // now p has at most one child that is an internal node
			Position<Entry<K,V>> leaf = (tree.isExternal(tree.left(p)) ? tree.left(p) : tree.right(p));
			Position<Entry<K,V>> sib = tree.sibling(leaf);
			tree.remove(leaf);
			tree.remove(p);		// sib is promoted in p’s place
			rebalanceDelete(sib); // hook for balanced tree subclasses
			return old;
		}
	}
	// Returns the position with the maximum key in subtree rooted at Position p. 
	protected Position<Entry<K,V>> treeMax(Position<Entry<K,V>> p) {
		Position<Entry<K,V>> walk = p;
		while (tree.isInternal(walk))
			walk = tree.right(walk);
		return tree.parent(walk); // we want the parent of the leaf
	}
	// Returns the entry having the greatest key (or null if map is empty). 
	public Entry<K,V> lastEntry() {
		if (isEmpty()) return null;
		return treeMax(root()).getElement();
	}
	// Returns the entry with greatest key less than or equal to given key (if any). 
	public Entry<K,V> floorEntry(K key) throws IllegalArgumentException {
		checkKey(key); // may throw IllegalArgumentException
		Position<Entry<K,V>> p = treeSearch(root(), key);
		if (tree.isInternal(p)) return p.getElement(); // exact match
		while (!tree.isRoot(p)) {
			if (p == tree.right(tree.parent(p)))
				return tree.parent(p).getElement(); // parent has next lesser key
			else
				p = tree.parent(p);
		}
		return null; // no such floor exists
	}
	// Returns the entry with greatest key strictly less than given key (if any). 
	public Entry<K,V> lowerEntry(K key) throws IllegalArgumentException {
		checkKey(key); // may throw IllegalArgumentException
		Position<Entry<K,V>> p = treeSearch(root(), key);
		if (tree.isInternal(p) && tree.isInternal(tree.left(p)))
			return treeMax(tree.left(p)).getElement(); // this is the predecessor to p
		// otherwise, we had failed search, or match with no left child
		while (!tree.isRoot(p)) {
			if (p == tree.right(tree.parent(p)))
				return tree.parent(p).getElement(); // parent has next lesser key
			else
				p = tree.parent(p);
		}
		return null; // no such lesser key exists
	}
	@Override
	public Iterable<Entry<K, V>> entrySet() {
		ArrayList<Entry<K,V>> buffer = new ArrayList<>(size( ));
		for (Position<Entry<K,V>> p : tree.inorder())
			if (tree.isInternal(p)) buffer.add(p.getElement());
		return buffer;
	}
	
	// Returns an iterable of entries with keys in range [fromKey, toKey). 
	public Iterable<Entry<K,V>> subMap(K fromKey, K toKey) {
		ArrayList<Entry<K,V>> buffer = new ArrayList<>(size());
		if (compare(fromKey, new MapEntry<>(toKey, null)) < 0) // ensure that fromKey < toKey
			subMapRecurse(fromKey, toKey, root(), buffer);
		return buffer;
	}
	private void subMapRecurse(K fromKey, K toKey, Position<Entry<K,V>> p,
		ArrayList<Entry<K,V>> buffer) {
			if (tree.isInternal(p))
				if (compare(p.getElement().getKey(), new MapEntry<>(fromKey, null)) < 0)
				// p's key is less than fromKey, so any relevant entries are to the right
					subMapRecurse(fromKey, toKey, tree.right(p), buffer);
				else {
					subMapRecurse(fromKey, toKey, tree.left(p), buffer); // first consider left subtree
					if (compare(p.getElement().getKey(), new MapEntry<>(toKey, null)) < 0) { // p is within range
						buffer.add(p.getElement()); // so add it to buffer, and consider
						subMapRecurse(fromKey, toKey, tree.right(p), buffer); // right subtree as well
					}
				}
			}
	public int keyInRange(K from, K to) {
		ArrayList<Entry<K,V>> buffer = new ArrayList<>(size());
		if (compare(from, new MapEntry<>(to, null)) < 0) // ensure that fromKey < toKey
			subMapRecurse(from, to, root(), buffer);
		return buffer.size();
	}
	protected void rebalanceInsert(Position<Entry<K,V>> p) { }
	protected void rebalanceDelete(Position<Entry<K,V>> p) { }
	protected void rebalanceAccess(Position<Entry<K,V>> p) { }

}
