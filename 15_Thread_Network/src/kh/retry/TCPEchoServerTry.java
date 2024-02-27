package kh.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPEchoServerTry {
	public void tcpServer(int port) {
		ServerSocket ss = null;
		Socket s = null;
		BufferedReader br = null;
		PrintWriter pw = null;

		try {
			ss = new ServerSocket(port);

			System.out.println("===========클라이언트 접속 대기");
			s = ss.accept();
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));

			String msg = null;
			while ((msg = br.readLine()) != null) {
				System.out.println("client > " + msg);
				pw.println("~~" + msg);
				pw.flush();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(br != null) br.close();
				if(pw != null) pw.close();
				if(s != null) s.close();
				if(ss != null) ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
