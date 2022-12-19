package problem_10;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

// 명품자바 10장 실습문제 1번
public class problem_1 extends JFrame {
	String LOVE_JAVA = "Love Java";
	String LOVE = "사랑해";
	JLabel label = new JLabel(LOVE_JAVA);

	public problem_1() {
		setTitle("실습문제 1번");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		label.addMouseListener(new MyMouseListener());

		c.add(label);

		setSize(400, 200);
		setVisible(true);
	}

	class MyMouseListener extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			JLabel label = (JLabel) e.getSource();
			if (label.getText().equals(LOVE_JAVA)) {
				label.setText(LOVE);
				System.out.println(label.getText());
			} else {
				label.setText(LOVE_JAVA);
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			JLabel label = (JLabel) e.getSource();
			label.setText(LOVE);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			JLabel label = (JLabel) e.getSource();
			label.setText(LOVE_JAVA);
		}

	}

	public static void main(String[] args) {
		new problem_1();
	}
}
