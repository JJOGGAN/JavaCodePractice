package kh.mclass.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPEchoClient {
	private static int destPort = 9007;
	private static int myPort = 9008;
	private static String ip = "localhost"; // 상대방 ip

	public static void main(String[] args) {
		new UDPEchoClient().udpClient(myPort);
	}

	public void udpClient(int myPort) {
		System.out.println("보낼 메세지 > ");
		Scanner sc = new Scanner(System.in);
		String sendMsg = sc.nextLine();
//		byte[] sendMsgByteArr = new byte[endMsg.length()*2];
//		원래 String =4byte 라서 2배를 하는 게 맞다
//		BUT!! UDP에선 한글은 길이가 3 배!!!
//		그냥 .getBytes()쓰는게 즣습니다.
		byte[] sendMsgByteArr= sendMsg.getBytes();
		System.out.println("byte 배열 길이 : "+sendMsgByteArr.length);
		

		// 1. UDP소켓 생성
		try (DatagramSocket dsock = new DatagramSocket();) { // try()안에 넣으면 굳이 close 안 해줘도 됨
			InetAddress inetAddr = InetAddress.getByName(ip); // 상대방 ip
			//DatagramSocket에 굳이 port값 안 넣어도 됨
			//Server와 같은 번호를 하면 송신이 안 됨
			//각각이 따로니까 각각 다른 port번호를 가지고 상대방의 port로 보내야함
			
			
			// 2.  송신할 데이터 만들기
			DatagramPacket dPacket = new DatagramPacket(
					sendMsgByteArr, //보내는 데이터를 byte[]형태로
					sendMsgByteArr.length, 		//
					inetAddr, //ip는 String 자료형이고 DatagramPacket은 InetAddress를 요구하기 때문에 자료형을 변환해줘야한다 
					destPort);
			
			// 3. Socket을 통해 Packet을 보내기
			dsock.send(dPacket);
			System.out.println("===");

		} catch (SocketException | UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
