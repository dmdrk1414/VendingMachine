package swing_ex;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//- JTextField로 입력칸에 문자열을 입력하고,
//전송버튼 누르면 입력한 문자열을 알림창으로 띄우기
//- 삭제 버튼 누르면 입력한 입력칸의 내용 리셋하기

public class MyFrame7 extends JFrame implements ActionListener {

	// 필드 정의하기
	private JTextField inputMsg;
	private JTextField inputMsg2;

	// 생성자
	public MyFrame7() {
		setSize(800, 500);
		setLocation(100, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// FlowLayout 객체 전달하기
		setLayout(new FlowLayout());

		// 문자열을 입력할 수 있는 UI의 참조값을 필드에 저장하기
		inputMsg = new JTextField(10);
		inputMsg2 = new JTextField(10);

		// 전송버튼
		JButton sendBtn = new JButton("전송");
		sendBtn.setActionCommand("send");
		sendBtn.addActionListener(this);

		// 삭제버튼
		JButton deleteBtn = new JButton("삭제");
		deleteBtn.setActionCommand("delete");
		deleteBtn.addActionListener(this);

		// 패널 객체를 생성해서
//		JPanel panel = new JPanel();
//		JPanel pane2 = new JPanel();
		Container panel = getContentPane();
		Container pane2 = getContentPane();

		// 패널에 UI를 추가하고
		panel.add(inputMsg);
		panel.add(sendBtn);
		panel.add(deleteBtn);

		pane2.add(inputMsg2);
		pane2.add(sendBtn);
		pane2.add(deleteBtn);
		// 패널 째로 프레임에 추가하기
//		add(panel);
//		add(pane2);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 이벤트가 발생한 버튼에 설정된 action command 읽어오기
		String command = e.getActionCommand();

		if (command.equals("send")) {
			// JTextField 에 입력한 문자열 읽어오기
			String msg = inputMsg.getText();
			JOptionPane.showMessageDialog(this, msg);
		} else if (command.equals("delete")) {
			inputMsg.setText("");
		}
	}

	public static void main(String[] args) {
		new MyFrame7();
	}

}
