package mclass.week3.exception;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;

public class TestException3 {
	public static void main(String[] args) /* throws FileNotFoundException */ {
		// 날려 이 클래스를 호출한 애가 이거 처리해~ 난 안 해~ 임
/*
 * 현재 Practice 파일이 Git에 연동되어서 C/user밑에 파일이 이동되어 있음 : 이클립스를 직접 깃에 연동해서 그럼
 * 절대 경로로 넣으면 안 찾아질 수도 있음
 * 상대 경로로 해서 넣읍시다
 * 맨 상위 경로는 ./로 설정
 * 파일의 형식에 맞춰서 이름 넣기
 * ./log/20240216file : 파일 형식이 없음 .txt를 붙이면 부를 수 없음
 * 
 * */
		
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(new File("./log/20240216file")))) { //파일이 자바프로젝트 바로 밑에 와야 읽힘
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

// 여기 실행

	}

}
