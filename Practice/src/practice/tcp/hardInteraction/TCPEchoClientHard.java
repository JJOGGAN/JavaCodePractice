package practice.tcp.hardInteraction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPEchoClientHard {
	// ip 안 가져오는 이유 : 현재 돌아가는 곳에서 하려고 - ServerRun class에서 하려고
	public void tcpClient(String ip, int port) {
		Socket cs = null;
		BufferedReader br = null;
		try {
			System.out.println("server에 접속 요청중");
			cs = new Socket(ip, port); // accept로 기다리고 있는 곳으로 감
			System.out.println("server에 접속 완료");
			// Server에서 pw를 받는다
			br = new BufferedReader(new InputStreamReader(cs.getInputStream()));
			String msg = null; //br을 String type으로 변환
			// InputStreamReader만으론 읽기 불편하니 BufferedReader를 사용함
			while((msg=br.readLine())!= null){//readLine가 false가 될 때 까지 읽을 것이다.
				System.out.println("Sever > "+msg);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (cs != null)
					cs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
