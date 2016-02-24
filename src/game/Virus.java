package game;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Virus extends Cells{
	
	public Virus(){
		
	}
	@Override
	public int getSize() {
		return size;
	}

	@Override
	public Color getColor() {
		return Color.green;
	}

	@Override
	public void setSize(Difficulty d) {
		if (d.equals(Difficulty.EASY)) {
			size = 20;
		} else if (d.equals(Difficulty.MEDIUM)) {
			size = 15;
		} else if (d.equals(Difficulty.HARD)) {
			size = 10;
		} else {
			size = 20;
		}		
	}

	@Override
	public void setHit(double centerY, double centerX, int radius) {
		
		int distance = (int) place.distance(centerX, centerY);
		if(distance <= this.radius + radius){
//			xSpeed = -xSpeed;
			didHit = true;			
		}else{
			didHit = false;
		}
	}
	@Override
	public boolean react() {
		// TODO Auto-generated method stub
		return didHit;
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
