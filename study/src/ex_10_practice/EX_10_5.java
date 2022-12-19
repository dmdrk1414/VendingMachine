package ex_10_practice;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

// 명품자바 10장 예제 5
public class EX_10_5 extends JFrame {
	JLabel label = new JLabel("Hello");

	public EX_10_5() {
		setTitle("Mouse 이벤트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(null);

		label.setSize(30, 30);
		c.addMouseListener(new MyMouseAdapter());
		c.add(label);

		setSize(300, 300);
		setVisible(true);
	}

	class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			label.setLocation(x, y);
		}
	}

	public static void main(String[] args) {
		new EX_10_5();
	}
}
