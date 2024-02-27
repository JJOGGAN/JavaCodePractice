package practice.tcp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPEchoServer {
	public void tcpServer(int port) {
		ServerSocket ss = null;
		Socket s = null;
		PrintWriter pw = null;
		try {
			// ss = new ServerSocket(); //window의 남은 port번호 자동 지정
			// 2.서버용 소켓 객체 생성
			ss = new ServerSocket(port);
			// 내 ip를 사용 하는 것이기 때문에 ip를 지정할 필요 없음
			System.out.println(ss.getInetAddress().getHostAddress() + "===client대기중 ====");

			// 3. 클라이언트의 요청이 들어올 때까지 대기
			s = ss.accept(); // sc.nextLine(); 과 유사 -enter쳐야 넘어가는 것처럼
			System.out.println(s.getInetAddress().getHostAddress() + "===client접속함 ====");

			pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
			pw.println("Hello Client"); // PrintWriter에는 print메소드가 있다. writer보다 좀 더 다양함
			pw.flush();
			// 객체를 계속 선언하다보면 객체의 용도를 모르고 잘못사용될 수 있어서
			// 필요한 곳에 바로바로 선언하는 것이 좋다.
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try { //close는 생성의 반대순서
				if (pw != null)pw.close();
				if (s != null)s.close();
				if (ss != null)ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
