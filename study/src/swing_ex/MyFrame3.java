package swing_ex;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

//FlowLayout 객체 생성하고 버튼 추가하기

public class MyFrame3 extends JFrame {
	public MyFrame3() {
		setSize(800, 500);
		setLocation(100, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// FlowLayout 객체 전달하기
		setLayout(new FlowLayout(FlowLayout.LEFT));

		// 버튼을 만들어서
		add(new JButton("버튼1"));
		add(new JButton("버튼2"));
		add(new JButton("버튼3"));

		setVisible(true);
	}

	public static void main(String[] args) {
		new MyFrame3();
	}
}
