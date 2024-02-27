package com.kh.practice.list.music.view;

import java.util.Scanner;

import com.kh.practice.list.music.controller.MusicController;
import com.kh.practice.list.music.model.vo.Music;

public class MusicView {
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();

	public void mainMenu() {
//		=====***** 메인 메뉴 *****===== 
//				1. 마지막 위치에 곡 추가 
//				2. 첫 위치에 곡 추가 
//				3. 전체 곡 목록 출력 
//				4. 특정 곡 검색  
//				5. 특정 곡 삭제 
//				6. 특정 곡 수정 
//				7. 곡 명 오름차순 정렬 
//				8. 가수 명 내림차순 정렬 
//				9. 종료 
//				메뉴 번호 입력 : 
		loopOut: while (true) {
			System.out.println("=====***** 메인 메뉴 *****===== ");
			System.out.println("1. 마지막 위치에 곡 추가 ");
			System.out.println("2. 첫 위치에 곡 추가 ");
			System.out.println("3. 전체 곡 목록 출력 ");
			System.out.println("4. 특정 곡 검색 ");
			System.out.println("5. 특정 곡 삭제 ");
			System.out.println("6. 특정 곡 수정 ");
			System.out.println("7. 곡 명 오름차순 정렬 ");
			System.out.println("8. 가수 명 내림차순 정렬 ");
			System.out.println("9. 종료 ");
			System.out.print("메뉴 번호 입력 : ");
			String munuNum = sc.nextLine();
			switch (munuNum) {
			case "1":
				addList();
				break;
			case "2":
				addAtZero();
				break;
			case "3":
				printAll();
				break;
			case "4":
				searchMusic();
				break;
			case "5":
				removeMusic();
				break;
			case "6":
				setMusic();
				break;
			case "7":
				ascTitle();
				break;
			case "8":
				descSinger();
				break;
			case "9":
				System.out.println("프로그램 종료");
				break loopOut;
			default:
				System.out.println("잘못된 메뉴입니다. 다른 번호를 입력해주세요");
				break;
			}
		}
	}

	// 큰 틀은 UML을 하면서 채우고
	// 각 메소드의 세세한 부분(지역변수)은 내 상상력으로 채워야한다
	// 세부내용은 내 재량
	// View를 채우고 그때그때 필요한 controller에서 필요한 메소드를 같이 작성
	// 화이팅
	public void addList() {
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		Music inputMusic = new Music(title, singer);
//		int result = mc.addList(new Music(title, singer));
		int result = mc.addList(inputMusic);
		if (result == -1) {
			System.out.println("추가 실패");
			return;
		}
		System.out.println("추가 성공");
	}

	public void addAtZero() {
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		int result = mc.addAtZero(new Music(title, singer));
		if (result != 1) {
			System.out.println("추가 실패");
			return;
		}
		System.out.println("추가 성공");
	}

	public void printAll() {
		System.out.println("****** 전체 곡 목록 출력 ******");
		System.out.println(mc.printAll());
	}

	public void searchMusic() {
		System.out.println("****** 특정 곡 검색 ****** ");
		System.out.print("검색할 곡 명 : ");
		String find = sc.nextLine();
		Music findM = mc.searchMusic(find);
		if (findM == null) {
			System.out.println("해당 곡이 존재하지 않습니다.");
		} else {
			System.out.println(findM.getSinger() + " - " + findM.getTitle());
		}
		// 사용자에게 곡 이름을 받고 MusicController에 있는 searchMusic으로 값을 넘긴다.
		// searchMusic()의 반환 값에 따라 반환 값이 없으면 “검색한 곡이 없습니다.”
		// 반환 값이 있으면 “검색한 곡은 000(곡 명, 가수 명) 입니다.” 콘솔 창에 출력

	}

	public void removeMusic() {
		System.out.println("****** 특정 곡 삭제 ******");
		System.out.print("삭제할 곡 명 : ");
		String remove = sc.nextLine();
		Music removeM = mc.removeMusic(remove);
		if (removeM == null) {
			System.out.println("삭제할 곡이 없습니다.");
		} else {
			System.out.println(removeM.getSinger() + " - " + removeM.getTitle() + "을(를) 삭제했습니다.");
		}

	}

	public void setMusic() {
		System.out.println("****** 특정 곡 정보 수정 ****** ");
		System.out.print("검색할 곡 명 : ");
		String find = sc.nextLine();
		System.out.print("수정할 곡 명 : ");
		String setS = sc.nextLine();
		System.out.print("검색할 곡 명 : ");
		String setT = sc.nextLine();
		mc.setMusic(find, new Music(setT, setS));

	}

	public void ascTitle() {
		if(mc.ascTitle() ==1) {
			System.out.println("정렬 성공");
		}else {
			System.out.println("정렬 실패");
		}
	}

	public void descSinger() {
		if(mc.ascTitle() ==1) {
			System.out.println("정렬 성공");
		}else {
			System.out.println("정렬 실패");
		}
	}

}
