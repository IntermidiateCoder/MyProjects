package dataStructures;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
	protected static class Node<E> implements Position<E> {
		private E element;
		private Node<E> parent;
		private Node<E> left;
		private Node<E> right;
		
		public Node(E e, Node<E> p, Node<E> l, Node<E> r) {
			this.element = e;
			this.parent = p;
			this.left = l;
			this.right = r;
		}

		public E getElement() throws IllegalStateException {
			return element;
		}

		public void setElement(E element) {
			this.element = element;
		}

		public Node<E> getParent() {
			return parent;
		}

		public void setParent(Node<E> parent) {
			this.parent = parent;
		}

		public Node<E> getLeft() {
			return left;
		}

		public void setLeft(Node<E> left) {
			this.left = left;
		}

		public Node<E> getRight() {
			return right;
		}

		public void setRight(Node<E> right) {
			this.right = right;
		}
		
	}// END OF NESTED CLASS
	
	//Factory function to create a new node storing element e. 
	protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
		return new Node<E>(e, parent, left, right);
	}
	
	// LinkedBinaryTree instance variables
	protected Node<E> root = null; // root of the tree
	private int size = 0; // number of nodes in the tree
	
	// constructor
	public LinkedBinaryTree() { } // constructs an empty binary tree
	
	// nonpublic utility
	// Validates the position and returns it as a node. 
	protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node))
			throw new IllegalArgumentException("Not valid position type");
		Node<E> node = (Node<E>) p; // safe cast
		if (node.getParent( ) == node) // our convention for defunct node
			throw new IllegalArgumentException("p is no longer in the tree");
		return node;
	}
	
	public boolean hasRightSibling(Position<E> p) {
		Node<E> node = validate(p);
		try {
			return node.getParent().getRight() != null && !node.getParent().getRight().equals(node);
		}catch(NullPointerException e) {
			return false;
		}
	}
	
	@Override
	public Position<E> left(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getLeft();
	}

	@Override
	public Position<E> right(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getRight();
	}

	@Override
	public Position<E> root() {
		return root;
	}

	@Override
	public Position<E> parent(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getParent();
	}

	@Override
	public int size() {
		return size;
	}
	
	public Position<E> addRoot(E e) throws IllegalStateException {
		if (!isEmpty( )) throw new IllegalStateException("Tree is not empty");
		root = createNode(e, null, null, null);
		size = 1;
		return root;
	}
	
	public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException{
		Node<E> parent = validate(p);
		if(parent.getLeft() != null) throw new IllegalArgumentException("p already has a left child");
		Node<E> child = createNode(e, parent, null, null);
		parent.setLeft(child);
		size++;
		return child;
	}
	
	public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException{
		Node<E> parent = validate(p);
		if(parent.getRight() != null) throw new IllegalArgumentException("p already has a right child");
		Node<E> child = createNode(e, parent, null, null);
		parent.setRight(child);
		size++;
		return child;
	}
	
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E temp = node.getElement();
		node.setElement(e);
		return temp;
	}
	
	// Attaches trees t1 and t2 as left and right subtrees of external p.
	public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) 
			throws IllegalArgumentException {
		Node<E> node = validate(p);
		if (isInternal(p)) throw new IllegalArgumentException("p must be a leaf");
		size += t1.size() + t2.size();
		if (!t1.isEmpty()) {
			t1.root.setParent(node);
			node.setLeft(t1.root);
			t1.root = null;
			t1.size = 0;
		}
		if(!t2.isEmpty()) {
			t2.root.setParent(node);
			node.setRight(t2.root);
			t2.root = null;
			t2.size = 0;
		}
	}
	
	public E remove(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		if(numChildren(p) == 2)
			throw new IllegalArgumentException("p has two children");
		Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
		if (child != null)
			child.setParent(node.getParent()); // child’s grandparent becomes its parent
		if (node == root)
			root = child;
		else {
			Node<E> parent = node.getParent();
			if (node == parent.getLeft())
				parent.setLeft(child);
			else
				parent.setRight(child);
		}
		size--;
		E temp = node.getElement();
		node.setElement(null); // help garbage collection
		node.setLeft(null);
		node.setRight(null);
		node.setParent(node);
		return temp;
	}
	
	public void pruneSubtree(Position<E> p) {
		if(this.isExternal(p)) {
			size--;
			remove(p);
		}else
			for(Position<E> c : children(p))
				pruneSubtree(c);
	}
	
	public void swap(Position<E> p, Position<E> q) {
		Node<E> node = validate(p);
		Node<E> node2 = validate(q);
		Node<E> temp = this.createNode(p.getElement(), node.parent, node.left, node.right);
		node.setParent(node2.getParent());
		node.setLeft(node2.left);
		node.setRight(node2.right);
		node2.setParent(temp.parent);
		node2.setLeft(temp.left);
		node2.setRight(temp.right);
		temp.setLeft(null);
		temp.setRight(null);
		temp.setParent(null);
	}
	
	public LinkedBinaryTree<E> clone() throws CloneNotSupportedException{
		LinkedBinaryTree<E> other = (LinkedBinaryTree<E>) super.clone();
		other.root = this.root;
		for(Position<E> walk : positions()) {
			Node<E> node = validate(walk);
			createNode(node.getElement(), node.parent, node.left, node.right);
			if(node.parent.left == null)
				node.parent.setLeft(node);
			else node.parent.setRight(node);
		}
		return other;
			
	}

}
