package swing;

import javax.swing.JFrame;

// page 504
public class EX_09_1 extends JFrame {
	public EX_09_1() {
//		super("타이틀문자열"); // super을 이용하여 타이틀 문자열을 변경하기
		setTitle("300X300 스윙 프레임 만들기");
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		EX_09_1 frame = new EX_09_1();
	}
}
