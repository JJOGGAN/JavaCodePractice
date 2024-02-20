package kh.retry.run;

import kh.retry.TCPEchoServerTry;

public class ServerRunTry {
	public static void main(String[] args) {
		int port = 8010;
		new TCPEchoServerTry().tcpServer(port);
		
	}
}
