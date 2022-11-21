package swing_ex;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

//BorderLayout 프레임에 버튼 추가하기

public class MyFrame4 extends JFrame {
	public MyFrame4() {
		setSize(800, 500);
		setLocation(100, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// FlowLayout 객체 전달하기
		setLayout(new BorderLayout());

		// 버튼을 만들어서
		JButton btn1 = new JButton("버튼1");
		JButton btn2 = new JButton("버튼2");
		JButton btn3 = new JButton("버튼3");
		JButton btn4 = new JButton("버튼4");
		JButton btn5 = new JButton("버튼5");

		// 프레임에 추가하기
		add(btn1, BorderLayout.NORTH);
		add(btn2, BorderLayout.WEST);
		add(btn3, BorderLayout.EAST);
		add(btn4, BorderLayout.SOUTH);
		add(btn5, BorderLayout.CENTER);

		add(new JButton("버튼9"));

		setVisible(true);
	}

	public static void main(String[] args) {
		new MyFrame4();
	}
}
