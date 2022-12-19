package problem_10;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

// 명품자바 10장 실습문제 6번
public class problem_7 extends JFrame {
	String LOVE_JAVA = "Love Java";
	JLabel label = new JLabel(LOVE_JAVA);

	public problem_7() {
		setTitle("실습문제 7번");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		c.add(label);
		c.addMouseWheelListener(new MyMousListner());

		setSize(300, 200);
		setVisible(true);
		label.setFocusable(true);
		label.requestFocus();

		c.setFocusable(true);
		c.requestFocus();
	}

	class MyMousListner extends MouseAdapter {

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			Font f = label.getFont();
			int size = f.getSize();
//			int n = e.getWheelRotation();
			double n = e.getPreciseWheelRotation();
			if (n > 0) {
				label.setFont(new Font("Arial", Font.PLAIN, size + 5));
			}
			if (n < 0) {
				label.setFont(new Font("Arial", Font.PLAIN, size - 5));
			}
		}

	}

	public static void main(String[] args) {
		new problem_7();
	}
}
