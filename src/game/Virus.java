package game;

import java.awt.Color;
import java.awt.Point;

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

	


}
