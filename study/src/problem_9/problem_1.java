package problem_9;

import javax.swing.JFrame;

// 명품자바 9장 실습문제 1번
public class problem_1 extends JFrame {
	public problem_1() {
		setTitle("Let's study Java");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(400, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new problem_1();
	}
}
