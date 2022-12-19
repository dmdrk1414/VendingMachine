package problem_9;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

// 명품자바 9장 실습문제 6번
public class problem_6 extends JFrame {
	public problem_6() {
		setTitle("Random Labels");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(null);

		for (int i = 0; i < 20; i++) {
			int x = (int) (Math.random() * 200) + 50;
			int y = (int) (Math.random() * 200) + 50;

			JLabel label = new JLabel(i + "");
			label.setSize(10, 10);
			label.setBackground(Color.blue);
			label.setLocation(x, y);
			label.setOpaque(true);
			c.add(label);
		}

		setSize(400, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new problem_6();
	}
}
