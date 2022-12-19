package problem_10;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

// 명품자바 10장 실습문제 5번
public class problem_5 extends JFrame {
	String LOVE_JAVA = "Love Java";

	JLabel label = new JLabel(LOVE_JAVA);

	public problem_5() {
		setTitle("실습문제 5번");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		c.add(label);
		c.addKeyListener(new MyKeyListener());

		setSize(300, 200);
		setVisible(true);
		label.setFocusable(true);
		label.requestFocus();

		c.setFocusable(true);
		c.requestFocus();
	}

	class MyKeyListener extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			int keyChar = e.getKeyChar();
			Font f = label.getFont();
			int size = f.getSize();
			if (keyChar == '+') {
				label.setFont(new Font("Arial", Font.PLAIN, size + 5));
			}
			if (keyChar == '-') {
				label.setFont(new Font("Arial", Font.PLAIN, size - 5));
			}
		}
	}

	public static void main(String[] args) {
		new problem_5();
	}
}
