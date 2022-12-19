package ex_10_practice;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

// 명품자바 10장 예제 9
public class EX_10_9 extends JFrame {
	JLabel label = new JLabel("No Mouse Event");

	public EX_10_9() {
		setTitle("마우스 이벤트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		label.setForeground(Color.RED);
		label.setFont(new Font("", Font.BOLD, 30));
		c.add(label);
		c.addMouseListener(new MyMouseListner());
		c.addMouseMotionListener(new MyMouseListner());

		setSize(1000, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new EX_10_9();
	}

	class MyMouseListner implements MouseListener, MouseMotionListener {
		@Override
		public void mouseDragged(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			label.setText("mouseDragged(" + x + "," + y + ")");
			Container c = (Container) e.getSource();
			c.setBackground(Color.YELLOW);
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			label.setText("mouseMoved(" + x + "," + y + ")");
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			if (e.getButton() == MouseEvent.BUTTON1) {
				label.setText("mouseClicked mouse Button_1(" + x + "," + y + ")");
			}
			if (e.getButton() == MouseEvent.BUTTON2) {
				label.setText("mouseClicked mouse Button_2(" + x + "," + y + ")");
			}
			if (e.getButton() == MouseEvent.BUTTON3) {
				label.setText("mouseClicked mouse Button_3(" + x + "," + y + ")");
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			if (e.getButton() == MouseEvent.BUTTON1) {
				label.setText("mousePressed mouse Button_1(" + x + "," + y + ")");
			}
			if (e.getButton() == MouseEvent.BUTTON2) {
				label.setText("mousePressed mouse Button_2(" + x + "," + y + ")");
			}
			if (e.getButton() == MouseEvent.BUTTON3) {
				label.setText("mousePressed mouse Button_3(" + x + "," + y + ")");
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			label.setText("MouseReleased(" + x + "," + y + ")");
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			Container c = (Container) e.getSource();
			c.setBackground(Color.GRAY);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			Container c = (Container) e.getSource();
			c.setBackground(Color.BLACK);
		}
	}
}
