package doIt.stream.ouputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class FileOutputStreamTest2 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("ouput2.txt", true);
		try (fos){
			byte[] bs = new byte[26];
			byte data = 65; //A의 아스키 값
			for(int i = 0 ; i < bs.length; i++) {
				bs[i]=data;
				data++;
			}
			fos.write(bs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("출력이 완료 되었습니다.");
	}
}
