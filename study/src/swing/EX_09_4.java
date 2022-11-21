package swing;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

// page 518
// Container Pan에 BorderLayout 배치관리자 설정
public class EX_09_4 extends JFrame {
	public EX_09_4() {
		setTitle("BorderLayout Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();

		// 컨텐트팬에 BorderLayout 배치관리자 설정
		c.setLayout(new BorderLayout(50, 25));
		c.add(new JButton("Calcutate"), BorderLayout.CENTER);
		c.add(new JButton("add"), BorderLayout.NORTH);
		c.add(new JButton("sub"), BorderLayout.SOUTH);
		c.add(new JButton("mul"), BorderLayout.EAST);
		c.add(new JButton("div"), BorderLayout.WEST);

		setSize(300, 200); // 프레임 크기 설정
		setVisible(true); // 프레임을 화면에 출력
	}

	public static void main(String[] args) {
		new EX_09_4();
	}
}
