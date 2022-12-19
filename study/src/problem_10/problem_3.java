package problem_10;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

// 명품자바 10장 실습문제 3번
public class problem_3 extends JFrame {
	String LOVE_JAVA = "Love Java";
	StringBuilder sb = new StringBuilder(LOVE_JAVA);
	String REVERS_LOVE_JAVA = sb.reverse().toString();

	JLabel label = new JLabel(LOVE_JAVA);

	public problem_3() {
		setTitle("실습문제 3번");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		// 이게 왜안되는지 생각해도 될듯
		label.addKeyListener(new NewLabelKeyListener());

		c.add(label);
		c.addKeyListener(new MyKeyListener());

		setSize(300, 200);
		setVisible(true);
		label.setFocusable(true);
		label.requestFocus();

		c.setFocusable(true);
		c.requestFocus();
	}

	class NewLabelKeyListener extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			int x = label.getX();
			int y = label.getY();

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

	class MyKeyListener extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			if (keyCode == KeyEvent.VK_LEFT) {
				if (label.getText().equals(LOVE_JAVA)) {
					label.setText(REVERS_LOVE_JAVA);
				} else {
					label.setText(LOVE_JAVA);
				}
			}
			if (keyCode == KeyEvent.VK_RIGHT) {
				if (label.getText().equals(LOVE_JAVA)) {
					label.setText(REVERS_LOVE_JAVA);
				} else {
					label.setText(LOVE_JAVA);
				}
			}
		}
	}

	public static void main(String[] args) {
		new problem_3();
	}
}
