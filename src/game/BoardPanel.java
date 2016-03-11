package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BoardPanel extends JPanel implements MouseMotionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int GAME_PANEL_WIDTH = 2100;
	public static final int GAME_PANEL_HEIGHT = 1000;
	public static final int INSIDE_PANEL_WIDTH = 1900;
	private ArrayList<Cells> reds = new ArrayList<Cells>();
	private ArrayList<Cells> virus = new ArrayList<Cells>();
	private Cells whiteCell;
	private int nViruses = 10;
	private int nBloodCells = 10;
	private Difficulty d;
	private long begin;
	private Score score;

	public BoardPanel(Difficulty d, Score s) {
		score = s;
		begin = System.currentTimeMillis();
		setLayout(null);
		objectInfo(d);
		this.setBounds(0, 0, GAME_PANEL_WIDTH, GAME_PANEL_HEIGHT);
		this.addMouseMotionListener(this);
		this.d = d;
	}

	public void objectInfo(Difficulty d) {
		for (int i = 0; i < nViruses; i++) {
			virus.add(new Virus(INSIDE_PANEL_WIDTH,GAME_PANEL_HEIGHT));
			cellSettings(d, virus.get(i));
		}
		for (int i = 0; i < nBloodCells; i++) {
			reds.add(new RedCells(INSIDE_PANEL_WIDTH,GAME_PANEL_HEIGHT));
			cellSettings(d, reds.get(i));
		}
		whiteCell = new WhiteCell(INSIDE_PANEL_WIDTH,GAME_PANEL_HEIGHT);
		whiteCell.setSize(d);

	}

	public void cellSettings(Difficulty d, Cells cell) {
		cell.setSize(d);
		cell.setSpeed(d);
	}

	public void animation() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		while(whiteCell.getSize() > 0 || d.equals(Difficulty.HARD)&& reds.size() > 19) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int j = 0; j < virus.size(); j++) {
				levelFactor(j);
			}
			for (int l = 0; l < reds.size(); l++) {
				collisionCheck(l);
				reds.get(l).move();
			}
			for (int j = 0; j < virus.size(); j++) {
				virus.get(j).move();
			}
			repaint();
		}
	}

	public void collisionCheck(int l) {
		for (int j = 1; j < reds.size(); j++) {
			// red collide with red
			collisions(reds.get(l), reds.get(j));
			for (int i = 0; i < virus.size(); i++) {
				for (int c = 0; c < virus.size(); c++) {
					// virus collisions with virus
					collisions(virus.get(c), virus.get(i));
				}
				// red collide with virus
				collisions(reds.get(l), virus.get(i));
				// virus collide with red
				collisions(virus.get(i), reds.get(l));
				// red collide with player
				collisions(reds.get(l), whiteCell);

			}
		}
	}

	public void levelFactor(int i) {
		if (virus.get(i).intersects(whiteCell.getLocation().x,
				whiteCell.getLocation().y, virus.get(i).getSize(),
				virus.get(i).getSize())) {
			virus.remove(i);
			score.increaseScore(d);
			System.out.println(score.playerScore());
			if (virus.size() == 0) {
				score.levelincrease();
				if (nViruses < 16) {
					virus.removeAll(virus);
					nViruses += 2;
					objectInfo(d);
				} else if (nBloodCells < 19) {
					reds.removeAll(reds);
					nBloodCells += 3;
					objectInfo(d);
				} else if (nViruses >= 16 && nBloodCells >= 19) {
					difficultyIncrease();
				}
			}
		}
	}

	public void difficultyIncrease() {
		reds.removeAll(reds);
		nViruses = 10;
		nBloodCells = 10;
		if (d.equals(Difficulty.EASY)) {
			d = Difficulty.MEDIUM;
		} else if (d.equals(Difficulty.MEDIUM)) {
			d = Difficulty.HARD;
		} else if (d.equals(Difficulty.HARD)) {
			System.currentTimeMillis();
			long end = System.currentTimeMillis();
			System.out.println("You win!");
			System.out.println(Math.round(((end - begin) * .001) / 60)
					+ " minutes to win");
		}
		objectInfo(d);
	}

	public void collisions(Cells cell, Cells cell2) {
		if (cell.intersects(cell2.getLocation().x, cell2.getLocation().y,
				cell2.getSize(), cell2.getSize())) {
			cell.react(cell2);
			cell2.react(cell);
			
		}
	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, 2100, 1000);
		g.setColor(new Color(166, 61, 51));
		g.fillRect(0, 0, 2100, 1000);
		for (int i = 0; i < virus.size(); i++) {
			Image img = null;
			img = new ImageIcon(this.getClass()
					.getResource("/Images/virus.png")).getImage();
			g.drawImage(img, virus.get(i).getLocation().x, virus.get(i)
					.getLocation().y, null);
		}
		for (int i = 0; i < reds.size(); i++) {
			drawCells(g, reds.get(i));
		}
		drawCells(g, whiteCell);

	}

	public void drawCells(Graphics g, Cells cell) {
		g.setColor(Color.black);
		g.drawOval(cell.getLocation().x, cell.getLocation().y, cell.getSize(),
				cell.getSize());
		g.setColor(cell.getColor());
		g.fillOval(cell.getLocation().x, cell.getLocation().y, cell.getSize(),
				cell.getSize());
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		whiteCell.setLocation(new Point(
				arg0.getX() - (whiteCell.getSize() / 2), arg0.getY()
						- (whiteCell.getSize() / 2)));

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		whiteCell.setLocation(new Point(e.getX() - (whiteCell.getSize() / 2), e
				.getY() - (whiteCell.getSize() / 2)));
	}

}
