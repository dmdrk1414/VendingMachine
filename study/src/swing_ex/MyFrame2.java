package swing_ex;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

//버튼 만들고 버튼 추가하기 

public class MyFrame2 extends JFrame {
	public MyFrame2() {
		setSize(800, 500);
		setLocation(1700, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new FlowLayout(FlowLayout.LEFT));
		// 버튼을 만들어서
		add(new JButton("버튼1"));
		add(new JButton("버튼2"));
		add(new JButton("버튼3"));
		setVisible(true);
	}

	public static void main(String[] args) {
		new MyFrame2();
	}
}
