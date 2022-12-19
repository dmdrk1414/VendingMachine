package problem_9;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

// 명품자바 9장 실습문제 5번
public class problem_5 extends JFrame {
	public problem_5() {
		setTitle("4X4 Color Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout grid = new GridLayout(4, 4);

		Container c = getContentPane();
		c.setLayout(grid);

		int endPos = grid.getRows() * grid.getColumns();
		for (int i = 0; i < endPos; i++) {
			int ran = (int) (Math.random() * 100000) % 250;
			JButton button = new JButton(i + "");
			button.setBackground(new Color(100, ran, 150));
			button.setHorizontalAlignment(SwingConstants.LEFT);
			button.setOpaque(true);
			c.add(button);
		}

		setSize(400, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new problem_5();
	}
}
