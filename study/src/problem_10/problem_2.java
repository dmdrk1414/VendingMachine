package problem_10;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

// 명품자바 10장 실습문제 2번
public class problem_2 extends JFrame {
	public problem_2() {
		setTitle("실습문제 2번");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.addMouseListener(new MyMouseListener());
		c.addMouseMotionListener(new MyMouseListener());
		c.setBackground(Color.GREEN);

		setSize(300, 300);
		setVisible(true);
	}

	class MyMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			Container c = (Container) e.getSource();
			c.setBackground(Color.YELLOW);
			System.out.println("mouseClicked");
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			Container c = (Container) e.getSource();
			c.setBackground(Color.BLACK);
			System.out.println("mouseReleased");
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			Component c = (Component) e.getSource();
			c.setBackground(Color.BLUE);
		}

	}

	public static void main(String[] args) {
		new problem_2();
	}
}
