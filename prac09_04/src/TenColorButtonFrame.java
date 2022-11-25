

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TenColorButtonFrame extends JFrame {
	// 생성자를 호출할 것. 교재 506 페이지 참조
	public TenColorButtonFrame() {
//		"Ten Color Buttons Frame＂으로 타이틀 달기 // 수퍼클래스인 JFrame
		setTitle("Ten Color Buttons Frame");
//		프레임 윈도우를 닫으면 프로그램 종료하도록 설정 // 예제 9-3
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		컨텐트 팬을 알아내서 변수 c에 저장(선언 및 초기화) // 예제 9-3
		Container c = getContentPane();
//		컨텐트 팬 c의 레이아웃 설정
//		(그리드 레이아웃 객체 생성, 행 1, 열 10) // 예제 9-3, 9-5
		c.setLayout(new GridLayout(1, 10));

		// 아래 객체 배열 생성은 예제 4-7 참조
//		JButton 배열 레퍼런스 변수 btn[] 선언 및 초기화(new로 레퍼런스 원소 10개를 할당)
		JButton[] btn = new JButton[10];

//		Color 배열 변수 color[]를 선언하고 버튼의 배경색으로 사용할
		Color[] color = new Color[] { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE,
				Color.MAGENTA, Color.GRAY, Color.PINK, Color.LIGHT_GRAY };

//		10가지 색으로 초기화 // 이 실습 노트의 1페이지 참조
//		배열 btn의 원소의 개수만큼 반복(인덱스 i 사용) { // 버튼 생성하여 컨텐츠 팬에 추가
		for (int i = 0; i < color.length; i++) {

//			버튼 생성하여 btn[i]에 저장 (버튼 생성시 버튼에 사용할 문자열은 정수 i를 문자열
//			로 변환하여 넘겨 줌, 교재 354 페이지 “기본 타입 값을 문자열로 변환” 참조)
			btn[i] = new JButton(String.valueOf(i));

//			btn[i]의 setOpaque(true) 멤버함수를 호출하여 버튼의 배경색이 보이게 함
			btn[i].setOpaque(true);

//			btn[i]의 백그라운드 색깔을 color[i]로 설정함 // 백그라운드 색 변경 예제 9-2 참조
			btn[i].setBackground(color[i]);

//			btn[i]를 컨텐트 팬 c에 추가함 // 예제 9-3 
			c.add(btn[i]);

		}
//		프레임의 크기를 500,200으로 설정 // 예제 9-3
		setSize(500, 200);

//		화면에 보이기 // 예제 9-3
		setVisible(true);
	}
}
