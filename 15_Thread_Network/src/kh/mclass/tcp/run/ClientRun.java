package kh.mclass.tcp.run;

import kh.mclass.tcp.TCPEchoClient;

public class ClientRun {
	public static void main(String[] args) {
		int port = 8009; 
		new TCPEchoClient().tcpClient("localhost", port);
		// ServerRun과 port 번호가 같은 이유 : 
		//client가 SererRun이라는 Server에 접속해야하는 것이기 때문에
		//port번호가 같아야 해요 ServerRun의 port번호가 바뀌면
		//client에 넣을 port 번호도 바뀌어야합니다.
	}
}
