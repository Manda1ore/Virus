package game;

import java.awt.Color;
import java.awt.Point;

public class RedCells extends Cells {

	@Override
	public void setSize(Difficulty d) {
		if (d.equals(Difficulty.EASY)) {
			size = 10;
		} else if (d.equals(Difficulty.MEDIUM)) {
			size = 20;
		} else if (d.equals(Difficulty.HARD)) {
			size = 40;
		} else {
			size = 10;
		}
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public Color getColor() {
		return Color.red;
	}

	@Override
	public void hit(Point p, int size) {
		// TODO Auto-generated method stub
		
	}


}
