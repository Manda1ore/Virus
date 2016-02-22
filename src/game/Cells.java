package Virus.game;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public abstract class Cells implements Hitter{
	protected int xSpeed;
	protected int ySpeed;
	protected Random ran;
	protected Point place;
	protected int size = 0;

	public Cells() {
		ran = new Random();
		setLocation();
	}

	public void setSpeed(Difficulty d) {
		if (d.equals(Difficulty.EASY)) {
			xSpeed = ran.nextInt(7) - 3;
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
		if (place.getLocation().y > 1000-(getSize())) {
			place.setLocation(place.getLocation().x, 0);
		}
		if (place.getLocation().x > 2100-(getSize())) {
			place.setLocation(0, place.getLocation().y);
		}
		if (place.getLocation().x < 0) {
			place.setLocation(2100-(getSize()), place.getLocation().y);
		}
		if (place.getLocation().y < 0) {
			place.setLocation(place.getLocation().y, 1000-(getSize()));
		}
		place.translate(xSpeed, ySpeed);
	}

	public void setLocation(Point point) {
		
		
	}
}
