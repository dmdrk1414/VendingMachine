package ex_10_practice;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

// 명품자바 10장 예제 6
public class EX_10_6 extends JFrame {
	JLabel[] labels = new JLabel[3];
	StringBuilder sb = new StringBuilder();

	public EX_10_6() {
		setTitle("KeyListener 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		labels[0] = new JLabel("getKeyCode()");
		labels[1] = new JLabel("getKeyChar()");
		labels[2] = new JLabel("getKeyText()");

		for (int i = 0; i < labels.length; i++) {
			labels[i].setBackground(Color.yellow);
			labels[i].setOpaque(true);
			c.add(labels[i]);
		}
		c.addKeyListener(new MyKeyEventListener());

		setSize(300, 200);
		setVisible(true);
		c.setFocusable(true);
		c.requestFocus();

	}

	public static void main(String[] args) {
		new EX_10_6();
	}

	class MyKeyEventListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			System.out.println("keyTyped call");
		}

		@Override
		public void keyPressed(KeyEvent e) {

			int keyCode = e.getKeyCode();
			char keyChar = e.getKeyChar();
			sb.append(e.getKeyText(keyCode));
			labels[0].setText(keyCode + ""); // 유니코드의 int값으로
			labels[2].setText(e.getKeyText(keyCode) + ""); // 유니코드 int값을 String으로
			labels[1].setText(keyChar + "");
			System.out.println(sb);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("keyReleased call");
		}

	}
}
