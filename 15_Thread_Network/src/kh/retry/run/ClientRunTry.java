package kh.retry.run;

import kh.retry.TCPEchoClientTry;

public class ClientRunTry {
	public static void main(String[] args) {
		int port = 8010;
		new TCPEchoClientTry().tcpClient("localhost", port);
	}
}
