package dataStructures;

import java.util.Comparator;

public abstract class AbstractSortedMap<K,V> extends AbstractMap<K,V> {
	protected Comparator<K> compare;
	protected AbstractSortedMap(Comparator<K> comp) {
		compare = comp;
	}

	protected AbstractSortedMap() {
		compare = (Comparator<K>) new DefaultComparator<K>();
	}
	
	public int compare(K key, MapEntry<K, V> mapEntry) {
		return compare.compare(key, mapEntry.getKey());
	}
	
	

}
