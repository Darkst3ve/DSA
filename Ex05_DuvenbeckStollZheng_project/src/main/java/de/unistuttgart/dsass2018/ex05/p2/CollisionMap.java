package de.unistuttgart.dsass2018.ex05.p2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Class for Uebungsblatt 5 - Aufgabe 2.
 * 
 * @author Lennart Duvenbeck | 2836913
 * @author Timo Stoll | 2976666
 * @author David Zheng | 3334362
 * 
 */
public class CollisionMap {

	public Rect gridRect;
	public ArrayList<Rect> rectObstacleList;

	private ArrayList<ArrayList<ArrayList<CollisionObject>>> gridCollisionMap;

	/**
	 * Generates a CollisionMap from a list of CollisionObjects
	 * 
	 * @param rList
	 *            List of obstacles that should be placed within the
	 *            CollisionMap
	 */
	public CollisionMap(ArrayList<Rect> rList) {

		this.rectObstacleList = rList;
		this.calcBoundingRect();
		this.generateCollisionMap();

		this.fillCollisionMap();
	}

	/**
	 * Generates a Set of potential objects that could lead to a collision
	 * 
	 * @return
	 */
	public Set<CollisionObject> getCollisionCandidates(CollisionObject obj) {

		Set<CollisionObject> ret = new HashSet<CollisionObject>();
		// TODO: Insert code for Assignment 5.2 d
		return ret;
	}

	/**
	 * Fills the CollisionMap with the CollisionObjects
	 */
	public void fillCollisionMap() {
		// TODO: Insert code for Assignment 5.2 c
	}

	/**
	 * Inserts the object at position x, y
	 */
	public void insertCollisionObject(int x, int y, CollisionObject obj) {

		gridCollisionMap.get(x).get(y).add(obj);
	}

	/**
	 * Checks if a rectangle is colliding with something in the CollisionMap
	 * 
	 * @param rect
	 * @return
	 */
	public boolean checkCollision(Rect rect) {

		Set<CollisionObject> collisionCanidates = getCollisionCandidates(rect);

		for (CollisionObject o : collisionCanidates) {

			// check if actually a collision occurs
			if (o.collisionWith(rect)) {
				return true;
			}

		}
		return false;
	}

	/**
	 * Returns a list of objects that are covering position x, y
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public ArrayList<CollisionObject> getObstaclesAtPoint(int x, int y) {

		Point p = new Point(x, y);

		if (!this.gridRect.contains(p))
			return null;

		return this.gridCollisionMap.get(x).get(y);
	}

	/**
	 * Allocates memory for the CollisionMap
	 */
	public void generateCollisionMap() {

		this.gridCollisionMap = new ArrayList<ArrayList<ArrayList<CollisionObject>>>();

		for (int x = 0; x < this.gridRect.width; x++) {

			ArrayList<ArrayList<CollisionObject>> yArrayList = new ArrayList<ArrayList<CollisionObject>>();

			for (int y = 0; y < this.gridRect.height; y++) {

				yArrayList.add(new ArrayList<CollisionObject>());

			}

			this.gridCollisionMap.add(yArrayList);
		}

	}

	/**
	 * Calculates the area that is needed in order to store all
	 * CollisionObjects. Area is saved in gridArea.
	 */
	public void calcBoundingRect() {

		int min_x = Integer.MAX_VALUE;
		int max_x = Integer.MIN_VALUE;

		int min_y = Integer.MAX_VALUE;
		int max_y = Integer.MIN_VALUE;

		for (int i = 0; i < this.rectObstacleList.size(); i++) {

			Rect tRect = this.rectObstacleList.get(i);

			for (int x = (int) tRect.x; x < Math.ceil((double) (tRect.x + tRect.width)); x++) {
				if (x < min_x) {
					min_x = x;
				}
				if (x > max_x) {
					max_x = x;
				}

				for (int y = (int) tRect.y; y < Math.ceil((double) (tRect.y + tRect.height)); y++) {

					if (y < min_y) {
						min_y = y;
					}
					if (y > max_y) {
						max_y = y;
					}
				}
			}

		}

		this.gridRect = new Rect(min_x, min_y, max_x - min_x + 1, max_y - min_y + 1);
	}

}
