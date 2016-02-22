package Virus.game;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JFrame;

public class PrimaryFrame extends JFrame {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	public PrimaryFrame(Difficulty d) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		BoardPanel p = new BoardPanel(d);
		this.add(p);
		/*
		 * Show the compiled anonymous class
		 */
		this.setBackground(Color.blue);
		this.setSize(2100, 1020);// 400 width and 500 height
		this.setLayout(null);// using no layout managers (not recommended for
								// standard swing, but useful for our purposes
								// in CSC150
		this.setVisible(true);// making the frame visible
		p.animation();
		
	}

}
