package dataStructures;

import dataStructures.LinkedBinaryTree.Node;

public class LinkedTree<E> extends AbstractTree<E> {
	protected static class Node<E> implements Position<E> {
		E element;
		Node<E> parent;
		List<Position<E>> children;
		
		public Node(E e, Node<E> p, List<Position<E>> c) {
			this.element = e;
			this.parent = p;
			this.children = c;
		}
		
		public E getElement() throws IllegalStateException {
			return this.element;
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
		
		public List<Position<E>> getChildren() {
			return this.children;
		}
		
		public void setChildren(List<Position<E>> children) {
			this.children = children;
		}
		
	}// END OF NESTED CLASS
	
	//Factory function to create a new node storing element e. 
		protected Node<E> createNode(E e, Node<E> parent, List<Position<E>> c) {
			return new Node<E>(e, parent, c);
		}
		
		// LinkedBinaryTree instance variables
		protected Node<E> root = null; // root of the tree
		private int size = 0; // number of nodes in the tree
		
		// constructor
		public LinkedTree() {} // constructs an empty binary tree
		
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
		
	@Override
	public Position<E> root() {
		return root;
	}

	@Override
	public Position<E> parent(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.parent;
	}

	@Override
	public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		List<Position<E>> children = new ArrayList<>(8);
		for(Position<E> pos : node.children)
			children.add((Position<E>) pos);
		return (Iterable<Position<E>>) children;
	}

	@Override
	public int numChildren(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.children.size();
	}

	@Override
	public int size() {
		return size;
	}
	
	public Position<E> addRoot(E e) throws IllegalStateException {
		if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
		root = createNode(e, null, null);
		size = 1;
		return root;
	}
	
	public Position<E> addChild(Position<E> p, E e) throws IllegalStateException {
		Node<E> parent = validate(p);
		Node<E> child = createNode(e, parent, null);
		if(parent.children.isEmpty()) {
			parent.children =  new ArrayList<Position<E>>(8);
			parent.children.add(child);
		}else
			parent.children.add(child);
		size++;
		return child;
	}
	
	public E remove(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		Node<E> child = validate(node.children.get(0));
		if(child != null)
			child.setParent(node.parent);
		if(child == root)
			root = child;
		size--;
		E temp = node.getElement();
		node.setElement(null); // help garbage collection
		node.setChildren(null);
		node.setParent(node);
		return temp;
	}
	
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E temp = node.getElement();
		node.setElement(e);
		return temp;
	}

}
