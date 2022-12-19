import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//[구현조건] - 클래스 명은 “P6”으로 생성
//- JFrame을 기반으로 아래 그림 1과 같은 형태의 프레임을 구성

//- 전체 배경색은 노란색이며, 환전 금액의 숫자 부분은 빨간색으로 표기
//- 그림 1과 같이 가로 2개, 세로 3개의 컴포넌트가 배치되도록 설정
//- 컴포넌트 간의 간격은 10픽셀로 설정

//- 프로그램 명은 “환전 계산기”이며, 첫 번째 열에는 “원화”와 “100,000” 텍
//스트가 표기되도록 설정
//- 사용되는 버튼은 “달러 계산”과 “유로 계산”으로 총 2개를 사용
//- “달러 계산” 버튼을 클릭 시, 그림 2와 같이 달러로 환산된 금액과 “USD” 

//텍스트를 붙여서 출력 (환율 : 1200원) - “유로 계산” 버튼을 클릭 시, 그림 3와 같이 유로로 환산된 금액이 “EUR” 
//텍스트를 붙여서 출력 (환율 : 1350원) - 환전 금액은 정수로 출력
//- 버튼 클릭시 발생하는 이벤트를 처리하기 위해서 사용되는 이벤트 리스너 
//방식은 자유롭게 사용 가능

public class p6 extends JFrame {
	public p6() {
		setTitle("P6");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 레이아웃 및 간격 설정
		Container c = getContentPane();
		c.setLayout(new GridLayout(3, 2));
		// 배경 및 환전 금액 색상 설정
		c.setBackground(Color.yellow);
		JLabel 원화 = new JLabel("원화");
		원화.setBackground(Color.yellow);
		원화.setOpaque(true);

		JLabel 원화_돈 = new JLabel("100,000");
		원화_돈.setBackground(Color.yellow);
		원화_돈.setOpaque(true);

		JLabel 환전_금액 = new JLabel("환전 금액");
		환전_금액.setBackground(Color.yellow);
		환전_금액.setOpaque(true);

		JLabel 환전_금액_돈 = new JLabel("0");
		환전_금액_돈.setBackground(Color.yellow);
		환전_금액_돈.setOpaque(true);
		환전_금액_돈.setForeground(Color.RED);

		// 버튼 생성
		JButton 달러_계산 = new JButton("달러 계산");
		달러_계산.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String 원화_돈_내용 = 원화_돈.getText();
				String[] 원화_스플릿_배열 = 원화_돈_내용.split(",");
				원화_돈_내용 = 원화_스플릿_배열[0].concat(원화_스플릿_배열[1]);
				int 원화_돈_내용_돈_int = Integer.parseInt(원화_돈_내용);
				int 원화를_달러 = 원화_돈_내용_돈_int / 1200;
				환전_금액_돈.setText(원화를_달러 + " USD");

			}
		});
		JButton 유로_계산 = new JButton("유로 계산");
		유로_계산.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String 원화_돈_내용 = 원화_돈.getText();
				String[] 원화_스플릿_배열 = 원화_돈_내용.split(",");
				원화_돈_내용 = 원화_스플릿_배열[0].concat(원화_스플릿_배열[1]);
				int 원화_돈_내용_돈_int = Integer.parseInt(원화_돈_내용);
				int 원화를_달러 = 원화_돈_내용_돈_int / 1350;
				환전_금액_돈.setText(원화를_달러 + " EUR");

			}
		});

		// 컨테이너의 레이아웃 적용
		add(원화);
		add(원화_돈);
		add(달러_계산);
		add(유로_계산);
		add(환전_금액);
		add(환전_금액_돈);

		// 컨테이너에 각 컴포넌트 추가
		// 각각의 버튼 클릭 시, 이벤트 처리를 위한 리스너 생성
		setSize(350, 150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new p6();
	}
}
