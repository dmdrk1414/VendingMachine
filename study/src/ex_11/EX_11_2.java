package ex_11;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class EX_11_2 extends JFrame {
	public EX_11_2() {
		setTitle("연습 2번");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JLabel label_text = new JLabel("사랑합니다.");

		ImageIcon loveImg = new ImageIcon("images/beauty.jpg");
		JLabel label_image = new JLabel(loveImg);

		ImageIcon callImg = new ImageIcon("images\\image3.jpg");
		JLabel label_text_img = new JLabel("보고싶으면 전화하세요", callImg, SwingConstants.LEFT);

		c.add(label_text);
		c.add(label_image);
		c.add(label_text_img);

		setSize(400, 600);
		setVisible(true);
	}

	public static void main(String[] args) {
		new EX_11_2();
	}
}
