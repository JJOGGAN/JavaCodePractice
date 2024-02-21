package kh.mclass.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MouseListenerEx extends JFrame {
	private JLabel jlabel = new JLabel("move it!");

	public MouseListenerEx() {
		setTitle("글자 이동과 색변환");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane(); //내용을 담을 수 있게 해줄래
		c.addMouseListener(new MyMouseListener());
		c.addMouseListener(new MyMouseListener2());
		c.addMouseWheelListener(new MyWheelListener());

		c.setLayout(null);
		jlabel.setSize(80, 15);
		jlabel.setLocation(70, 70);
		c.add(jlabel);

		setSize(400, 500);
		setVisible(true);
	}

	class MyMouseListener implements MouseListener { //클릭하는 곳에 text가 뜸
		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			jlabel.setLocation(x, y);
		}

		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}

	class MyMouseListener2 extends MouseAdapter { // 클릭할 때마다 글자 색이 바뀜
		public void mouseClicked(MouseEvent e) {
			Color[] colors = {Color.red,Color.blue,Color.green,Color.orange};
			if (e.getClickCount() == 1) {
				Random r = new Random();
				jlabel.setForeground(colors[r.nextInt(4)]);
			}
		}
	}
	
	class MyWheelListener implements MouseWheelListener {

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) { //휠을 움직이면 색이 변함
			int red = (int) (Math.random() * 256);
			int green = (int) (Math.random() * 256);
			int blue = (int) (Math.random() * 256);
			Component c = (Component) e.getSource();
			c.setBackground(new Color(red, green, blue));

		}

	}

	public static void main(String[] args) {
		new MouseListenerEx();
	}
}
