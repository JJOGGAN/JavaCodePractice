package kh.mclass.networkTest;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressEx {
	public void method1(String domain) {
		System.out.println("Informaiton of domain -> " + domain);
		try {
			InetAddress ia = InetAddress.getByName(domain);
			//InetAddress는 static 메소드로 이루어져 있어서 new 선언 없이 객체선언
			System.out.println(ia);
			boolean result = ia.isMulticastAddress();
			//ia 아까 InetAddress 변수를 만들어 냈으니 ia. 로 메소드 호출
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	public void method2(String domain) {
		System.out.println("Informaiton of domain -> " + domain);
		System.out.println("\n**getAllByName**");
		try {
			InetAddress[] ia =InetAddress.getAllByName(domain);
			System.out.println(ia);
			int length = ia.length;
			System.out.println("length : "+length);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		System.out.println("\n**getLocalHost**");
		try {
			System.out.println(InetAddress.getLocalHost());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	//TODO 
//	public void method3(String domain) {
//		byte[] db;
//		for(int i = 0 ; i < domain.length();i++) {
//			db[i] = domain.charAt(i);
//		}
//
//		try {
//			InetAddress ia = InetAddress.getByAddress(domain);
//			System.out.println("\ngetByAddress ->"+ia);
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		}
//	}
}
