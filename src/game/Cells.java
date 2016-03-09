package game;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.util.Random;
/**
 * 
 * @author Jacob Althouse
 *
 */
public abstract class Cells implements Hitter, Shape{
	protected int xSpeed;
	protected int ySpeed;
	protected Random ran;
	protected Point place;
	protected int size;
	protected CellType type;
	private int yBoundry;
	private int xBoundry;
	/**
	 * sets the placement once and initializes the size
	 * and tells the cell how far it can go before it goes around
	 * @param xBoundries is the farthest right the cell can go to the right
	 * @param yBoundries is the farthest down the cell can go to the bottom
	 */
	public Cells(int xBoundries, int yBoundries) {
		size = 0;
		ran = new Random();
		setLocation(xBoundries);
		yBoundry = yBoundries;
		xBoundry = xBoundries;
	}
/**
 * The speed of the cells are determined based on the difficulty
 * @param d = difficulty
 */
	public void setSpeed(Difficulty d) {
		if (d.equals(Difficulty.EASY)) {
			xSpeed = ran.nextInt(7) - 4;
			ySpeed = ran.nextInt(6) + 1;
		} else if (d.equals(Difficulty.MEDIUM)) {
			xSpeed = ran.nextInt(15) - 7;
			ySpeed = ran.nextInt(6) + 1;
		} else if (d.equals(Difficulty.HARD)) {
			xSpeed = ran.nextInt(15) - 7;
			ySpeed = ran.nextInt(10) + 1;
		} else {
			xSpeed = ran.nextInt(21) - 10;
			ySpeed = ran.nextInt(10) + 1;
		}
	}
/**
 * it determines the size by the difficulty
 * @param d = difficulty
 * 
 */
	public abstract void setSize(Difficulty d);
/**
 * sets the beginning location for the cell
 * @param xBoundries is the farthest right it can be placed
 */
	private void setLocation(int xBoundries) {
		place = new Point(ran.nextInt(xBoundries), 0);
	}
/**
 * gets the size of the cell
 * @return
 */
	public abstract int getSize();
/**
 * This give the color of the cell in use;
 * @return
 */
	public abstract Color getColor();
/**
 * returns a copy of the actual position
 * @return
 */
	public Point getLocation() {		
		return new Point(place);
	}
/**
 * move allows for the cells to move and go to the other side when it goes off screen
 */
	public void move() {
		if (place.getLocation().y > yBoundry - (getSize())) {
			place.setLocation(place.getLocation().x, 0);
		}
		if (place.getLocation().x > xBoundry - (getSize())) {
			place.setLocation(0, place.getLocation().y);
		}
		if (place.getLocation().x < 0) {
			place.setLocation(xBoundry - (getSize()), place.getLocation().y);
		}
		if (place.getLocation().y < 0) {
			place.setLocation(place.getLocation().y, yBoundry - (getSize()));
		}
		place.translate(xSpeed, ySpeed);
		
	}
/**
 * Allows for the control of the White cell by the mouse
 * @param point
 */
	public void setLocation(Point point) {
	}
	@Override
	/**
	 * interface allowing for the cell to detect any cell that it touches
	 */
	public boolean intersects(double x, double y, double w, double h) {
		boolean didHit = false;
		if(x+ size >= place.getX() + size && x <= place.getX() + size && y >= place.getY() && y <= place.getY() + size){
			didHit = true;
		}
		return didHit;
	}
	
	@Override
	/**
	 * 
	 */
	public boolean contains(double x, double y, double w, double h) {
		return false;
	}
	/**
	 * gives the type of cell that is given from child classes
	 * @return
	 */
	public abstract CellType type();
	/**
	 * returns the image of the cell allowing for a picture representation of the virus
	 * @return
	 */
	public abstract String image();
}
