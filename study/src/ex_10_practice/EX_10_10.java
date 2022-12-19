package ex_10_practice;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

// 명품자바 10장 예제 10
public class EX_10_10 extends JFrame {
	JLabel label = new JLabel("No Mouse Event");

	public EX_10_10() {
		setTitle("마우스 이벤트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		c.addMouseListener(new MyMouseListener());

		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new EX_10_10();
	}

	class MyMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			int rand = (int) (Math.random() * 10000) % 256;
			Container c = (Container) e.getSource();
			if (e.getClickCount() == 2) {
				c.setBackground(new Color(100, rand, rand));
			}
		}
	}
}
