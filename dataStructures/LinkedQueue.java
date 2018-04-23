package dataStructures;

// Realization of a FIFO queue as an adaptation of a SinglyLinkedList. 
public class LinkedQueue<E> implements CircularQueue<E> {
	private CircularlyLinkedList<E> list = new CircularlyLinkedList<>( ); // an empty list
	public LinkedQueue( ) { } // new queue relies on the initially empty list
	public int size( ) { return list.size( ); }
	public boolean isEmpty( ) { return list.isEmpty( ); }
	public void enqueue(E element) { list.addLast(element); }
	public E first( ) { return list.first( ); }
	public E dequeue( ) { return list.removeFirst( ); }
	@Override
	public void rotate() {
		list.rotate();
	}
 }
