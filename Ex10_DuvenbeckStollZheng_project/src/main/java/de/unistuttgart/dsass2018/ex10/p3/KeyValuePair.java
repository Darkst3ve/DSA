package de.unistuttgart.dsass2018.ex10.p3;

/**
 * KeyValue Pair class which is used to represent single entries in the hash
 * map. Each element of this class consists of a value and a key where both
 * values might be changed using the provided getter and setter methods.
 * 
 * @param <K>
 *            Type of the Key
 * @param <V>
 *            Type of the Value
 */
public class KeyValuePair<K, V> {
	protected K key;
	protected V value;

	private static final String ERR_ARG_NULL = "Null is not a valid value.";

	/**
	 * Create a new Key-Value Pair with the given key and the given value
	 * 
	 * @param key
	 *            the key of the key value pair
	 * @param value
	 *            the value of the key value pair
	 */
	public KeyValuePair(K key, V value) throws IllegalArgumentException {
		if (value == null)
			throw new IllegalArgumentException(ERR_ARG_NULL);
		this.key = key;
		this.value = value;
	}

	/**
	 * Return the Key of the underlying Key-Value Pair
	 * 
	 * @return the key of the underlying Key-Value Pair
	 */
	public K getKey() {
		return this.key;
	}

	/**
	 * Set the Key of the underlying Key-Value Pair
	 * 
	 * @param key
	 *            the new key to set
	 * @return the old key will be returned
	 */
	public K setKey(K key) {
		K k = this.key;
		this.key = key;
		return k;
	}

	/**
	 * Return the Value of the underlying Key-Value Pair
	 * 
	 * @return the value of the underlying Key-Value Pair
	 */
	public V getValue() {
		return this.value;
	}

	/**
	 * Set the Value of the underlying Key-Value Pair
	 * 
	 * @param value
	 * @return
	 */
	public V setValue(V value) throws IllegalArgumentException {
		if (value == null)
			throw new IllegalArgumentException(ERR_ARG_NULL);
		V v = this.value;
		this.value = value;
		return v;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		KeyValuePair<K, V> other = (KeyValuePair<K, V>) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
}