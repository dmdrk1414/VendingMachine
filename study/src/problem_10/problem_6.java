package problem_10;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

// 명품자바 10장 실습문제 6번
public class problem_6 extends JFrame {

	JLabel label = new JLabel("C");

	public problem_6() {
		setTitle("실습문제 6번");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		c.add(label);
		c.addMouseListener(new MyMousListner());

		setSize(300, 200);
		setVisible(true);
		label.setFocusable(true);
		label.requestFocus();

		c.setFocusable(true);
		c.requestFocus();
	}

	class MyMousListner extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			Container c = (Container) e.getSource();
			int xSize = c.getSize().width;
			int YSize = c.getSize().height;
			int x = (int) (Math.random() * xSize);
			int y = (int) (Math.random() * YSize);
			label.setLocation(x, y);
		}
	}

	public static void main(String[] args) {
		new problem_6();
	}
}
