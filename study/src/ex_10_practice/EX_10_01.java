package ex_10_practice;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//명품자바 10장 예제 1
public class EX_10_01 extends JFrame {
	public EX_10_01() {
		setTitle("Actions 이벤트 리스너 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JButton b = new JButton("Action");
		b.addActionListener(new MyActionListener());
		c.add(b);

		setSize(350, 150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new EX_10_01();
	}
}

class MyActionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton getButtonSorce = (JButton) e.getSource();
		if (getButtonSorce.getText().equals("Action")) {
			getButtonSorce.setText("액션");
		} else {
			getButtonSorce.setText("Action");
		}
	}
}