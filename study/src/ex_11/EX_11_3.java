package ex_11;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

public class EX_11_3 extends JFrame {
	public EX_11_3() {
		setTitle("연습 3번");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		String src = "images\\";
		ImageIcon normalIcon = new ImageIcon(src + "banana.jpg");
		ImageIcon rolloverIcon = new ImageIcon(src + "beauty.jpg");
		ImageIcon pressedIcon = new ImageIcon(src + "pear.jpg");

		JButton b = new JButton("call~", normalIcon);
		b.setRolloverIcon(rolloverIcon);
		b.setPressedIcon(pressedIcon);
//		b.setRolloverEnabled(false);
		b.setHorizontalAlignment(SwingConstants.LEFT);
		b.setVerticalAlignment(SwingConstants.TOP);

		c.add(b);

		setSize(400, 600);
		setVisible(true);
	}

	public static void main(String[] args) {
		new EX_11_3();
	}
}
