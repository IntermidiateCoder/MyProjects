package dataStructures;

public class ArrayStack<E> implements Stack<E>, Cloneable {
	private int t = -1;
	public static final int CAPACITY = 1000;
	private E[] data;
	public ArrayStack(){
		data =(E[]) new Object[CAPACITY];
	}
	public ArrayStack(int capacity) {
		data = (E[]) new Object[capacity];
	}
	@Override
	public int size() {
		return t + 1;
	}

	@Override
	public boolean isEmpty(){
		return t == -1;
	}

	@Override
	public void push(E e) throws IllegalStateException {
		if (size( ) == data.length) throw new IllegalStateException("Stack is full");
		data[++t] = e;
	}

	@Override
	public E top() {
		if(isEmpty()) return null;
		return data[t];
	}

	@Override
	public E pop() {
		if(isEmpty()) return null;
		E answer = data[t];
		data[t] = null;
		t--;
		return answer;
	}
	
	public ArrayStack<E> clone() throws CloneNotSupportedException {
		ArrayStack<E> other = new ArrayStack<>(this.size());
		if(!isEmpty()) {
			ArrayStack<E> temp = new ArrayStack<>(this.size());
			while(!isEmpty()) {
				E e = this.top();
				other.push(this.pop());
				temp.push(e);
			}
			while(!temp.isEmpty())
				this.push(temp.pop());
		}
		return other;
	}

}
