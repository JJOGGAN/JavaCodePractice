package doIt.stream.inputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest2 {
	public static void main(String[] args) {

		FileInputStream fis = null;
		try {
			fis = new FileInputStream("input.txt");
			int i;
			while ((i = fis.read()) != -1) {// i값이 -1이 아니라면 동작
				System.out.println((char) i);
			}
			System.out.println("end");
		} catch (FileNotFoundException e) {
			System.out.println(e);
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
	}
}
