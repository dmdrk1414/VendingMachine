package problem_9;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// 명품자바 9장 실습문제 4번
public class problem_4 extends JFrame {
	public problem_4() {
		setTitle("Ten Color Buttons Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout grid = new GridLayout(1, 10);

		Container c = getContentPane();
		c.setLayout(grid);
		for (int i = 0; i < grid.getColumns(); i++) {
			int ran = (int) (Math.random() * 100000) % 250;
			JButton button = new JButton(i + "");
			button.setBackground(new Color(255, 100, ran));
			c.add(button);
		}

		setSize(600, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new problem_4();
	}
}
