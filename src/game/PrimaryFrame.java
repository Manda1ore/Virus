package game;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.util.Random;

import javax.swing.JFrame;

public class PrimaryFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static final int PRIMARY_FRAME_WIDTH = 2100;
	private static final int PRIMARY_FRAME_HEIGHT = 1020;
	@SuppressWarnings("deprecation")
	public PrimaryFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		BoardPanel p = null;
		System.out.println("start");
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
			    cursorImg, new Point(0, 0), "blank cursor");
		
		this.setSize(PRIMARY_FRAME_WIDTH, PRIMARY_FRAME_HEIGHT);// 2100 width and 1020 height
		this.setLayout(null);
		this.setVisible(true);// making the frame visible
		while(true){
			Menu m = new Menu(PRIMARY_FRAME_WIDTH, PRIMARY_FRAME_HEIGHT);
			this.add(m);
			
			while(m.start()==Difficulty.DEFAULT){
				System.out.println();
			}
			System.out.println("menu loop");
			Score s = new Score();
			p = new BoardPanel(m.start(),s);
			this.add(p);
			this.setCursor(blankCursor);
			this.remove(m);	
			p.animation();
			this.remove(p);
			this.setCursor(Cursor.DEFAULT_CURSOR);
			System.out.println(s.playerScore());
		}
		
		
		
		
	}

}
