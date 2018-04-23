package dataStructures;

public class ArrayDeque<E> implements Deque<E> {
	private int f = 0;
	private int l = 0;
	private E[] data;
	private int sz = 0;
	public ArrayDeque(){
		this.data = (E[]) new Object[ArrayStack.CAPACITY];
	}
	public ArrayDeque(int capacity) {
		this.data = (E[]) new Object[capacity];
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
	public E first() {
		if(isEmpty()) return null;
		return data[f];
	}

	@Override
	public E last() {
		if(isEmpty()) return null;
		return data[l];
	}

	@Override
	public void addFirst(E e) throws IllegalStateException {
		if (sz == data.length) throw new IllegalStateException("Queue is full");
		E temp = data[f];
		for(int i=1;i<sz+1;i++) {
			E temp2 = data[(f+i)%data.length];
			data[(f+i)%data.length] = temp;
			temp = temp2;
		}
		data[f] = e;
		l = (l + 1) % data.length;
		sz++;
	}

	@Override
	public void addLast(E e) throws IllegalStateException {
		if (sz == data.length) throw new IllegalStateException("Queue is full");
		int avail = (f + sz) % data.length;
		data[avail] = e;
		if(!isEmpty()) l = (l + 1) % data.length;
		sz++;
	}

	@Override
	public E removeFirst() {
		if(isEmpty()) return null;
		E answer = data[f];
		data[f] = null;
		f = (f + 1) % data.length;
		sz--;
		return answer;
	}

	@Override
	public E removeLast() {
		if(isEmpty()) return null;
		E answer = data[l];
		data[l] = null;
		l = (l - 1) % data.length;
		sz--;
		return answer;
	}
	public static void main(String[] args) {
		ArrayDeque<String> a = new ArrayDeque<>();
		a.addLast("1");
		System.out.println(a.first());
		a.addFirst("0");
		System.out.println(a.last() + a.first());
		a.removeFirst();
		System.out.println(a.last() + a.first());
		a.addFirst("2");
		a.addFirst("3");
		a.addLast("5");
		a.addLast("6");
		a.removeLast();
		System.out.println(a.last());
		a.removeFirst();
		System.out.println(a.first());
		
	}

}
