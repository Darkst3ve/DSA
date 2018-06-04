package de.unistuttgart.dsass2018.ex05.p2;

import java.util.ArrayList;

public abstract class CollisionObject {
	
	abstract ArrayList<Point> coveredArea(); 
	
	/**
	 * Checks if there current object is colliding with obj
	 * @param obj
	 * @return
	 */
	public abstract boolean collisionWith(CollisionObject obj);
}
