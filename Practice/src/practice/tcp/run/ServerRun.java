package practice.tcp.run;

import practice.tcp.TCPEchoServer;

public class ServerRun {

	public static void main(String[] args) {
		//1. 서버의 포트번호를 정함
		int port =8010;
		new TCPEchoServer().tcpServer(port);

	}

}
