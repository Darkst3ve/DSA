package de.unistuttgart.dsass2018.ex05.p1;

import java.io.*;

import de.unistuttgart.dsass2018.ex05.p1.Point;

public abstract class ATreeObject {

	/**
	 * Returns the anchor point of a TreeObject
	 * 
	 * @return anchor point
	 */
	public abstract Point getLocation();

	/**
	 * Loads the content of a TreeObject from a reader
	 * 
	 * @param reader
	 *            Reference to a opened file
	 */
	public abstract void loadObjectFromFile(BufferedReader reader);

	/**
	 * This method writes the content of a TreeObject to a opened file
	 * 
	 * @param writer
	 *            Reference to a opened file
	 */
	public abstract void writeObjectToFile(FileWriter writer);

	/**
	 * Test if two TreeObjects are equal
	 * 
	 * @param a
	 *            this object is compared to a
	 * @return true if this object equals a
	 */
	public abstract boolean isEqual(ATreeObject a);

}
