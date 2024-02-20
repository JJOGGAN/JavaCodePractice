package kh.mclass.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPEchoServer {
	private static String ip = "localhost"; // 상대방 ip
	private static int myPort = 9007;
	private static int destPort = 9008;

	public static void main(String[] args) { // UDPEchoClient와 서로 독립되어 있음
		new UDPEchoServer().udpServer(myPort);
	}

	public void udpServer(int myPort) {
		//1. UDP소켓 생성
		try (DatagramSocket dSock = new DatagramSocket(myPort);){ // ()안에 넣으면 굳이 close 안 해줘도 됨
			
			while(true) {
				//2. 수신 받을 데이터 Packet 만들기
				byte[] buffer =new byte[1000]; //받을 값이 1000byte이상이면 뒤의 값은 누락됨
				DatagramPacket dPacket = new DatagramPacket(buffer, 1000);
				
				//3.Socket을 통해서 수신받은 데이터를 Packet에 담아달라고 하기
				dSock.receive(dPacket); 
				String receiveMsg = new String(dPacket.getData(),0,dPacket.getLength());
				System.out.println("socket > "+receiveMsg);
				System.out.println(receiveMsg.length());
				System.out.println(dPacket.getLength());
			}
//			System.out.println("===");
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
