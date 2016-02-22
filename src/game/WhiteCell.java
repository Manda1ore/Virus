package Virus.game;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	public void setLocation(Point p) {
		place = new Point(p);
	}
	@Override
	public void setLocation() {
		place = new Point(400, 500);
	}

	@Override
	public void hit(Point p, int size) {
		
		
	}
	
	
}
