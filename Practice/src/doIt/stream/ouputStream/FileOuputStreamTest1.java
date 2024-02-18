package doIt.stream.ouputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOuputStreamTest1 {
	public static void main(String[] args) {
		try (FileOutputStream ofs = new FileOutputStream("ouput.txt")) {
			ofs.write(65); //아스키코드로 반환
			ofs.write(66);
			ofs.write(67);
			ofs.write(97);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("출력이 완료 되었습니다.");
	}
}
