package game;

public class Score {
	private int score;
	private int level;
	public Score(){
		level = 1;
		score = 0;
	}
	public int increaseScore(Difficulty d){
		if(d.equals(Difficulty.EASY)){
			score += 10;
		}else if (d.equals(Difficulty.MEDIUM)){
			score += 20;
		}else if (d.equals(Difficulty.HARD)){
			score += 30;
		}
		return score;
	}
	public int levelincrease(){
		return level++;
	}
	public String playerScore(){
		return "You got to Level: " + level + " with a score of: " + score;
	}
}
