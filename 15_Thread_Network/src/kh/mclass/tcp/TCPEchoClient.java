package kh.mclass.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPEchoClient {
	public void tcpClient(String ip, int port) {
		Scanner sc = new Scanner(System.in);

		/* TCP에서 필수 호출 3개 */ // close 반드시 해야함
		Socket cs = null;
		PrintWriter pw = null;
		BufferedReader br = null;
		try {
			// 3. 4. 서버에 접속 하는 소켓 생성 / 4. 소켓에 넣는 것이 동시에 이뤄짐
			cs = new Socket(ip, port);

			// 입출력 스트림 얻어옴
			pw = new PrintWriter(new OutputStreamWriter(cs.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(cs.getInputStream()));

			while (true) {
				System.out.println("전달 메세지");
				String inputMsg = sc.nextLine();

				if (inputMsg.equals("exit")) {
					break;
				}
				pw.println(inputMsg);
				pw.flush();

				String msg = null;
				msg = br.readLine();
				if (msg == null) {
					break;
				}
				System.out.println("Echo > " + msg);

			}

			System.out.println("Echo TCP 끝");
		} catch (UnknownHostException e) { // host가 접속 못 할 수도 있다
			e.printStackTrace();
		} catch (IOException e) { // IOException이 발생할 수 있다.
			e.printStackTrace();
		} finally {
			try {
				if (sc != null)sc.close();
				if (br != null)br.close();
				if (pw != null)pw.close();
				if (cs != null)cs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
