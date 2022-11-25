

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MultiPanelApp_20161822 extends JFrame {
//	MultiPanelFrame 생성자 
//		// 생성자를 호출할 것. 교재 506 페이지 참조
	public MultiPanelApp_20161822() {
//		"여러 개의 패널을 가진 프레임“ 타이틀 달기 // 수퍼클래스인 JFrame
		setTitle("여러 개의 패널을 가진 프레임");

//		프레임 윈도우를 닫으면 프로그램 종료하도록 설정 // 예제 9-4
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		컨텐트 팬을 알아내서 변수 c에 저장(선언 및 초기화) // 예제 9-4
		Container c = getContentPane();

//		// 컨텐트팬은 디폴트로 BorderLayout 배치 관리자를 사용하므로
//		// 배치 관리자를 추가적으로 설정할 필요는 없음
//		NorthPanel을 생성한 후, 컨텐트 팬 c에 추가하라. 
//		이때 NorthPanel을 컨텐트 팬의 북쪽에 배치하라. // 예제 9-4
		c.add(new NorthPanel(), BorderLayout.NORTH);

//		SouthPanel을 생성한 후 컨텐트 팬에 추가하되, 남쪽에 배치되게 하라.
		c.add(new SouthPanel(), BorderLayout.SOUTH);

//		CenterPanel 을 생성한 후 컨텐트 팬에 추가하되, 중앙에 배치되게 하라.
		c.add(new CenterPanel(), BorderLayout.CENTER);

//		프레임의 크기를 320,320(적절히 크기 조절할 것)으로 설정 // 예제 9-4
		setSize(320, 320);

//		화면에 보이기 // 예제 9-4
		setVisible(true);
	}

	public static void main(String[] args) {
		new MultiPanelApp_20161822();
	}

}

//JPanel을 상속받은 NorthPanel 클래스 { // 뒤 페이지 참조 }
class NorthPanel extends JPanel {
	public NorthPanel() {
		// 아래에서 호출하는 모든 함수는 슈퍼 클래스인 JPanel의 멤버 함수이므로
		// a.add()처럼 객체 이름 a. 을 사용하지 말고 add() 함수를 바로 호출하면 됨
//		백그라운드 색을 LIGHT_GRAY로 설정한다 // 백그라운드 설정은 교재 527 힌트의
		setBackground(Color.LIGHT_GRAY);
		// 함수를 사용, 칼라 값의 종류는 이 실습 노트 1 페이지 참조
//		배경색이 보이게 함
		setOpaque(true);

		// 실습 9-4에서 버튼의 배경색이 보이게 설정하는 함수를 사용
		// JPanel은 디폴트 배치관리자로 FlowLayout을 사용하지만, 확실히 하기 위해
//		FlowLayout 생성하여 배치관리자로 설정
		// 위 FlowLayout 생성 시 디폴트 중앙정렬 사용, 교재 513 하단, 514 페이지
		setLayout(new FlowLayout(FlowLayout.CENTER));

//		"열기“, "닫기“, "나가기“ 버튼을 생성하여 이 패널에 추가 // 교재 513 하단
		// 위의 모든 함수 호출은 a.add()처럼 객체 이름 a. 을 사용하지 말고
		// 그냥 add() 함수를 바로 호출하면 됨
		add(new JButton("열기"));
		add(new JButton("닫기"));
		add(new JButton("나가기"));
	}
}

//JPanel을 상속받은 SouthPanel 클래스 { // 뒤 페이지 참조 }
class SouthPanel extends JPanel {
	public SouthPanel() {
		// 아래에서 호출하는 모든 함수는 슈퍼 클래스인 JPanel의 멤버 함수이므로
		// a.add()처럼 객체 이름 a. 없이 그냥 add() 함수를 바로 호출하면 됨
//	백그라운드 색을 노란색으로 설정한다
		setBackground(Color.yellow);

//	배경색이 보이게 함
		setOpaque(true);

//	FlowLayout 생성하여 배치관리자로 설정
		// 위 FlowLayout 생성 시 왼쪽 정렬 사용, 교재 514 페이지 하단
		setLayout(new FlowLayout(FlowLayout.LEFT));

//	"Word Input“ 버튼을 생성하여 이 패널에 추가 // 교재 513 하단
		add(new JButton("Word Input"));

//	텍스트 입력 창인 JTextField(15)를 생성하여 이 패널에 추가 // 예제 9-5
		// new JTextField(15)는 입력창의 가로 크기가 15글자 입력 가능한 크기로 생성
		add(new JTextField(15));
	}
}

//JPanel을 상속받은 CenterPanel 클래스 { // 뒤 페이지 참조 }
class CenterPanel extends JPanel {
	public CenterPanel() {
//	백그라운드 색을 WHITE로 설정한다
		setBackground(Color.white);
		setOpaque(true);

//	배치관리자 없음으로 설정 // 교재 522 중간 참조
		setLayout(null);
//	10번 반복 
		for (int i = 0; i < 10; i++) {
//	JLabel 변수 j 선언 및 초기화 (“*” 문자열을 가지는 JLabel 객체 생성하여)
			JLabel j = new JLabel("*");
//	정수형 x, y 변수 선언 및 초기화 (난수 발생하여 각각 초기화)
			// x는 10~260, y는 10~210 난수 발생은 교재 532 실습문제 6 참조
			int x = (int) (Math.random() * 250 + 10);
			int y = (int) (Math.random() * 200 + 10);
//	label j를 x, y 위치에 배치 // 교재 532 실습문제 6
			j.setLocation(x, y);

//	label j의 크기를 20, 20으로 설정 // 교재 532 실습문제 6
			j.setSize(20, 20);

//	label j의 전경색을 빨간색으로 설정 // 전경색은 setForeground() 멤버 함수
			// 사용; 백그라운드 색을 변경하는 함수와 유사하게 호출
			j.setForeground(Color.RED);
//	label을 이 패널(CenterPanel)에 추가
			add(j);
		}
	}
}