package game;

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
	private Cells[] redCells = new RedCells[20];
	private Cells[] viruses = new Virus[10];
	private ArrayList<Cells> reds = new ArrayList<Cells>();
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
			virus.get(i).setSize(d);
			virus.get(i).setSpeed(d);
		}
		for (int i = 0; i < redCells.length; i++) {
			reds.add(new RedCells());
			reds.get(i).setSize(d);
			reds.get(i).setSpeed(d);
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
			for (int l = 0; l < redCells.length; l++) {
				for (int j = 0; j < redCells.length; j++) {
					// red collide with red
					reds.get(j).setHit(reds.get(l).getCenterX(),
							reds.get(l).getCenterY(), reds.get(l).getRadius());
					for (int i = 0; i < viruses.length; i++) {
						for (int c = 0; c < viruses.length; c++) {
							// virus collisions with virus
							virus.get(c).intersects(
									virus.get(c).getLocation().x,
									virus.get(c).getLocation().y,
									virus.get(c).getSize(),
									virus.get(c).getSize());
							// virus collide with player
							virus.get(c).intersects(
									whiteCell.getLocation().x,
									whiteCell.getLocation().y,
									whiteCell.getSize(),
									whiteCell.getSize());

						}
						// red collide with virus
						reds.get(j).intersects(
								virus.get(i).getLocation().x,
								virus.get(i).getLocation().y,
								virus.get(i).getSize(),
								virus.get(i).getSize());
						// virus collide with red
						virus.get(i).setHit(reds.get(j).getCenterX(),
								reds.get(j).getCenterY(), 60);
						// virus collide with player
						virus.get(i).intersects(
								whiteCell.getLocation().x,
								whiteCell.getLocation().y,
								whiteCell.getSize(),
								whiteCell.getSize());

						// red collide with player
						reds.get(j).intersects(
								whiteCell.getLocation().x,
								whiteCell.getLocation().y,
								whiteCell.getSize(),
								whiteCell.getSize());
					}
				}
				reds.get(l).move();
			}
			for (int j = 0; j < viruses.length; j++) {
				virus.get(j).move();
			}
			repaint();
		}
	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, 2100, 1000);
		g.setColor(new Color(158, 17, 74));
		g.fillRect(0, 0, 2100, 1000);
		for (int i = 0; i < viruses.length; i++) {
			g.setColor(virus.get(i).getColor());
			g.fillRect(virus.get(i).getLocation().x,
					virus.get(i).getLocation().y, virus.get(i).getSize(), virus
							.get(i).getSize());
		}
		for (int i = 0; i < redCells.length; i++) {
			g.setColor(Color.black);
			g.drawOval(reds.get(i).getLocation().x,
					reds.get(i).getLocation().y, reds.get(i).getSize(), reds
							.get(i).getSize());
			g.setColor(reds.get(i).getColor());
			g.fillOval(reds.get(i).getLocation().x,
					reds.get(i).getLocation().y, reds.get(i).getSize(), reds
							.get(i).getSize());
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
		whiteCell.setCenter();
	}

}
