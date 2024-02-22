package doIt.stream.inputStream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest3 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("input.txt");
			byte[] bs = new byte[10];
			int i;

			while ((i = fis.read(bs)) != -1) { // 읽은 반환 값이 -1이 아닐 떄 까지 실행
				for (byte b : bs) {
					System.out.println((char) b);
				}
				System.out.println(": " + i + "바이트 읽음");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		System.out.println("end");
	}

}
