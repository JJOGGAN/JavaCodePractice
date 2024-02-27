package practice.tcp.hardInteraction.run;

import practice.tcp.hardInteraction.TCPEchoClientHard;

public class ClientRunHard {

	public static void main(String[] args) {
		int port =8010;
		new TCPEchoClientHard().tcpClient("localhost", port);

	}

}
