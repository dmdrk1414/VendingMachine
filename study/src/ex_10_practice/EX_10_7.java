package ex_10_practice;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

// 명품자바 10장 예제 7
public class EX_10_7 extends JFrame {
	JLabel label = new JLabel("test");

	public EX_10_7() {
		setTitle("key Code 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();

		c.addKeyListener(new MyKeyListener());

		c.add(label);
		setSize(300, 200);
		setVisible(true);

		c.setFocusable(true);
		c.requestFocus();
	}

	class MyKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			Container contentPane = (Container) e.getSource();
			int keyCode = e.getKeyCode();
			char keyChar = e.getKeyChar();
			String keyCodeString = e.getKeyText(keyCode);
			// %은 유니코드 == e.getKeyChar()
			if (keyChar == '%') {
				contentPane.setBackground(Color.YELLOW);
			}

			// F1은 == e.getKeyCode()
			if (keyCode == e.VK_F1) {
				contentPane.setBackground(Color.GREEN);
			}
			if (keyCode == e.VK_1) {
				contentPane.setBackground(Color.BLACK);
			}
			System.out.println(keyChar);
		}
	}

	public static void main(String[] args) {
		new EX_10_7();
	}
}
