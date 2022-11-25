package prac10_06;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClickApp_20161822 {

	public static void main(String[] args) {
		new ClickPracticeFrame();
	}

}

class ClickPracticeFrame extends JFrame {
	// ClickPracticeFrame의 생성자 함수
	// 예제 10-5 참조
	// “클릭 연습 용 응용프로그램“으로 타이틀 달기 // 수퍼클래스인 JFrame
	// 생성자를 호출할 것. 교재 506 페이지 참조
	public ClickPracticeFrame() {
		setTitle("클릭 연습 용 응용프로그램");

		// 프레임 윈도우를 닫으면 프로그램 종료하도록 설정 // 예제 10-5
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 컨텐트 팬을 알아내서 Container형 변수 c에 저장(선언 및 초기화) // 예제 10-5
		Container c = getContentPane();

		// 컨텐트 팬 c의 레이아웃 설정 (배치관리자 삭제) // 예제 10-5
		c.setLayout(null);

		//// 예제 10-5처럼 생성자 함수 바깥에 la를 선언하지 말고 여기에 바로 선언할 것
		// “C” 문자열을 가지는 JLabel 객체 생성하여 변수 la에 저장(선언 및 초기화)
		JLabel la = new JLabel("C");

		// 레이블 la의 위치 (100, 100)으로 설정 // 예제 10-5
		la.setLocation(100, 100);

		// 레이블 la의 크기 20 x 20으로 설정 // 예제 10-5
		la.setSize(20, 20);

		// 마우스 리스너인 MyMouseAdapter() 객체를 생성한 후 // 예제 10-5
		// la.addMouseListener()를 이용하여 리스너를 등록한다
		//// 예제 10-5처럼 컨테이너인 c가 아니라 la에 리스너를 단다.
		//// 그래야만 레이블 la의 글자 “C” 위에서 마우스를 누를 경우 리스너 함수가 호출됨
		la.addMouseListener(new MyMouseAdapter());

		// 레이블 컴포넌트 la를 컨텐트 팬(컨테이너) c에 추가함 // 예제 10-5
		add(la);

		// 프레임의 크기를 300,300으로 설정 // 예제 10-5
		setSize(300, 300);

		// 화면에 보이기 // 예제 10-5
		setVisible(true);
	}

	class MyMouseAdapter extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			JLabel la = (JLabel) e.getSource(); // 이벤트가 발생한 소스 컴포넌트 구함(레이블 la)
			Container c = la.getParent(); // 레이블의 부모 컴포넌트 구함 (컨텐트 팬 c)
			// 컨테이너의 크기 내에서 랜덤한 레이블 위치 설정
			int xBound = c.getWidth() - la.getWidth(); // 레이블의 폭 만큼 감소
			int yBound = c.getHeight() - la.getHeight(); // 레이블의 높이 만큼 감소
			int x = (int) (Math.random() * xBound); // 0 ~ (xBound-1) 임의의 수 생성
			int y = (int) (Math.random() * yBound); // 0 ~ (yBound-1) 임의의 수 생성
//			x, y 값을 이용하여 레이블 la의 위치를 변경
			// 앞 페이지의 ‘레이블 la의 위치 (100, 100)으로 설정’과 동일한 함수 사용
			la.setLocation(x, y);
		}

	}
}