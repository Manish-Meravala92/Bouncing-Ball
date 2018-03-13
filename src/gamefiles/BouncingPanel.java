package gamefiles;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BouncingPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	Graphics2D g2d;
	int yCordRect = 520;
	int xCordRect = 10;
	int width = 100;
	int height = 50;
	int intersectCount = 0, sleepTime = 50;
	int xCordOval = 1, yCordOval = 1, x2 = 1, y2 = 1, ovalWidth = 50, ovalHeight = 50;

	private void start(JFrame frame) {
		try {

			do {
				repaint();
				if (intersectCount == 5) {
					sleepTime = 30;
				}
				Thread.sleep(sleepTime);
				if (xCordOval == 10)
					x2 = 10;
				if (xCordOval == 550)
					x2 = -10;
				if (yCordOval == 10)
					y2 = 10;
				if (yCordOval == 550) {
					JOptionPane.showMessageDialog(frame, GameConstants.GAME_OVER);
					System.exit(0);
				}

				Rectangle rect = new Rectangle(xCordRect, yCordRect, width, height);
				Rectangle ball = new Rectangle(xCordOval, yCordOval, ovalWidth, ovalHeight);
				if (rect.intersects(ball)) {
					y2 = -10;
					intersectCount++;
				}

				// System.out.println("cir y : " + yCordOval + " cir x : " + xCordOval + "rect
				// x" + xCordRect);
				xCordOval = xCordOval + x2;
				yCordOval = yCordOval + y2;

			} while (true);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.RED);
		g2d.fillOval(xCordOval, yCordOval, ovalWidth, ovalHeight);
		g2d.setColor(Color.BLUE);
		g2d.fillRect(xCordRect, yCordRect, width, height);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("", 1, 30));
		g2d.drawString(GameConstants.SCORE + intersectCount, 250, 50);
	}

	public void createWindow() throws Exception {
		JFrame frame = new JFrame(GameConstants.GAME_NAME);
		frame.add(this);
		frame.setSize(600, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.start(frame);
	}
}
