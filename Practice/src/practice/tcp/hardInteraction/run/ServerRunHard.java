package practice.tcp.hardInteraction.run;

import practice.tcp.hardInteraction.TCPEchoServerHard;

public class ServerRunHard {

	public static void main(String[] args) {
		//1. 서버의 포트번호를 정함
		int port =8010;
		new TCPEchoServerHard().tcpServer(port);

	}

}
