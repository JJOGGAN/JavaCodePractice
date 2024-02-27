package mclass.week3.exception;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;

public class TestException {
	public static void main(String[] args) {

//	Unhandled exception type FileNotFoundException
// It is already handled by the catch block for IOException

		BufferedReader br = null;
		try {
			System.out.println("====== 1");
			br = new BufferedReader(new FileReader(new File("a.txt"))); // ./ 현재 폴더 ../ 상위 폴더
			int a = 10;
			br.readLine();
			System.out.println("====== 2");

		} catch (FileNotFoundException e) { // 보통 e로 선언, 파라미터와 비슷한 느낌
			System.out.println("====== 3");
			// FileNotFoundException가 발생했을 때 실행하고 픈 코드
			e.printStackTrace(); // 디버깅메세지 : 우리가 오류 났을 때 console에 나오는 그 빨간 문장
			// call stack - push/pop -> 뭐하다가 죽었는지 보여줌
		} catch (IOException e) {
			System.out.println("====== 4");
			System.out.println("IOException이 더 큰 범위");
		} finally {
			System.out.println("====== 5");
			// Unhandled exception type IOException
			try {
				// The local variable br may not have been initialized
				// br에 null값넣기
				// NullPointerException 런타임 에러 발생
				if(br !=null) br.close();  //if 뒤에 한 줄 실행이라면 생각가능
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
// 여기 실행
		System.out.println("====== 6");

		System.out.println("마무리 됨");

		try {
			List<String> list = null;
			list.add("오류");
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		System.out.println("제대로 마무리 됨");

		System.out.println("밑의 내용은 보일까?");
		List<String> list = null;
		list.add("오류");
		System.out.println("===보이지 않음===");

	}
}
