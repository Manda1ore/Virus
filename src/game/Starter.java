package game;

public class Starter {
	private static Difficulty d;
	public static void main(String[] args) {

		for (String difficulty : args) {
			if(difficulty.equalsIgnoreCase(Difficulty.EASY.toString())){				
				d = Difficulty.EASY;
			}else if(difficulty.equalsIgnoreCase(Difficulty.MEDIUM.toString())){				
				d = Difficulty.MEDIUM;
			}else if(difficulty.equalsIgnoreCase(Difficulty.HARD.toString())){				
				d = Difficulty.HARD;
			}else {
				d = Difficulty.EASY;
			}
			PrimaryFrame f = new PrimaryFrame(d);
		}	
		
	}
}
