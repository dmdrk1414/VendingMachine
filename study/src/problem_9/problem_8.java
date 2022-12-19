package problem_9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// 명품자바 9장 실습문제 8번
public class problem_8 extends JFrame {
	public problem_8() {
		setTitle("계산기 프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		c.add(new NorthPane_1(), BorderLayout.NORTH);
		c.add(new CenterPane_1(), BorderLayout.CENTER);
		c.add(new SouthPane_1(), BorderLayout.SOUTH);

		setSize(400, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new problem_8();
	}
}

class NorthPane_1 extends JPanel {
	public NorthPane_1() {
		setBackground(Color.cyan);
		add(new JButton("열기"));
		add(new JButton("닫기"));
		add(new JButton("나가기"));
	}
}

class CenterPane_1 extends JPanel {
	public CenterPane_1() {
		setBackground(Color.white);
		setLayout(null);
		for (int i = 0; i < 10; i++) {
			int x = (int) (Math.random() * 350);
			int y = (int) (Math.random() * 150) + 100;
			JLabel label = new JLabel("*");
			label.setLocation(x, y);
			label.setSize(10, 10);
			label.setFont(new Font("Serif", Font.PLAIN, 20));
			label.setForeground(Color.RED);
			add(label);
		}
	}
}

class SouthPane_1 extends JPanel {
	public SouthPane_1() {
		setBackground(Color.yellow);
		add(new JLabel("Word input"));
		add(new JTextField(20));
	}
}