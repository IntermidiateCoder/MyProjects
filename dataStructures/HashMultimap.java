package dataStructures;

public class HashMultimap<K,V> {
	Map<K,List<V>> map = new ChainHashMap<>(); // the primary map
	int total = 0;

	public HashMultimap() {}
	
	public int size() { return total; }
	public boolean isEmpty() { return (total == 0); }
	// Returns a (possibly empty) iteration of all values associated with the key. 
	Iterable<V> get(K key) {
		List<V> secondary = map.get(key);
		if (secondary != null)
			return secondary;
		return new ArrayList<>(); // return an empty list of values
	}
	
	void put(K key, V value) {
		List<V> secondary = map.get(key);
		if (secondary == null) {
			secondary = new ArrayList<>( );
			map.put(key, secondary); // begin using new list as secondary structure
		}
		secondary.add(value);
		total++;
	}
	
	boolean remove(K key, V value) {
		List<V> secondary = map.get(key);
		boolean wasRemoved = false;
		if (secondary != null) {
			int i = 0;
			for(V val : secondary) {
				if(val.equals(value)) {
					secondary.remove(i);
					wasRemoved = true;
				}
				i++;
			}
		}
		if (wasRemoved) {
			total--;
			if(secondary.isEmpty())
				map.remove(key); // remove secondary structure from primary map
		}
		return wasRemoved;
	}
	
	Iterable<V> removeAll(K key) {
		List<V> secondary = map.get(key);
		if (secondary != null) {
			total -= secondary.size();
			map.remove(key);
		}else
			secondary = new ArrayList<>(); // return empty list of removed values
		return secondary;
	}
	
	Iterable<Entry<K,V>> entries() {
		List<Entry<K,V>> result = new ArrayList<>();
		for (Entry<K,List<V>> secondary : map.entrySet()) {
			K key = secondary.getKey();
			for (V value : secondary.getValue())
				result.add(new AbstractMap.MapEntry<K,V>(key,value));
		}
		return result;
	}

}
