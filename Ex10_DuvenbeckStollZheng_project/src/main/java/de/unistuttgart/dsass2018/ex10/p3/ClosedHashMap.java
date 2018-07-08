package de.unistuttgart.dsass2018.ex10.p3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Lennart Duvenbeck | 2836913
 * @author Timo Stoll | 2976666
 * @author David Zheng | 3334362
 * 
 * 
 *         This class implements the basic functionality of a hash map. This
 *         Hash map increases its size dynamically based on the given max load
 *         factor.
 * 
 *         This class extends the abstract {@link AbstractHashMap} class and
 *         implements all of the required methods. *
 * 
 * @param <K>
 *            The type of the key to insert into the Hash map
 * @param <V>
 *            The type of the value to insert into the Hash map
 */
public class ClosedHashMap<K, V> extends AbstractHashMap<K, V> {

	/**
	 * Skipping factor for linear probing (lineares Sondieren)
	 */
	private final int skipping;

	/**
	 * Create a new ClosedHashMap with the given skipping factor
	 * 
	 * @param skipping
	 *            the skipping factor to apply to the hash map
	 */
	public ClosedHashMap(final int skipping) throws IllegalArgumentException {
		super();
		int size = this.getSize();

		if (skipping < 1)
			throw new IllegalArgumentException("The skipping value must be larger than or equal to one");

		// Checking for greatest common divisor is omitted in this
		// implementation.

		this.skipping = skipping % size;
	}

	/**
	 * Return the skipping factor of the hash map
	 * 
	 * @return skipping factor of the hash map
	 */
	public int getSkipping() {
		return skipping;
	}

	/**
	 * The remove function is not supported in this hash map implementation.
	 */
	@Override
	public V remove(K key) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Rehash the whole table into a new larger one. Note that this method is not
	 * using in-place rehashing but first creates a new table of the new size and
	 * than iterates over the old table, putting each entry into the new table by
	 * calling {@link #put(Object, Object)}.
	 */
	private void enlargeAndRehash() {

		this.increaseSize();

		// Get the old table and create and new one with the size doubled
		@SuppressWarnings("unchecked")
		KeyValuePair<K, V> newTable[] = new KeyValuePair[this.getSize()];
		KeyValuePair<K, V> oldTable[] = this.getTable();

		final int oldLength = oldTable.length;
		this.setTable(newTable);
		this.numElements = 0;

		// Iterate over the old table and put each element into the new one
		for (int i = 0; i < oldLength; ++i) {
			KeyValuePair<K, V> keyValuePair = oldTable[i];
			if (keyValuePair != null) {
				this.put(keyValuePair.getKey(), keyValuePair.getValue());
			}
		}
	}

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V retrieve(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<V> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<KeyValuePair<K, V>> keyValuePairIterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
