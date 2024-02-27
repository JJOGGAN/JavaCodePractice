package chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientBackground {
	private final String IP = "127.0.0.1";
	private final int PORT = 7777;
	// 필드에 생성되었기 때문에 GC가 close역할을 해준다
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private String nickname;

	private ClientGUI gui; // gui의 주소값이 들어와야함

	public void setGui(ClientGUI gui) {
		this.gui = gui;
	}

	// Client가 서버에 접속을 하게 하는 메소드
	public void connect(String nickname) { // PORT번호가 다르면 catch에 있는 것이 실행 됨
		try {
			socket = new Socket(IP, PORT);// server에 연결됨
			gui.setJtaAppendMsg("서버에 접속되었습니다.\n");
			// 서버와 주고 받을 입출력 통로생성
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());

			// 접속 후 서버에서 닉네임을 인식
			out.writeUTF(nickname); // 닉네임 내보냄 //flush 없음

			// 수신 메세지 값이 있는지 계속 반복문으로 확인
			while (in != null) { // 수신값이 null이 아니라면
				String msg = in.readUTF();
				gui.setJtaAppendMsg(msg);
			}

		} catch (IOException e) {
			e.printStackTrace();
			gui.setJtaAppendMsg("서버를 찾을 수 없습니다. IP와 PORT번호를 확인 후 재시도 해주세요");
		} catch (Exception e) {
			gui.setJtaAppendMsg("예기치 못한 요류가 발생했습니다. 프로그램을 재시작해주세요");
		}
	}

	public void sendMessage(String msg) {
		try {
			out.writeUTF(msg);
		} catch (Exception e) {
		}
	}
}
