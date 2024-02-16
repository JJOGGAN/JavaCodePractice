package mclass.week3.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class TestIOStream {
	public static void main(String[] args) {
//		File 객체 생성
		File f1 = new File("./test/test.txt"); //
		if (!f1.exists()) { // /*!f1.exists()*/ f1이 존재하지 않으면!!!! 만들어줘
			/* .exists : return boolean */
			/*
			 * test 폴더를 만들고 test.txt 폴더를 만들고! test.txt 파일을 만듦 디렉토리 상태 적혀있는 경로 전체가 폴더로 생성된 후
			 * 파일 생성
			 */
			// 우리가 아는 test.txt 파일 만들기
			f1.mkdirs(); // 없는 디렉토리 모두 만들기
		}
//		
		File f2 = new File("./test/test.txt/test2.txt");
		try {
			f2.createNewFile(); // return boolean
			/* createNewFile */
			/*
			 * 파일 생성 test 파일 생성, test.txt파일 생성 후 test2.txt 파일 생성 디렉토리가 없으면 파일이 만들어지지 않음 파일이
			 * 관리되는 객체
			 */
		} catch (IOException e) {
			e.printStackTrace();
		}
//		
		File f3 = new File("test3.txt");
		try {
			f3.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("= f3 : 성공");

//		
		// 현재디렉토리에 파일 생성시에는 mkdir을 File 생성 없어도 됨
		String[] fileArr = new File("./").list(); // 현재 경로에 list 생성
		/*
		 * new File(Directory) -> 리스트 같은 걸 생성할 수 있는 것 new File(FileName) ->
		 */
		if (fileArr != null) {
			for (String filename : fileArr) {
				System.out.println(filename);
			}
			System.out.println("= fileArr : did it");
		}
		System.out.println("= out of try(file Arr) : noting");

//a.txt의 크기 알아보기
		File f5 = new File("./a.txt");
		System.out.println(f5.length()); // byte 크기가 나온다 //102 byte

//directory
		if (f3 != null) {
			if (f3.isDirectory()) {
				String[] fileList = f3.list();
			} else if (f3.isFile()) {
				System.out.println(f3.length());
				System.out.println(f3.getPath());
			}
		}
//파일객체에 쓰기 (출력) : 출력 Stream 사용
		// BufferedReader br = new BufferedReader(new FileReader(new File("a.txt")));
		// 파일객체에 쓰기(출력스트림) // f3,f5
		FileWriter fw = null; // 1. try 밖에서 선언하여 null해주고
		FileWriter fw2 = null; //

		try {
			fw = new FileWriter(f3);
			fw.write("xyz"); // file열어 둔 채로 하면 입력 안 됨 //값을 바꿔 넣으면 추가가 아니고 덮어쓰기가 됨
			fw.flush();

			fw2 = new FileWriter(f5, true); // append 생략하면 false로 설정됨
			fw2.write("Tomorrow!!"); // .flush(); 가 없으면 write가 안 됨!!!???
										// 밀어내기를 안 해서 값이 들어가지 않음
			fw2.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (fw != null)
					fw.close();// 2. fw값이 null이 아니라면! close해줘라
				if (fw2 != null)
					fw2.close(); // close();에 flush 기능이 있어서 위에 flush안 적어도 값이 입력됐었음
			} catch (Exception e) { // 값을 추가하고 싶다면 flush 추가를 하는 것으로 습관을 들여둘 것
				e.printStackTrace();
			}
		}
//파일객체 읽기(입력 스트림)
//		생성 순서, 값 넣기 순서, close순서 주의!!!
		System.out.println("***입력스트림***");
		FileReader fr = null; 		//기반 스트림
		BufferedReader br = null; 	//보조 스트림
		try {
			fr = new FileReader(f5);
			char[] readData = new char[100];
			System.out.println("readData.length : "+readData.length);
			int length = fr.read(readData); //char배열을 읽어낸다
			System.out.println("length : "+length);
			System.out.println(readData); //WHY 앞에 String 추가하니 주소값이 나옴..
			String readStr = String.valueOf(readData); // char배열을 String 형으로 변환
			System.out.println(readStr);
			
			//보조스트림
			br = new BufferedReader(fr);
			String s=null;
			while(	(s = br.readLine()) != null) {
				System.out.println(s);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(br != null) br.close(); //보조 스트림 우선 꼭 닫아줘야함
				if(fr != null) fr.close(); //기본 스트림 꼭 닫아줘야함
				//순서가 바뀌면 중간중간 메모리가 낭비 됨
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		System.out.println("*****파일 탐색기로 확인해주세요*****");

	}
}
