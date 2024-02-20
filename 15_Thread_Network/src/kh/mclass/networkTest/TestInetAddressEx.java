package kh.mclass.networkTest;

import java.net.MalformedURLException;
import java.net.URL;

public class TestInetAddressEx {
	public static void main(String[] args) {
		new InetAddressEx().method1("oracle.com");
		new InetAddressEx().method2("oracle.com");

		try {
			System.out.println("---oracle---");
			URL url = new URL("https://www.oracle.com/downloads/index.thml");
			System.out.println("프로토콜 : " + url.getProtocol());
			System.out.println("포트번호 : " + url.getPort());
			System.out.println("호스트 : " + url.getHost());
			System.out.println("파일경로 : " + url.getFile());
			System.out.println("URL 전체 : " + url.toExternalForm());

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

}
