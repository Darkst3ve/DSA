package de.unistuttgart.dsass2018.ex05.p1;

import de.unistuttgart.dsass2018.ex05.p1.Point;

public class Rect {

	// parameters of a rect
	public float x;
	public float y;

	public float width;
	public float height;

	/**
	 * Creates a new rectangle
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param heigth
	 */
	public Rect(float x, float y, float width, float heigth) {
		this.x = x;
		this.y = y;

		this.width = width;
		this.height = heigth;
	}

	/**
	 * Checks if point p is contained in current rectangle
	 * 
	 * @param p:
	 *            point to check
	 */
	public boolean contains(Point p) {
		if (p.x >= this.x && p.y >= this.y) {
			if (p.x <= (this.x + this.width) && p.y <= (this.y + this.height)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Checks if the rectangle is initialized with proper values
	 * 
	 * @return True if parameters of the rectangle are initialized properly,
	 *         else False
	 */
	public boolean isInitialized() {

		if (this.width > 0 && this.height > 0)
			return true;

		return false;
	}

	/**
	 * Checks if current rectangle intersects r
	 * 
	 * @param r
	 *            Rectangle to check for intersection
	 * @return True if r intersects current rectangle, else False
	 */
	public boolean intersection(Rect r) {

		// projects the rectangles on the x and y axis and checks if the
		// intervals are overlapping

		boolean intersectionOnXAxis = intervallIntersection(this.x, this.x + this.width, r.x, r.x + r.width);
		boolean intersectionOnYAxis = intervallIntersection(this.y, this.y + this.height, r.y, r.y + r.height);

		if (intersectionOnXAxis && intersectionOnYAxis) {
			return true;
		}

		return false;

	}

	/**
	 * Internal method that checks if two intervals are overlapping
	 * 
	 * @param i1Left
	 *            First interval left
	 * @param i1Right
	 *            First interval right
	 * @param i2Left
	 *            Second interval left
	 * @param i2Right
	 *            Second interval right
	 * @return
	 */
	private boolean intervallIntersection(float i1Left, float i1Right, float i2Left, float i2Right) {

		if ((i2Left >= i1Left) && (i2Left < i1Right))
			return true;

		if ((i1Left >= i2Left) && (i1Left < i2Right))
			return true;

		return false;
	}

}
