package game;

import java.awt.Point;

public interface Hitter {

	void setHit(double centerY, double centerX, int radius);
	boolean react();
	
}
