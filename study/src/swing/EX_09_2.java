package swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// page 508
public class EX_09_2 extends JFrame {
	public EX_09_2() {
		setTitle("ContentPane과 JFrame"); // 프레임 타이틀 달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 윈도우를 닫으면 프로그램을 종료하도록 설정

		Container contentPane = getContentPane();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setLayout(new FlowLayout());

		// 컨텐트 팬에 컴포즈 달기
		contentPane.add(new JButton("OK")); // OK 버튼 달기
		contentPane.add(new JButton("Cancel")); // Cancel 버튼 달기
		contentPane.add(new JButton("Ignore")); // Ignore 버튼 달기

		setSize(300, 150); // 프레임 크기 300 X 150 설정
		setVisible(true); // 화면에 프레임 출력
	}

	public static void main(String[] args) {
		new EX_09_2();
	}
}
