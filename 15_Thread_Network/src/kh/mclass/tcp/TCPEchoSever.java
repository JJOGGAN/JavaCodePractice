package kh.mclass.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPEchoSever {
	public void tcpServer(/* byte[] ip, */int port) {
		/*TCP에서 필수 호출 4개*/ //close 반드시 해야함
		ServerSocket ss = null;
		Socket s = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			/*1. 서버 소켓 생성*/
			ss = new ServerSocket(port); // port안 넣어주면 window에서 port번호 자동 할당함

			/*2. 4.  클라이언트의 접속 대기*/ //--> 클라이언트의 접속 요청
			s = ss.accept(); // accept : client의 접속할 때 까지 대기
			
			// 입출력 스트리 얻어옴
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
			
			String msg = null;
			while((msg = br.readLine())!= null) {
				System.out.println("client > "+msg);
				
				pw.println("echo~~~~"+msg);
				pw.flush();//밀어 넣어주지 않으면 상대쪽에서 읽지 않는 경우가 생길지도
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				/*close 순서 중요*/
				//초기화 된 순서 반대로 닫아줘야지요 아니면 오류남
				if (br != null)br.close();
				if (pw != null)pw.close(); //br,pw는 순서 상관 없음 둘 다 s보다 먼저 닫기만 하면 됨
				
				if (s != null)s.close();
				if (ss != null)ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
