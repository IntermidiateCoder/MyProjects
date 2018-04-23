package dataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalList<E> implements PositionalList<E>, Cloneable {
	//---------------- nested Node class ----------------
	private static class Node<E> implements Position<E>{
		private E element; // reference to the element stored at this node
		private Node<E> prev; // reference to the previous node in the list
		private Node<E> next; // reference to the subsequent node in the list
		public Node(E e, Node<E> p, Node<E> n) {
			this.element = e;
			this.prev = p;
			this.next = n;
		}
		public E getElement() throws IllegalStateException {
			if (next == null) // convention for defunct node
				throw new IllegalStateException("Position no longer valid");
			return element;
		}
		public Node<E> getPrev() {
			return prev;
		}
		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}
		public Node<E> getNext() {
			return next;
		}
		public void setNext(Node<E> next) {
			this.next = next;
		}
		public void setElement(E element) {
			this.element = element;
		}
	}
	//---------------- nested PositionIterator class ----------------
	 private class PositionIterator implements Iterator<Position<E>> {
		 private Position<E> cursor = first(); // position of the next element to report
		 private Position<E> recent = null; // position of last reported element
		 // Tests whether the iterator has a next object. 
		 public boolean hasNext() { return (cursor != null); }
		 // Returns the next position in the iterator. 
		 public Position<E> next() throws NoSuchElementException {
			 if (cursor == null) throw new NoSuchElementException("nothing left");
			 recent = cursor; // element at this position might later be removed
			 cursor = after(cursor);
			 return recent;
		 }
		 // Removes the element returned by most recent call to next. 
		 public void remove( ) throws IllegalStateException {
			 if (recent == null) throw new IllegalStateException("nothing to remove");
			 LinkedPositionalList.this.remove(recent); // remove from outer list
			 recent = null; // do not allow remove again until next is called
		 }
	 } //------------ end of nested PositionIterator class ------------
	
	 //---------------- nested PositionIterable class ----------------
	 private class PositionIterable implements Iterable<Position<E>> {
	 public Iterator<Position<E>> iterator( ) { return new PositionIterator( ); }
	 } //------------ end of nested PositionIterable class ------------
	
	 // Returns an iterable representation of the list's positions. 
	 public Iterable<Position<E>> positions( ) {
		 return new PositionIterable(); // create a new instance of the inner class
	 }
	
	 //---------------- nested ElementIterator class ----------------
	 // This class adapts the iteration produced by positions() to return elements. 
	 private class ElementIterator implements Iterator<E> {
		 Iterator<Position<E>> posIterator = new PositionIterator();
		 public boolean hasNext() { return posIterator.hasNext(); }
		 public E next() { return posIterator.next().getElement(); } // return element!
		 public void remove() { posIterator.remove(); }
	}
	
	//Returns an iterator of the elements stored in the list. 
	public Iterator<E> iterator() { return new ElementIterator(); }
	private Node<E> header;
	private Node<E> trailer;
	private int size = 0;
	
	//**** constructor ****\\
	public LinkedPositionalList() {
		this.header = new Node<>(null, null, null);
		this.trailer = new Node<>(null, header, null);
		this.header.setNext(trailer);
	}

	// private utilities
	// Validates the position and returns it as a node.
	private Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid p");
		Node<E> node = (Node<E>) p; // safe cast
		if (node.getNext() == null) // convention for defunct node
			throw new IllegalArgumentException("p is no longer in the list");
		return node;
	}
	
	// Returns the given node as a Position (or null, if it is a sentinel).
	private Position<E> position(Node<E> node) {
		if (node == header || node == trailer)
			return null;
		return node;
	}
	
	// public accessor methods
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Position<E> first() {
		return position(header.getNext());
	}

	@Override
	public Position<E> last() {
		return position(trailer.getPrev());
	}

	@Override
	public Position<E> before(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return position(node.getPrev());
	}

	@Override
	public Position<E> after(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return position(node.getNext());
	}
	
	// private utilities
	private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
		Node<E> newest = new Node<>(e, pred, succ); // create and link a new node
		pred.setNext(newest);
		succ.setPrev(newest);
		size++;
		return newest;
	}
	
	// public update methods
	@Override
	public Position<E> addFirst(E e) {
		return addBetween(e, header, header.getNext()); // just after the header
	}

	@Override
	public Position<E> addLast(E e) {
		return addBetween(e, trailer.getPrev(), trailer);
	}

	@Override
	public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return addBetween(e, node.getPrev(), node);
	}

	@Override
	public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return addBetween(e, node, node.getNext());
	}

	@Override
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E answer = node.getElement( );
		node.setElement(e);
		return answer;
	}

	@Override
	public E remove(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		E answer = node.getElement();
		node.setElement(null);
		node.setNext(null);
		node.setPrev(null);
		return answer;
	}
	
	//Insertion-sort of a positional list of integers into nondecreasing order 
	public static void insertionSort(PositionalList<Integer> list) {
		Position<Integer> marker = list.first( ); // last position known to be sorted
		while (marker != list.last( )) {
			Position<Integer> pivot = list.after(marker);
			int value = pivot.getElement( ); // number to be placed
			if (value > marker.getElement( )) // pivot is already sorted
				marker = pivot;
			else { // must relocate pivot
				Position<Integer> walk = marker; // find leftmost item greater than value
				while (walk != list.first( ) && list.before(walk).getElement( ) > value)
					walk = list.before(walk);
					list.remove(pivot); // remove pivot entry and
					list.addBefore(walk, value); // reinsert value in front of walk
			}
		}
	}

	@Override
	public void moveToFront(Position<E> p) {
		if(!p.equals(this.first())) {
			Node<E> node = validate(p);
			Node<E> first = validate(this.first());
			node.setNext(first);
			node.setPrev(header);
			first.setPrev(node);
		}
	}
	
	public LinkedPositionalList<E> clone() throws CloneNotSupportedException{
		LinkedPositionalList<E> other = (LinkedPositionalList<E>) super.clone();
		if(size > 0) {
			Position<E> head = other.first();
			head = new Node<>(first().getElement(), other.header, other.trailer);
			Position<E> walk = after(first());
			Position<E> otherTail = head;
			while(walk != this.trailer) {
				Position<E> newest = new Node<E>(walk.getElement(), (Node<E>) before(otherTail), other.trailer);
				((Node<E>) otherTail).setNext((Node<E>) newest);
				((Node<E>) otherTail).setPrev((Node<E>) before(otherTail));
				otherTail = newest;
				walk = after(walk);
			}
		}
		return other;
	}
	
	public void swap(Position<E> src, Position<E> dst) {
		Node<E> srcNode = validate(src);
		Node<E> dstNode = validate(dst);
		Node<E> srcNext = srcNode.next;
		Node<E> dstPrev = dstNode.prev;
		srcNode.setNext(dstNode.next);
		dstNode.setPrev(srcNode.prev);
		dstNode.setNext(srcNext);
		srcNode.setPrev(dstPrev);
	}
	
	public LinkedPositionalList<E> reverse() {
		LinkedPositionalList<E> tsil = new LinkedPositionalList<>();
		Node<E> last = validate(this.last());
		while(last != header) {
			tsil.addLast(last.element);
			last = last.prev;
		}
		return tsil;
	}
	
}
