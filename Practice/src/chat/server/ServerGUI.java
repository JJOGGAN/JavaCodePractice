package chat.server;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class ServerGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = -6808297343310988311L;
	private JTextArea jta = new JTextArea(40, 25); // 채팅 창
	private JTextField jtf = new JTextField(25); // 글 입력 부분
//	private JButton jbtn = new JButton("send"); // 글 입력 button

	// view - controller Field
	ServerBackground back = new ServerBackground(); // 채팅을 담당할 백그라운드(뒷 작업 영역)선언

	public ServerGUI() {
		// 생성자 - 초기값 지정 , JFrame의 기본화면 구성
		jta.setEditable(false);
		jta.setFont(new Font("맑은고딕", Font.PLAIN, 18)); // 폰트 설정
		jta.setBackground(new Color(230, 255, 230));
		add(jta, BorderLayout.CENTER);

		jtf.addActionListener(this); // jtf enter key -> actionPaerfomed()호출
		add(jtf, BorderLayout.SOUTH);
//		jbtn.addActionListener(this);  //send 버튼 만들어서 enter와 동일하게 작동하게 함
//		add(jbtn,BorderLayout.EAST);

		setBounds(200, 100, 400, 600);
		setTitle("Server");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		//
		back.setGui(this); // 현재 창을 back에 전달하고 back에서 setJtaAppendMsg호출
		back.setting(); // 서버 실행 시 서버도 같이 동작 시킨다.

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 문자입력 창에 글을 입력 시 구동할 이벤트 설정
		String msg = "운영자 : " + jtf.getText() + "\n";
		System.out.println(msg);
		jta.append(msg); // 채팅창에 추가
		jtf.setText(""); // 초기화
		back.sendMessage(msg, "운영자");
	}

	public void setJtaAppendMsg(String msg) { // setter 같은 기능
		jta.append(msg); // jta에 추가 해줌
	}

}
