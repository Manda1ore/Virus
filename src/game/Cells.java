package game;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.util.Random;

public abstract class Cells implements Hitter, Shape{
	protected int xSpeed;
	protected int ySpeed;
	protected Random ran;
	protected Point place;
	protected int size;
	protected int radius;
	protected double centerX;
	protected double centerY;
	protected boolean didHit = false;

	public Cells() {
		size = 0;
		ran = new Random();
		setLocation();
		radius = size / 2;
		
		
	}
	public void setCenter(){
		centerX = getLocation().x + radius;
		centerY = getLocation().y + radius;
	}

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

	public int getRadius() {
		return radius;
	}

	public double getCenterX() {
		return centerX;
	}

	public double getCenterY() {
		return centerY;
	}

	public abstract void setSize(Difficulty d);

	public void setLocation() {
		place = new Point(ran.nextInt(2100), 0);
	}

	public abstract int getSize();

	public abstract Color getColor();

	public Point getLocation() {		
		return place;
	}

	public void move() {
		if (place.getLocation().y > 900 - (getSize())) {
			place.setLocation(place.getLocation().x, 0);
		}
		if (place.getLocation().x > 1900 - (getSize())) {
			place.setLocation(0, place.getLocation().y);
		}
		if (place.getLocation().x < 0) {
			place.setLocation(1900 - (getSize()), place.getLocation().y);
		}
		if (place.getLocation().y < 0) {
			place.setLocation(place.getLocation().y, 900 - (getSize()));
		}
		if (react()){
			xSpeed = -xSpeed;
		}
		centerX = place.getX() + radius;
		centerY = place.getY() + radius;
		place.translate(xSpeed, ySpeed);
		
	}

	public void setLocation(Point point) {
	}
	@Override
	public boolean intersects(double x, double y, double w, double h) {
		if(x >= place.getX() && x <= place.getX() + size && y >= place.getY() && y <= place.getY() + size){
			didHit = true;
		}else if(x + w >= place.getX() && x + w <= place.getX() + size && y + h >= place.getY() && y + h <= place.getY() + size){
			didHit = true;
		}else {
			didHit = false;
		}
		
		return didHit;
	}
	
	@Override
	public boolean contains(double x, double y, double w, double h) {
		return didHit;
	}
	public abstract String image();
}
