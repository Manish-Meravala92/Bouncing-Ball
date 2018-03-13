package gamefiles;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StartGame extends BouncingPanel {

	private static final long serialVersionUID = 1L;

	public StartGame() {
		KeyListener listener = new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				try {
					if (GameConstants.RIGHT_DIR.equalsIgnoreCase(KeyEvent.getKeyText(e.getKeyCode()))) {
						xCordRect += GameConstants.MOVEMENT_LENGTH;
						repaint();
						if (xCordRect > 475) {
							xCordRect = 475;
						}
					} else if (GameConstants.LEFT_DIR.equalsIgnoreCase(KeyEvent.getKeyText(e.getKeyCode()))) {
						xCordRect -= GameConstants.MOVEMENT_LENGTH;
						repaint();
						if (xCordRect < 1) {
							xCordRect = 10;
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

			public void keyReleased(KeyEvent e) {
			}
		};
		addKeyListener(listener);
		setFocusable(true);
	}

	public static void main(String[] args) {
		try {
			new StartGame().createWindow();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
