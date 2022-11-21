package swing;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// page 524
// 배치관리자 없는 컨테이너에 컴포넌트를 절대 위치와 절대 크기로 지정
public class EX_09_6 extends JFrame {
	public EX_09_6() {
		setTitle("Null Container Sample"); // 프레임의 타이틀 달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 윈도우를 닫으면 프로그램 종료

		Container c = getContentPane();
		c.setLayout(null); // 컨텐트팬의 배치관리자 제거

		// JLabe1 컴포넌트 생성하고 위치와 크기를 직접 지정한다.
		JLabel la = new JLabel("Hello, Press Buttons!");
		la.setLocation(130, 50); // la를 (130,50) 위치로 지정
		la.setSize(200, 20); // la를 200X20크기로 지정
		c.add(la); // la를 컨텐트팬에 부착

		// 9개의 버튼 컴포넌트를 생성하고 모두 동일한 크기로 설정한다.
		// 위치는 서로 다르게 설정
		for (int i = 1; i <= 9; i++) {
			JButton b = new JButton(Integer.toString(i));
			b.setLocation(i * 15, i * 15); // 버튼의 위치 설정
			b.setSize(50, 20); // 9 개의 버튼 크기는 동일하게 50X20
			c.add(b);
		}

		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new EX_09_6();
	}
}
