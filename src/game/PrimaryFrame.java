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
	private Random ran = new Random();
	public PrimaryFrame(Difficulty d) {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		BoardPanel p = new BoardPanel(d);
		this.add(p);
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
			    cursorImg, new Point(0, 0), "blank cursor");
		this.setCursor(blankCursor);
		this.setSize(2100, 1020);// 2100 width and 1020 height
		this.setLayout(null);
		this.setVisible(true);// making the frame visible
		p.animation();
		
	}

}
