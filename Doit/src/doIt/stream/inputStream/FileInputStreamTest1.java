package doIt.stream.inputStream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest1 {

	public static void main(String[] args) {
		FileInputStream fis1 = null;

		//input.txt이 생성되지 않은 상태일 때
		try {
			fis1 = new FileInputStream("input.txt"); // 파일 입력 스트림 input.txt 는 아직 존재하지 않음
			System.out.print(fis1.read()); //.read()는 1byte씩 읽어냄 int 반환
			System.out.print(fis1.read());
			System.out.print((char)fis1.read());
			System.out.print((char)fis1.read());
			System.out.print(fis1.read());
			System.out.print(fis1.read());
		} catch (IOException e) { // 여기서 캐치
			System.out.println("Null"); 
			System.out.println(e); 
		} finally {
			try {
				fis1.close(); //스트림이 생성되지 않았음 -> NullPointException
			} catch (IOException e) {
				System.out.println("NullPointer");
				System.out.println(e);
			} catch (NullPointerException e) {
				System.out.println("NullPointerException!"); //실행
				System.out.println(e);
			}
		}
		System.out.println("end"); // finally 밖의 코드
	}

}
