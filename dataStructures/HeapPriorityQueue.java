package dataStructures;

import java.util.Comparator;

public class HeapPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {
	protected ArrayList<Entry<K,V>> heap = new ArrayList<>();
	public HeapPriorityQueue() { super(); }
	public HeapPriorityQueue(Comparator<K> comp) { super(comp); }
	// Creates a priority queue initialized with the given key-value pairs. 
	public HeapPriorityQueue(K[] keys, V[] values) {
		super();
		for (int j=0; j < Math.min(keys.length, values.length); j++)
			heap.add(new PQEntry<>(keys[j], values[j]));
		heapify();
	}
	
	// protected utilities
	// Performs a bottom-up construction of the heap in linear time. 
	protected void heapify() {
		int startIndex = parent(size()-1); // start at PARENT of last entry
		for (int j=startIndex; j >= 0; j--) // loop until processing the root
			downheap(j);
	}
	protected int parent(int j) { return (j-1) / 2; } // truncating division
	protected int left(int j) { return 2*j + 1; }
	protected int right(int j) { return 2*j + 2; }
	protected boolean hasLeft(int j) { return left(j) < heap.size(); }
	protected boolean hasRight(int j) { return right(j) < heap.size(); }
	
	// Exchanges the entries at indices i and j of the array list.
	protected void swap(int i, int j) {
		Entry<K,V> temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}
	
	// Moves the entry at index j higher, if necessary, to restore the heap property.
	protected void upheap(int j) {
		while (j > 0) { // continue until reaching root (or break statement)
			int p = parent(j);
			if (compare(heap.get(j), heap.get(p)) >= 0) break; // heap property verified
			swap(j, p);
			j = p;
		}
	}
	
	protected void recursiveUpheap(int j) {
		if (j > 0) { // continue until reaching root (or break statement)
			int p = parent(j);
			if (compare(heap.get(j), heap.get(p)) >= 0) return; // heap property verified
			swap(j, p);
			recursiveUpheap(j);
		}
	}
	
	// Moves the entry at index j lower, if necessary, to restore the heap property.
	protected void downheap(int j) {
		while (hasLeft(j)) { 		// continue to bottom (or break statement)
			int leftIndex = left(j);
			int smallestChild = leftIndex;
			if (hasRight(j)) {
				int rightIndex = right(j);
				if (compare(heap.get(leftIndex), heap.get(rightIndex)) > 0)
					smallestChild = rightIndex;
			}
			if (compare(heap.get(smallestChild), heap.get(j)) >= 0)
				break;  			// heap property has been restored.
			swap(j, smallestChild);
			j = smallestChild;		// continue at position of the child
		}
	}
	
	protected void recursiveDownheap(int j) {
		if (hasLeft(j)) { 		// continue to bottom (or break statement)
			int leftIndex = left(j);
			int smallestChild = leftIndex;
			if (hasRight(j)) {
				int rightIndex = right(j);
				if (compare(heap.get(leftIndex), heap.get(rightIndex)) > 0)
					smallestChild = rightIndex;
			}
			if (compare(heap.get(smallestChild), heap.get(j)) >= 0)
				return;  			// heap property has been restored.
			swap(j, smallestChild);
			recursiveDownheap(smallestChild);		// continue at position of the child
		}
	}
	
	@Override
	public int size() {
		return heap.size();
	}

	@Override
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		checkKey(key);
		Entry<K,V> newest = new PQEntry<>(key, value);
		heap.add(newest);
		upheap(heap.size() - 1);
		return newest;
	}

	@Override
	public Entry<K, V> min() {
		if (heap.isEmpty()) return null;
		return heap.get(0);
	}

	@Override
	public Entry<K, V> removeMin() {
		if (heap.isEmpty( )) return null;
		Entry<K,V> answer = heap.get(0);
		swap(0, heap.size()-1);
		heap.remove(heap.size()-1);
		downheap(0);
		return answer;
	}
	
	
}
