package game;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JFrame;

public class Menu extends JFrame {
	private Difficulty dif;
	public Menu(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Button easy = new Button("Easy");
		easy.setBounds(900, 350, 100, 40);// x axis, y axis, width, height
		easy.setActionCommand("Easy");
		easy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button clicked, anonymous inner class: " + LocalDateTime.now());
				dif = Difficulty.EASY;
			}
		});
		this.add(easy);
		Button medium = new Button("Medium");
		medium.setBounds(900, 390, 100, 40);// x axis, y axis, width, height
		medium.setActionCommand("Medium");
		medium.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button clicked, anonymous inner class: " + LocalDateTime.now());
				dif = Difficulty.MEDIUM;
			}
		});
		this.add(medium);
		Button hard = new Button("Hard");
		hard.setBounds(900, 430, 100, 40);// x axis, y axis, width, height
		hard.setActionCommand("Hard");
		hard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button clicked, anonymous inner class: " + LocalDateTime.now());
				dif = Difficulty.HARD;
			}
		});
		this.add(hard);
		this.setSize(2100, 1020);// 2100 width and 1020 height
		this.setLayout(null);
		this.setVisible(true);
	}
		
	public Difficulty start(){
		return dif;
	}
}
