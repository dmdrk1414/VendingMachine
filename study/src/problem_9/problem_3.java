package problem_9;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// 명품자바 9장 실습문제 3번
public class problem_3 extends JFrame {
	public problem_3() {
		setTitle("Ten Color Buttons Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout grid = new GridLayout(1, 10);

		Container c = getContentPane();
		c.setLayout(grid);
		for (int i = 0; i < grid.getColumns(); i++) {
			c.add(new JButton(i + ""));
		}

		setSize(600, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new problem_3();
	}
}
