package dataStructures;

public class ArrayQueue<E> implements Queue<E>, Cloneable {
	private E[] data;
	private int f = 0;
	private int sz = 0;
	public ArrayQueue() {
		data = (E[]) new Object[ArrayStack.CAPACITY];
	}
	public ArrayQueue(int capacity) {
		data = (E[]) new Object[capacity];
	}
	@Override
	public int size() {
		return this.sz;
	}

	@Override
	public boolean isEmpty() {
		return sz == 0;
	}

	@Override
	public void enqueue(E e) throws IllegalStateException {
		if (sz == data.length) throw new IllegalStateException("Queue is full");
		int avail = (f + sz) % data.length;
		data[avail] = e;
		sz++;
	}

	@Override
	public E first() {
		if(isEmpty()) return null;
		return data[f];
	}

	@Override
	public E dequeue() {
		if(isEmpty()) return null;
		E answer = data[f];
		data[f] = null;
		f = (f + 1) % data.length;
		sz--;
		return answer;
	}
	public ArrayQueue<E> clone() throws CloneNotSupportedException {
		ArrayQueue<E> other = new ArrayQueue<>(this.size());
		if(!isEmpty()) {
			ArrayQueue<E> temp = new ArrayQueue<>(this.size());
			while(!isEmpty()) {
				E e = this.first();
				other.enqueue(this.dequeue());
				temp.enqueue(e);
			}
			while(!temp.isEmpty())
				this.enqueue(temp.dequeue());
		}
		return other;
	}

}
