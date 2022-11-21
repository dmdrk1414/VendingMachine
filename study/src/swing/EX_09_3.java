package swing;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// page 515
// Container Pan에 FlowLayout 배치관리자 설정
public class EX_09_3 extends JFrame {
	public EX_09_3() {
		setTitle("FlowLayout Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();

		// 컨텐트팬에 FlowLayout 배치관리자 설정
		c.setLayout(new FlowLayout(FlowLayout.LEFT, 70, 70));
		c.add(new JButton("add"));
		c.add(new JButton("sub"));
		c.add(new JButton("mul"));
		c.add(new JButton("div"));
		c.add(new JButton("Calculate"));

		setSize(600, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new EX_09_3();
	}
}
