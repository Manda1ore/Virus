package Virus.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BoardPanel extends JPanel implements MouseMotionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cells[] redCells = new RedCells[30];
	private Cells[] viruses = new Virus[10];
	private ArrayList<Cells> virus = new ArrayList<Cells>();
	private Cells whiteCell;

	public BoardPanel(Difficulty d) {
		setLayout(null);
		objectInfo(d);
		this.setBounds(0, 0, 2100, 1000);
		this.addMouseMotionListener(this);
	}

	public void objectInfo(Difficulty d) {
		for (int i = 0; i < viruses.length; i++) {
			virus.add(new Virus());
			virus.indexOf(i);
			viruses[i] = new Virus();
			viruses[i].setSize(d);
			viruses[i].setSpeed(d);
		}
		for (int i = 0; i < redCells.length; i++) {
			redCells[i] = new RedCells();
			redCells[i].setSize(d);
			redCells[i].setSpeed(d);
		}
		whiteCell = new WhiteCell();
		whiteCell.setSize(d);

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
			for (int j = 0; j < redCells.length; j++) {
				redCells[j].move();
			}
			for (int i = 0; i < viruses.length; i++) {
				viruses[i].move();
			}
			repaint();

		}
	}
//
	public void paint(Graphics g) {
		// System.out.println("Painting BoardPanel...");
		
		g.clearRect(0, 0, 2100, 1000);
		g.setColor(new Color(158, 17, 74));
		g.fillRect(0, 0, 2100, 1000);
		for (int i = 0; i < viruses.length; i++) {
			
			g.setColor(viruses[i].getColor());
			g.fillRect(viruses[i].getLocation().x, viruses[i].getLocation().y,
					viruses[i].getSize(), viruses[i].getSize());
		}
		for (int i = 0; i < redCells.length; i++) {
			g.setColor(Color.black);
			g.drawOval(redCells[i].getLocation().x,
					redCells[i].getLocation().y, redCells[i].getSize(),
					redCells[i].getSize());
			g.setColor(redCells[i].getColor());
			g.fillOval(redCells[i].getLocation().x,
					redCells[i].getLocation().y, redCells[i].getSize(),
					redCells[i].getSize());

		}
		g.setColor(Color.black);
		g.drawOval(whiteCell.getLocation().x, whiteCell.getLocation().y,
				whiteCell.getSize(), whiteCell.getSize());
		g.setColor(whiteCell.getColor());
		g.fillOval(whiteCell.getLocation().x, whiteCell.getLocation().y,
				whiteCell.getSize(), whiteCell.getSize());

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
