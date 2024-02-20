package kh.mclass.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyFrame extends JFrame {

	public MyFrame() {
		// title exit 를 윗 단에
		setTitle("나의 첫 프레임 이노라");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 버튼 활성화 선언

		Container contenPane = getContentPane();

		contenPane.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.ORANGE);
//		contentPane.setLayout(new FlowLayout());
//		contenPane.setLayout(new BorderLayout());
		contenPane.setLayout(new GridLayout(6, 2));
		
		JButton btnOK = new JButton("OK");
		JButton vbtnCancel =new JButton("Cancel");
		JButton btnOrg =new JButton("초기값");
		JButton btnOrg2 =new JButton("format");
		JButton btnOrg3 =new JButton("format3");
		
		contentPane.add(btnOK);
		contentPane.add(vbtnCancel);
		contentPane.add(btnOrg);
		contentPane.add(btnOrg2);
		contentPane.add(btnOrg3);
		contenPane.add(new JLabel(" 이름"));
		contenPane.add(new JLabel(" 학번"));
		contenPane.add(new JTextField(""));
		contenPane.add(new JLabel(" 날짜"));
		contenPane.add(new JTextField(""));
		contenPane.add(new JLabel(" 주소지"));
		contenPane.add(new JTextField(""));

		
		btnOK.addActionListener(new ActionListener() { //btnOK에서 action이 발생하면 어떻게 하고 싶은뎅
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnOrg2.setText("값 바꼈지롱");
			}
		});
//		contentPane.add(new JButton("OK"), BorderLayout.NORTH);
//		contentPane.add(new JTextField("Cancel"));
//		contentPane.add(new JButton("Ignore"), BorderLayout.WEST);
//		contentPane.add(new JButton("Date"), BorderLayout.SOUTH);

		setSize(300, 300); // 프레임 크기
		setVisible(true); // 이렇게 해야 보여요 JFrame의 디폴트 값은 false다
		// 크기와 visivle은 하단에 작성

	}

	public static void main(String[] args) {
		new MyFrame();
	}
}
