import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class p5 extends JFrame {
	public p5() {
		setTitle("P5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new BorderLayout(5, 5));

		c.add(new JTextField(25), BorderLayout.NORTH);
		c.add(new SouthPanel(), BorderLayout.SOUTH);
		c.add(new JButton("Clear"), BorderLayout.WEST);
		c.add(new CenterPanel(), BorderLayout.CENTER);

		setSize(300, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new p5();
	}

	class CenterPanel extends JPanel {
		public CenterPanel() {
			setBackground(Color.WHITE);
			setLayout(null);
			for (int i = 0; i < 10; i++) {
				JLabel label = new JLabel("*");
				label.setSize(20, 20);
				int x = (int) (Math.random() * 200 + 10);
				int y = (int) (Math.random() * 200 + 10);
				label.setLocation(x, y);
				label.setForeground(Color.RED);
				add(label);
			}
		}
	}

	class SouthPanel extends JPanel {
		public SouthPanel() {
			GridLayout grid = new GridLayout(5, 3, 1, 1);
			setLayout(grid);
			for (int i = 1; i <= 9; i++) {
				add(new JButton(i + ""));
			}
			add(new JButton("*"));
			add(new JButton("0"));
			add(new JButton("#"));
			add(new JButton("Send"));
			add(new JButton(""));
			add(new JButton("End"));
		}
	}

}
