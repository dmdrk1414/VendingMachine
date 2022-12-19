package ex_10_practice;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

// 명품자바 10장 예제 4
public class EX_10_4 extends JFrame {
	JLabel label = new JLabel("Hello");

	public EX_10_4() {
		setTitle("Mouse 이벤트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(null);

		label.setSize(30, 30);
		c.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();

				label.setLocation(x, y);
			}

			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		c.add(label);

		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new EX_10_4();
	}
}
