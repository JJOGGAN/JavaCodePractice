package practice.tcp.run;

import practice.tcp.TCPEchoClient;

public class ClientRun {

	public static void main(String[] args) {
		int port =8010;
		new TCPEchoClient().tcpClient("localhost", port);

	}

}
