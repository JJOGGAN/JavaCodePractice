package chat.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class ClientGUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8715737976180587413L;
	private JTextArea jta = new JTextArea(40, 25); // 채팅 창
	private JTextField jtf = new JTextField(25); // 글 입력 부분
	private String nickname;

	private ClientBackground back = new ClientBackground();

	public ClientGUI(String nickname) {
		this.nickname = nickname;

		//가독성을 위해 주요 코드를 메소드에 담음
		init(); 

		back.setGui(this);
		back.connect(nickname);
	}
// 생성자 부분의 가독성을 높이기 위해 init 메소드 생성
	private void init() {
		
		// 생성자 - 초기값 지정 , JFrame의 기본화면 구성
		jta.setEditable(false);
		jta.setFont(new Font("맑은고딕", Font.PLAIN, 18)); // 폰트 설정
		jta.setBackground(new Color(230, 255, 230)); // 배경색
		add(jta, BorderLayout.CENTER);

		jtf.addActionListener(this); // jtf enter key -> actionPaerfomed()호출
		add(jtf, BorderLayout.SOUTH);

		setBounds(200, 100, 400, 600);
		setTitle("Client");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

//GUI의 addActionListener는 스레드를 따로 가지고 있음
//event마다 쓰레드는 따로 걸려있다
//event가 동시에 일어나진 않잖어
	@Override
	public void actionPerformed(ActionEvent e) {
		// ?? synchronized를 할 것인가 말 것인가

		// 문자입력 창에 글을 입력 시 구동할 이벤트 설정
		String msg = nickname + ">>> " + jtf.getText() + "\n";
		System.out.println(msg);
		// jta.append(msg); // 채팅창에 추가
		jtf.setText(""); // 입력 후 내용 초기화
		back.sendMessage(msg);
	}

	public void setJtaAppendMsg(String msg) { // setter 같은 기능
		jta.append(msg); // jta에 추가 해줌
	}
}
