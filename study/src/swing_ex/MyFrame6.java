package swing_ex;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// 예제5를 수정하여 버튼에 action command 설정하고
// 하나의 액션 이벤트 리스너에서 분기하기

public class MyFrame6 extends JFrame implements ActionListener {
	public MyFrame6() {
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

		// 버튼에 리스너 등록하기
		sendBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		updateBtn.addActionListener(this);

		// 버튼에 action command 설정하기
		sendBtn.setActionCommand("send");
		deleteBtn.setActionCommand("delete");
		updateBtn.setActionCommand("update");

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println(e);
		if (command.equals("send")) {
			System.out.println("전송합니다.");
		} else if (command.equals("delete")) {
			System.out.println("삭제합니다.");
		} else if (command.equals("update")) {
			System.out.println("수정합니다.");
		}
	}

	public static void main(String[] args) {
		new MyFrame6();
	}
}
