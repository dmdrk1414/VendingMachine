package problem_9;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

// 명품자바 9장 실습문제 2번
public class problem_2 extends JFrame {
	public problem_2() {
		setTitle("BorderLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new BorderLayout(5, 7));

		c.add(new JButton("North"), BorderLayout.NORTH);
		c.add(new JButton("South"), BorderLayout.SOUTH);
		c.add(new JButton("West"), BorderLayout.WEST);
		c.add(new JButton("East"), BorderLayout.EAST);
		c.add(new JButton("Center"), BorderLayout.CENTER);

		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new problem_2();
	}
}
