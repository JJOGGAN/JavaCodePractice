package doIt.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionHandling3 {

	public static void main(String[] args) {
		FileInputStream fis = null;

		try {
			fis = new FileInputStream("a.txt");
		} catch (FileNotFoundException e) {
			System.out.println(e);
			return;
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println("항상 수행됩니다.");
		}

		System.out.println("여기도 수행되지용");

		/* 출력되지 않은 이유 */
		// 제일 밖 catch에서 return을 강제로 했기 때문에 finally의 코드는 실행 되었지만
		// try다음 코드는 실행되지 않음

	}

}
