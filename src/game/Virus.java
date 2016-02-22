package Virus.game;

import java.awt.Color;
import java.awt.Point;

public class Virus extends Cells{


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
	public void hit(Point p, int size) {
		// TODO Auto-generated method stub
		
	}


}
