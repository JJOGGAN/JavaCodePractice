package doIt.stream.others;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
//		File fileTest = new File(".\test\test3.txt");
		File fileTest = new File("./test/test3.txt");
		if (!fileTest.exists()) {
			fileTest.mkdirs();
		}

//		File fileTest2 = new File(".\test\test.txt\test4.txt");
		File fileTest2 = new File("./test/test.txt/test4.txt");
		try {
			fileTest2.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		File fileTest3 = new File("./test/test3.txt/test5.txt");
//		File fileTest3 = new File("./././test5.txt");
//		try {
//			fileTest3.createNewFile();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		FileInputStream fis = null;
		try {
			/* 현재 기준 경로라는 건 
			 * 지금 프로젝트를 기준으로 보는 것
			 * 지금 현재 경로는 Practice임 
			 * 그 밑에 파일들은 이름을 적어서 해줘야해요
			 * */
//			fis = new FileInputStream("../Practice/test/test3.txt/test5.txt");  // 상대경로
//			fis = new FileInputStream("C:\\workspace\\JavaCodePractice\\Practice\\test\\test3.txt\\test5.txt");  // 절대경로
//			fis = new FileInputStream("input.txt"); //정상 작동
			int i ; 
			while((i = fis.read())!=-1) {
				System.out.print((char)i);
			}
			System.out.println("\nend");
		} catch (IOException e) {
			System.out.println("오류 발생");
			
		}finally {
			try {
				if(fis != null) fis.close();
			} catch (Exception e2) {
				System.out.println("닫기 실패");
			}
		}
		

	}

}
