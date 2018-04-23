package dataStructures;

public class DoublyLinkedList<E> {
	private static class Node<E> {
		private E element;
		private Node<E> prev;
		private Node<E> next;
		public Node(E e, Node<E> p, Node<E> n) {
			this.element = e;
			this.prev = p;
			this.next = n;
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
		public E getElement() {
			return element;
		}
	}
	// instance variables of the DoublyLinkedList
	 private Node<E> header; // header sentinel
	 private Node<E> trailer; // trailer sentinel
	 private int size = 0; // number of elements in the list
	 public DoublyLinkedList() {
		 header = new Node<>(null, null, null); // create header
		 trailer = new Node<>(null, header, null); // trailer is preceded by header
		 header.setNext(trailer); // header is followed by trailer
	 }
	 public int size() { return size; }
	 public boolean isEmpty() { return size == 0; }
	 //Returns (but does not remove) the first element of the list. //
	 public E first() {
		 if (isEmpty()) return null;
		 return header.getNext().getElement(); // first element is beyond header
	 }
	 //Returns (but does not remove) the last element of the list. //
	 public E last() {
		 if (isEmpty()) return null;
		 return trailer.getPrev().getElement(); // last element is before trailer
	 }
	 private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		 Node<E> newest = new Node<>(e, predecessor, successor);
		 predecessor.setNext(newest);
		 successor.setPrev(newest);
		 size++;
	 }
	 public void addFirst(E e) {
		 addBetween(e, header, header.getNext());
	 }
	 public void addLast(E e) {
		 addBetween(e, trailer.getPrev(), trailer);
	 }
	 private E remove(Node<E> node) {
		 Node<E> predecessor = node.getPrev();
		 Node<E> successor = node.getNext();
		 predecessor.setNext(successor);
		 successor.setPrev(predecessor);
		 size--;
		 return node.getElement();
	 }
	 public E removeFirst() {
		 if(isEmpty()) return null;
		 return remove(header.getNext());
	 }
	 public E removeLast() {
		 if(isEmpty()) return null;
		 return remove(trailer.getPrev());
	 }
	 public boolean equals(Object o) {
		 if(o == null) return false;
		 if(o.getClass() != this.getClass()) return false;
		 DoublyLinkedList other = (DoublyLinkedList) o;
		 if(this.size != other.size) return false;
		 Node walkA = this.header;
		 Node walkB = other.header;
		 while(!walkA.equals(trailer)) {
			 if(!walkA.getElement().equals(walkA.getElement())) return false;
			 walkA = walkA.getNext();
			 walkB = walkB.getNext();
		 }
		 return true;
	 }
	 public DoublyLinkedList<E> clone() throws CloneNotSupportedException {
		 DoublyLinkedList<E> other = (DoublyLinkedList<E>) super.clone();
		 if(this.size > 0) {
			 Node<E> otherFirst = other.header.getNext();
			 otherFirst = new Node<E>(this.header.getNext().getElement(), other.header, other.trailer);
			 Node<E> walk = this.header.getNext().getNext();
			 Node<E> otherTail = otherFirst;
			 while(walk != this.trailer) {
				 Node<E> newest = new Node<>(walk.getElement(), otherTail.getPrev(), other.trailer);
				 otherTail.setNext(newest);
				 otherTail.setPrev(otherTail.getPrev());
				 otherTail = newest;
				 walk = walk.getNext();
			 }
		 }
		 return other;
	 }
}
