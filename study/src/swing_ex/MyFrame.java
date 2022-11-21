package swing_ex;

import javax.swing.JFrame;

//- 프레임 생성하고 나타나도록 설정하기
//- 창 종료 시 프로세스 종료되도록 설정하기
public class MyFrame extends JFrame {
	public MyFrame() {
		setSize(800, 500);
		setLocation(100, 100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyFrame();
	}
}
