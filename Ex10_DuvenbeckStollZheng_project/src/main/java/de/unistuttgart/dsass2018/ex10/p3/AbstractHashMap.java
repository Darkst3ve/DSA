package de.unistuttgart.dsass2018.ex10.p3;

/**
 * This abstract class can be extended by classes implementing a hash map. This
 * class implements the {@link de.unistuttgart.dsass2018.ex10.p3.IHashMap}
 * interface without implementing the methods which shall be implemented by the
 * derived class.
 * 
 * @param <K>
 *            The type of the keys stored in this hash map
 * @param <V>
 *            the type of the values stored in this hash map
 */
public abstract class AbstractHashMap<K, V> implements IHashMap<K, V> {

	/**
	 * The actual table that stores all key-value pairs
	 */
	private KeyValuePair<K, V> entries[];
	
	/**
	 * The current size of the table {@link #entries}
	 */
	private int size;
	
	/**
	 * The upper bound of the number of elements in the table before enlarging and rehashing is required  
	 */
	private int rehashThreshold;
	
	/**
	 * The maximum load factor of the table
	 */
	private double maxLoadFactor;

	/**
	 * The actual number of elements that are stored in the table 
	 */
	public int numElements;

	private static final String ERR_ARG_SIZE = "Size is invalid";
	private static final String ERR_ARG_LOAD_FACTOR = "Load factor is invalid";
	private static final String ERR_ARG_INDEX_OUT_OF_BOUND = "Position exceeds the table size.";

	/**
	 * Abstract constructor for the hash map which will create a new Entry table
	 * with space for 16 elements and a predefined max load factor of 75
	 * percent.
	 */
	public AbstractHashMap() {
		this(16, 0.75);
	}

	/**
	 * Abstract constructor for the hash map which will create a new Entry table
	 * with space for the specified number of elements, the constructor will set
	 * the max load factor to 75 percent.
	 * 
	 * @param size
	 *            the number of elements in the initial entry table
	 */
	public AbstractHashMap(int size) {
		this(size, 0.75);
	}

	/**
	 * Abstract constructor for the hash map which will create a new Entry table
	 * with space for the specified number of elements and maximum load factor.
	 * 
	 * @param size
	 *            the initial size of the {@link #entries} table
	 * @param maxLoadFactor
	 *            the max load factor, if the number of elements divided by the
	 *            number of max elements exceeds this value the table needs to
	 *            be rehashed
	 */
	@SuppressWarnings("unchecked")
	public AbstractHashMap(int size, double maxLoadFactor) {
		if (size < 1)
			throw new IllegalArgumentException(ERR_ARG_SIZE);
		if (maxLoadFactor <= 0 || maxLoadFactor >= 1)
			throw new IllegalArgumentException(ERR_ARG_LOAD_FACTOR);
		this.entries = new KeyValuePair[size];
		this.size = size;
		this.maxLoadFactor = maxLoadFactor;
		this.rehashThreshold = (int) (this.maxLoadFactor * this.size);
		this.numElements = 0;
	}

	/**
	 * Basic implementation of the hash function, this function calls the
	 * <code>hashCode</code> function provided by each Object and returns its
	 * value.
	 * 
	 * @param key
	 *            the key that is to be hashed
	 * @return the output of
	 */
	protected int hash(K key) {
		return key.hashCode();
	}

	/**
	 * This method will increase the maximum size and will set it twice as
	 * large.
	 * 
	 * Note: This function will not modify the entry table, this needs to be
	 * done by the extending class. The extending class also needs to take care
	 * of the rehashing process which needs to be done before or after calling
	 * this <code>increaseSize</code> function.
	 */
	protected void increaseSize() {
		this.size = this.size * 2;
		this.rehashThreshold = this.rehashThreshold * 2;
	}

	/**
	 * This method returns the size of the entry table.
	 * 
	 * @return the size of the entry table
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * Return the maximum number of elements accepted by this Hash map before
	 * being rehashed. If the number of elements in the table exceeds this value
	 * the whole table needs to be increased and rehashed.
	 * 
	 * @return the max number of elements in the underlying Hash map before
	 *         rehashing
	 */
	public int getRehashThreshold() {
		return this.rehashThreshold;
	}

	/**
	 * Return the max load factor for the hash map
	 * 
	 * @return the max load factor for the underlying hash map
	 */
	public double getMaxLoadFactor() {
		return this.maxLoadFactor;
	}

	/**
	 * Return the Key-Value Pair at the specified position in the entry table.
	 * 
	 * @param pos
	 *            The position to return the element from
	 * @return The Key-Value Pair at the specified position
	 * @throws IndexOutOfBoundsException
	 *             if the position is not inside the array bounds
	 */
	protected KeyValuePair<K, V> getKeyValuePairAt(int pos)
			throws IndexOutOfBoundsException {
		if (pos < 0 || pos > this.size)
			throw new IndexOutOfBoundsException(ERR_ARG_INDEX_OUT_OF_BOUND);
		return this.entries[pos];
	}

	/**
	 * Set the Key-Value Pair at the specified position in the entry table. This
	 * function will also return the old value (null or Key-Value Pair) that has
	 * previously been at this position.
	 * 
	 * @param pos
	 *            The position to insert the new element at and return the old
	 *            element from
	 * @param kvp
	 *            The Key-Value Pair to insert at the given position
	 * @return the Key-Value Pair that has been previously on this position in
	 *         the entry table or null
	 * @throws IllegalArgumentException
	 *             if the position is not inside the array bounds
	 */
	protected KeyValuePair<K, V> setAt(int pos, KeyValuePair<K, V> kvp)
			throws IllegalArgumentException {
		KeyValuePair<K, V> rkvp;
		if (pos < 0 || pos > this.size)
			throw new IndexOutOfBoundsException(ERR_ARG_INDEX_OUT_OF_BOUND);
		rkvp = this.entries[pos];
		this.entries[pos] = kvp;
		return rkvp;
	}

	/**
	 * Remove the element from the entries by setting its value to null. This
	 * method also returns the old value.
	 * 
	 * @param pos
	 *            The position to insert the new element at and return the old
	 *            element from
	 * @return the Key-Value Pair that has been previously on this position in
	 *         the entry table or null
	 * @throws IllegalArgumentException
	 *             if the position is not inside the array bounds
	 */
	protected KeyValuePair<K, V> removeAt(int pos)
			throws IllegalArgumentException {
		KeyValuePair<K, V> removedKeyValuePair;
		if (pos < 0 || pos > this.size)
			throw new IndexOutOfBoundsException(ERR_ARG_INDEX_OUT_OF_BOUND);
		removedKeyValuePair = this.entries[pos];
		this.entries[pos] = null;
		this.numElements--;
		return removedKeyValuePair;
	}

	/**
	 * Set the entry table to the given table
	 * 
	 * @param entries
	 *            the table to use for the entries
	 */
	protected void setTable(KeyValuePair<K, V>[] entries) {
		this.entries = entries;
	}

	/**
	 * Return the entry table that is used to insert the elements
	 * 
	 * @return the entry table
	 */
	public KeyValuePair<K, V>[] getTable() {
		return this.entries;
	}
}
