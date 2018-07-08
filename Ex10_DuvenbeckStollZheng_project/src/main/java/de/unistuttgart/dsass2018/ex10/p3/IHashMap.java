package de.unistuttgart.dsass2018.ex10.p3;

import java.util.Iterator;

/**
 * A simple and basic interface for hash maps.<br/>
 * 
 * This interface provides some basic functions to <code>put</code> a new
 * element according to the key into the Hash table. It also provides function
 * to check whether the hash map <code>contains</code> an element specified by
 * their key, to <code>retrieve</code> the element specified by their key and a
 * method to <code>remove</code> an element from the Hash map.<br/>
 * 
 * This interface can be used for dynamic or static hash maps.
 * 
 * @param <K>
 *            The type of the keys stored in this hash map
 * @param <V>
 *            the type of the values stored in this hash map
 */
public interface IHashMap<K, V> extends Iterable<V> {

	/**
	 * Put a new element into the Hash map with the given key and the given
	 * value. If the key has previously been added to the hash map returns the
	 * old value and replaces it with the new value.
	 * 
	 * @param key
	 *            The key to insert into the Hash map
	 * @param value
	 *            The value to insert into the Hash map
	 * @return
	 */
	public V put(K key, V value);

	/**
	 * Check whether the given key is contained in the Hash map. Return true if
	 * the key is found otherwise false
	 * 
	 * @param key
	 *            the key to search for in the hash map
	 * @return true if the key has been found false otherwise
	 */
	public boolean contains(K key);

	/**
	 * Retrieve the value of the the given key in the Hash map and return it. If
	 * there is no such key, this function will return null.
	 * 
	 * Note: In case someone wants to allow null values in the Hash map you can
	 * still make sure whether the key is contained in the Hash map by first
	 * calling the contains function to determine which null was meant there
	 * 
	 * @param key
	 *            The key to search for
	 * @return the value to the key if the key is found, otherwise null
	 */
	public V retrieve(K key);

	/**
	 * Remove the given key and its value from the hash map
	 * 
	 * Note: This function must also rebuild the Map structure.
	 * 
	 * In case the interface is used in an closed hash map implementation one
	 * needs at worst case to re-put all the elements into the hash map again
	 * since a previously blocked place has now been freed.
	 * 
	 * In case this interface is used in an open hash map implementation one
	 * needs to make sure the two list-parts are still connected to each other
	 * which is quite obvious
	 * 
	 * @param key
	 *            the key to identify the key-value pair which is to be removed
	 * @return the value of the key that has been removed
	 */
	public V remove(K key);

	/**
	 * Return an iterator which iterates over the values in the hash map.
	 * 
	 * @return Iterator over the values
	 */
	public Iterator<V> iterator();

	/**
	 * Return an Iterator which iterates over the key-value pairs in the hash
	 * map.
	 * 
	 * @return Iterator over the key-value pairs
	 */
	public Iterator<KeyValuePair<K, V>> keyValuePairIterator();
}
