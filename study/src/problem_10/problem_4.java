package problem_10;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

// 명품자바 10장 실습문제 4번
public class problem_4 extends JFrame {
	String LOVE_JAVA = "Love Java";

	JLabel label = new JLabel(LOVE_JAVA);

	public problem_4() {
		setTitle("실습문제 4번");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		c.add(label);
		c.addKeyListener(new MyKeyListener());

		setSize(300, 200);
		setVisible(true);
		label.setFocusable(true);
		label.requestFocus();

		c.setFocusable(true);
		c.requestFocus();
	}

	class MyKeyListener extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			if (keyCode == KeyEvent.VK_LEFT) {
				String text = label.getText();
				String subString_1 = text.substring(0, 1);
				String subString_2 = text.substring(1, text.length());
				String concatString = subString_2.concat(subString_1);

				System.out.println(subString_1);
				System.out.println(subString_2);
				System.out.println(concatString);
				label.setText(concatString);
			}
			if (keyCode == KeyEvent.VK_RIGHT) {
				String text = label.getText();
				String subString_1 = text.substring(text.length() - 1, text.length());
				String subString_2 = text.substring(0, text.length() - 1);
				String concatString = subString_1.concat(subString_2);

				System.out.println(subString_1);
				System.out.println(subString_2);
				System.out.println(concatString);
				label.setText(concatString);
			}
		}
	}

	public static void main(String[] args) {
		new problem_4();
	}
}
