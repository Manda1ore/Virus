package game;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BoardPanel extends JPanel implements MouseMotionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cells[] redCells = new RedCells[20];
	private ArrayList<Cells> reds = new ArrayList<Cells>();
	private ArrayList<Cells> virus = new ArrayList<Cells>();
	private Cells whiteCell;
	private int nViruses = 10;
	private int nBloodCells = 10;
	Difficulty d;
	public BoardPanel(Difficulty d) {
		setLayout(null);
		objectInfo(d);
		this.setBounds(0, 0, 1925, 900);
		this.addMouseMotionListener(this);
		this.d = Difficulty.EASY;
	}

	public void objectInfo(Difficulty d) {
		for (int i = 0; i < nViruses; i++) {
			virus.add(new Virus());
			cellSettings(d, virus.get(i));
		}
		for (int i = 0; i < nBloodCells; i++) {
			reds.add(new RedCells());
			cellSettings(d, reds.get(i));
		}
		whiteCell = new WhiteCell();
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
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (;;) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int l = 0; l < reds.size(); l++) {
				for (int j = 1; j < reds.size(); j++) {
					// red collide with red
					collisions(reds.get(l), reds.get(j));
					for (int i = 0; i < virus.size(); i++) {
						for (int c = 1; c < virus.size(); c++) {
							// virus collisions with virus
							collisions(virus.get(i), virus.get(c));
						}
						// red collide with virus
						collisions(reds.get(j), virus.get(i));
						// virus collide with red
						collisions(virus.get(i), reds.get(l));
						// virus collide with player
						collisions(virus.get(i), whiteCell);
						// red collide with player
						collisions(reds.get(l), whiteCell);
						levelFactor(i);
					}
				}
				reds.get(l).move();
			}
			for (int j = 0; j < virus.size(); j++) {
				virus.get(j).move();
			}
			repaint();
		}
	}

	public void levelFactor(int i) {
		if (virus.get(i).react()) {
			virus.remove(i);
			if (virus.size() == 0) {
				System.out.println("last virus caught");			
				if (nViruses < 16) {
					virus.removeAll(virus);
					nViruses += 2;
					objectInfo(d);					
				} else if (nBloodCells < 19) {
					reds.removeAll(reds);
					nBloodCells += 3;
					objectInfo(d);
				} else if (nViruses >= 16 && nBloodCells >= 19){
					difficultyIncrease();
				} 
			}
		}
	}

	public void difficultyIncrease() {
		reds.removeAll(reds);
		nViruses = 10;
		nBloodCells = 10;
		if(d.equals(Difficulty.EASY)){
			d = Difficulty.MEDIUM;
		}else if(d.equals(Difficulty.MEDIUM)){
			d = Difficulty.HARD;
		}else if(d.equals(Difficulty.HARD)){
		}
		objectInfo(d);
	}

	public void collisions(Cells cell, Cells cell2) {
		cell.intersects(cell2.getLocation().x, cell2.getLocation().y,
				cell2.getSize(), cell2.getSize());
	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, 2100, 1000);
		g.setColor(new Color(158, 17, 74));
		g.fillRect(0, 0, 2100, 1000);
		for (int i = 0; i < virus.size(); i++) {
			g.setColor(virus.get(i).getColor());
			g.fillRect(virus.get(i).getLocation().x,
					virus.get(i).getLocation().y, virus.get(i).getSize(), virus
							.get(i).getSize());
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
		whiteCell.setCenter();
	}

}
