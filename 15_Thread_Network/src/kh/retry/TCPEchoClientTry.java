package kh.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPEchoClientTry {
	public void tcpClient(String ip, int port) {
		Scanner sc = new Scanner(System.in);
		Socket cs = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			cs = new Socket(ip,port);
			
			pw = new PrintWriter(new OutputStreamWriter(cs.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(cs.getInputStream()));
			
			while(true) {
				System.out.println("전달메세지 : ");
				String inputMsg = sc.nextLine();
				if(inputMsg.equals("exit")) {
					break;
				}
				pw.println(inputMsg);
				pw.flush();
				
				String msg = null;
				msg = br.readLine();
				if(msg == null) {
					break;
				}
				System.out.println("Echo> "+msg);
			}
			System.out.println("받은 메세지 없음");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(sc !=null) sc.close();
				if(br !=null) br.close();
				if(pw !=null) pw.close();
				if(cs !=null) cs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}}
