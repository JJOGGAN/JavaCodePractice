package mclass.week3.exception;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;

public class TestException2 {
	public static void main(String[] args) /* throws FileNotFoundException */ {
		// 날려 이 클래스를 호출한 애가 이거 처리해~ 난 안 해~ 임

//	Unhandled exception type FileNotFoundException
// It is already handled by the catch block for IOException

		// try-with-resource
		// 선언된 br.close()를 finally구문 처리처럼 해줌
		try (BufferedReader br = new BufferedReader(new FileReader(new File("./log/20240216file")))) { // 파일이 자바프로젝트 바로
																										// 밑에 와야 읽힘
			String s = null;
			while ((s = br.readLine()) != null) {
				System.out.println(s); // readLine 호출이 될 때마다 다음 줄 읽기
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("***여기도 실행***");

		BufferedReader br = null;
		try {
			System.out.println("====== 1"); // ./ 현재 폴더../ 상위 폴더
			int a = 10;
			br.readLine();
			System.out.println("====== 2");

		} catch (FileNotFoundException e) { // 보통 e로 선언, 파라미터와 비슷한 느낌
			System.out.println("====== 3"); // FileNotFoundException가 발생했을 때 실행하고 싶은 코드
			e.printStackTrace(); // 디버깅메세지 : 우리가 오류 났을 때 console에 나오는 그 빨간 문장
			// callstack - push/pop -> 뭐하다가 죽었는지 보여줌
		} catch (IOException e) {
			System.out.println("====== 4");
			System.out.println("IOException이 더 큰 범위");
		} finally {
			System.out.println("====== 5"); // Unhandled exception type IOException
			try { // The local variable br may not have been initialized
					// br에 null값넣기 // NullPointerException 런타임 에러 발생
				if (br != null)
					br.close(); // if 뒤에 한 줄 실행이라면 생각가능

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

// 여기 실행

	}

}
