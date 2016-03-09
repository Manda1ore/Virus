package game;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JPanel {
	private static final long serialVersionUID = 1L;
	private Difficulty dif;
	public Menu(){
		repaint();
		dif = Difficulty.DEFAULT;
		Button easy = new Button("Easy");
		easy.setBounds(900, 350, 100, 40);// x axis, y axis, width, height
		easy.setActionCommand("Easy");
		easy.setForeground(Color.white);
		easy.setBackground(new Color(204,38,19));
		easy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dif = Difficulty.EASY;
			}
		});
		this.add(easy);
		Button medium = new Button("Medium");
		medium.setBackground(new Color(127,14,0));
		medium.setBounds(900, 390, 100, 40);// x axis, y axis, width, height
		medium.setActionCommand("Medium");
		medium.setForeground(Color.white);
		medium.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dif = Difficulty.MEDIUM;
			}
		});
		this.add(medium);
		Button hard = new Button("Hard");
		hard.setBackground(new Color(76,8,0));
		hard.setForeground(Color.white);
		hard.setBounds(900, 430, 100, 40);// x axis, y axis, width, height
		hard.setActionCommand("Hard");
		hard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dif = Difficulty.HARD;
			}
		});
		this.add(hard);
		this.setSize(2100, 1020);// 2100 width and 1020 height
		this.setLayout(null);
		this.setVisible(true);
	}
	public void paint(Graphics g) {
		g.setColor(new Color(166, 61, 51));
		g.fillRect(0, 0, 2100, 1000);

	}	
	public Difficulty start(){
		return dif;
	}
}
