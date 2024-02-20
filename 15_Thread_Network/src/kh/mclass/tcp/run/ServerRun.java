package kh.mclass.tcp.run;

import kh.mclass.tcp.TCPEchoSever;

public class ServerRun {

	public static void main(String[] args) {
//		tcpServer(byte[])를 하게 되면
// 여기서 실행하면 이 pc 의 ip 번호를 넣게 될 것이다.
		int port = 8009; //가독성을 위해 변수를 지정해서 아규먼트 전달
	new TCPEchoSever().tcpServer(port);
	}
}
