package ex_10_practice;

import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

// 명품자바 10장 예제 8
public class EX_10_8 extends JFrame {
	JLabel label = new JLabel("HELLO");

	public EX_10_8() {
		setTitle("상, 하, 좌, 우");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(null);

		label.setLocation(50, 50);
		label.setSize(50, 50);
		c.add(label);
		c.addKeyListener(new KeyListner());

		setSize(300, 300);
		setVisible(true);

		c.setFocusable(true);
		c.requestFocus();
	}

	class KeyListner extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
//			int x = label.getLocation().x;
//			int y = label.getLocation().y;

			int x = label.getX();
			int y = label.getY();
//			if (keyCode == KeyEvent.VK_UP) {
//				label.setLocation(x, y - 10);
//			}
//			if (keyCode == KeyEvent.VK_DOWN) {
//				label.setLocation(x, y + 10);
//			}
//			if (keyCode == KeyEvent.VK_LEFT) {
//				label.setLocation(x - 10, y);
//			}
//			if (keyCode == KeyEvent.VK_RIGHT) {
//				label.setLocation(x + 10, y);
//			}

			switch (keyCode) {
			case KeyEvent.VK_UP: {
				label.setLocation(x, y - 10);
				break;
			}
			case KeyEvent.VK_DOWN: {
				label.setLocation(x, y + 10);
				break;
			}
			case KeyEvent.VK_LEFT: {
				label.setLocation(x - 10, y);
				break;
			}
			case KeyEvent.VK_RIGHT: {
				label.setLocation(x + 10, y);
				break;
			}
			}
		}
	}

	public static void main(String[] args) {
		new EX_10_8();
	}
}
