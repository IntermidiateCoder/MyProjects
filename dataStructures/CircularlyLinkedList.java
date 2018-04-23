package dataStructures;

public class CircularlyLinkedList<E> implements Cloneable {
	private static class Node<E> {
		private E element;
		private Node<E> next;
		public Node(E e, Node<E> n) {
			this.element = e;
			this.next = n;
		}
		public Node<E> getNext() {
			return next;
		}
		public void setNext(Node<E> next) {
			this.next = next;
		}
		public E getElement() {
			return element;
		}
	}
	private Node<E> tail = null;
	private int size = 0;
	public CircularlyLinkedList() { } // constructs an initially empty list
	// access methods
	public int size() { return size; }
	public boolean isEmpty() { return size == 0; }
	public E first() { // returns (but does not remove) the first element
		if (isEmpty()) return null;
		return tail.getNext().getElement();
	}
	public E last() { // returns (but does not remove) the last element
		if (isEmpty()) return null;
		return tail.getElement();
	}
	public void rotate() {
		if(tail != null)
			tail = tail.getNext();
	}
	public void addFirst(E e) {
		if(size == 0) {
			tail = new Node<>(e,null);
			tail.setNext(tail);
		}else {
			Node<E> newest = new Node<>(e,tail.getNext());
			tail.setNext(newest);
		}
		size++;	
	}
	public void addLast(E e) {
		addFirst(e);
		tail = tail.getNext();
	}
	public E removeFirst() {
		if(isEmpty()) return null;
		Node<E> head = tail.getNext();
		if(tail == head) tail = null;
		else tail.setNext(head.getNext());
		size--;
		return head.getElement();
	}
	public boolean equals(Object o) {
		 if (o == null) return false;
		 if (getClass() != o.getClass()) return false;
		 CircularlyLinkedList<?> other = (CircularlyLinkedList<?>) o; // use nonparameterized type
		 if (size != other.size) return false;
		 Node walkA = tail.getNext();
		 Node walkB = other.tail.getNext();
		 while (walkA != null){
			 if (!walkA.getElement().equals(walkB.getElement())) return false; //mismatch
			 walkA = walkA.getNext();
			 walkB = walkB.getNext();
		 }
		 return true;
	}
	public CircularlyLinkedList<E> clone() throws CloneNotSupportedException{
		CircularlyLinkedList<E> other = (CircularlyLinkedList<E>) super.clone();
		if(this.size > 0) {
			other.tail = new Node<>(tail.getElement(), null);
			other.tail.setNext(tail);
			Node<E> walk = this.tail.getNext();
			Node<E> otherTail = other.tail.getNext();
			while(!walk.equals(this.tail)) {
				Node<E> newest = new Node<>(walk.getElement(), other.tail);
				otherTail.setNext(newest);
				otherTail = newest;
				walk = walk.getNext();
			}
		}
		return other;
	}
}
