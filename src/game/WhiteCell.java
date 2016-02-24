package game;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class WhiteCell extends Cells{

	@Override
	public void setSize(Difficulty d) {
		if (d.equals(Difficulty.EASY)) {
			size = 15;
		} else if (d.equals(Difficulty.MEDIUM)) {
			size = 20;
		} else if (d.equals(Difficulty.HARD)) {
			size = 25;
		} else {
			size = 15;
		}
		
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public Color getColor() {
		return Color.white;
	}
	
	@Override
	public void setSpeed(Difficulty d) {
		
	}
	@Override
	public void setLocation(Point p) {
		place = new Point(p);
	}
	
	public void setLocation() {
		place = new Point(400, 500);
	}

	@Override
	public void setHit(double centerY, double centerX, int radius) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean react() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Point2D p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Rectangle2D r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(double x, double y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle2D getBounds2D() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PathIterator getPathIterator(AffineTransform at) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PathIterator getPathIterator(AffineTransform at, double flatness) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean intersects(Rectangle2D r) {
		// TODO Auto-generated method stub
		return false;
	}

	

	 
	
	
}
