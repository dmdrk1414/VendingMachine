package swing;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class test extends JFrame {

	public test() {
		setTitle("Null Container Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JLabel la = new JLabel("Hello, Press Buttons!");
		la.setLocation(180, 150);
		la.setSize(200, 20);

		c.add(la);

		for (int i = 1; i <= 9; i++) {
			JButton b = new JButton(Integer.toString(i));
			b.setLocation(i * 25, i * 25);
			b.setSize(50, 20);
			c.add(b);
		}

		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new test();
	}
}
