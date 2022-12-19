package ex_11;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EX_11_1 extends JFrame {
	public EX_11_1() {
		setTitle("연습 1번");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JButton button_1 = new JButton("Magenta/Yellow Button");
		JButton button_2 = new JButton("Disabled Button");
		JButton button_3 = new JButton("getX(), getY()");

		button_1.setBackground(Color.yellow);
		button_1.setForeground(Color.RED);
		button_1.setFont(new Font("Arial", Font.ITALIC, 20));
//		button_2.disable();
		button_2.setEnabled(false);
		button_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				Point bPoint = b.getLocation();

//				setTitle(bPoint.x + " " + bPoint.y);
//				setTitle(bPoint.toString();
			}
		});

		c.add(button_1);
		c.add(button_2);
		c.add(button_3);
		setSize(200, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new EX_11_1();
	}
}
