package dataStructures;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E>, Cloneable{
	 private class ArrayListIterator implements Iterator<E> {
		 private int cursor; // position of the next element to report
		 private int recent = -1; // position of last reported element
		 // Tests whether the iterator has a next object. 
		 public boolean hasNext() { return (cursor != size); }
		 // Returns the next position in the iterator. 
		 public E next() throws NoSuchElementException {
			 int i = cursor;
			 if (i >= size) throw new NoSuchElementException("nothing left");
			 Object[] elementData = ArrayList.this.data;
			 if(i >= elementData.length) throw new ConcurrentModificationException();
			 cursor = i + 1;
			 return (E) elementData[recent = i];
			 
		 }
		 // Removes the element returned by most recent call to next. 
		 public void remove( ) throws IllegalStateException {
			 if (recent < 0) throw new IllegalStateException("nothing to remove");
			 ArrayList.this.remove(recent); // remove from outer list
			 recent = -1; // do not allow remove again until next is called
		 }
	 }
	// instance variables
	public static final int CAPACITY=16; // default array capacity
	private E[] data; // generic array used for storage
	private int size = 0;
	// constructors
	public ArrayList() {
		this.data = (E[]) new Object[CAPACITY]; 
	}
	public ArrayList(int capacity) {
		this.data = (E[]) new Object[capacity]; 
	}
	// public methods
	@Override
	public int size() {
		return size;
	}
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		return data[i];
	}
	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		E temp = data[i];
		data[i] = e;
		return temp;
	}
	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i, size+1);
		if(size == data.length)
			resize(2*data.length);
		for(int k=size-1;k>=i;k--) 
			data[k+1] = data[k];
		data[i] = e;
		size++;
	}
	protected void resize(int capacity) {
		E[] temp = (E[]) new Object[capacity]; // safe cast; compiler may give warning
		for (int k=0; k < size; k++)
		temp[k] = data[k];
		data = temp; // start using the new array
	}
	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		checkIndex(i, size+1);
		E temp = data[i];
		if(size <= data.length/4)
			resize(data.length/2);
		for(int k=i; k<size-1;k++)
			data[k] = data[k+1];
		data[size-1] = null;
		size--;
		return temp;
	} 
	
	// utility method
	// Checks whether the given index is in the range [0, n-1].
	protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
		if (i < 0 || i >= n)
			throw new IndexOutOfBoundsException("Illegal index: " + i);
	}
	public boolean equals(Object o) {
		if (o == null) return false;
		if (o.getClass() != this.getClass()) return false;
		ArrayList<?> list = (ArrayList<?>)o;
		if (size != list.size()) return false;
		for (int i=0;i<size;i++) {
			E e = get(i);
			Object o1 = list.get(i);
			if (!e.equals(o1)) 
				return false;
		}
		return true;
		
	}
	public ArrayList<E> clone() throws CloneNotSupportedException {
		ArrayList<E> other = new ArrayList<>();
		if(size > 0)
			for(int i=0;i<size;i++)
				other.add(this.get(i));
		return other;
	}
	@Override
	public Iterator<E> iterator() { return new ArrayListIterator();}
	@Override
	public void add(E e) {
		add(size, e);
	}
	public void removeAll() {
		int n = size;
		for (int i=0;i<n;i++) 
			remove(0);
	}
	public void reverse() {
		ArrayList<E> ar = new ArrayList<>();
		for (int i=size-1;i>=0;i--) {		
			E e = get(i);
			ar.add(e);
		}
		for (int i=0;i<ar.size;i++) {
			this.set(i,ar.get(i));
		}
	}
	public void add(ArrayList<E> al) {
		for (E e : al) {
			add(e);
		}
	}
	
}
