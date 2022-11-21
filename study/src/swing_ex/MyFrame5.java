package swing_ex;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//전송, 삭제, 버튼을 만들고 각각 액션 이벤트 리스너 만들기

public class MyFrame5 extends JFrame {
	public MyFrame5() {
		setSize(800, 500);
		setLocation(100, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(new FlowLayout());

		JButton sendBtn = new JButton("전송");
		add(sendBtn);
		JButton deleteBtn = new JButton("삭제");
		add(deleteBtn);
		JButton updateBtn = new JButton("수정");
		add(updateBtn);

		// ActionListener 의 익명 객체생성하여 적용
		ActionListener Listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("전송합니다.");
			}
		};

		// 전송 버튼이 눌러졌을 때 특정 객체의 특정 메소드가 호출되게 하는 방법은?
		sendBtn.addActionListener(Listener);

		// ActionListener의 익명 객체 생성
		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("삭제합니다.");
			}
		});

		// 람다식을 이용한 방식
		updateBtn.addActionListener((e) -> {
			System.out.println("수정합니다.");
		});

		setVisible(true);
	}

	public static void main(String[] args) {
		new MyFrame5();
	}
}
