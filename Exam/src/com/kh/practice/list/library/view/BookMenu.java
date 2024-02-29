package com.kh.practice.list.library.view;

import java.util.Scanner;

import com.kh.practice.list.library.controller.BookController;
import com.kh.practice.list.library.model.vo.Book;

public class BookMenu {
	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();

	public void mainMenu() {
		System.out.println("===== Welcome KH Library ===== ");
		boolean exit = true;
		while (exit) {
			System.out.print("=====***** 메인 메뉴 *****===== \r\n" + "1. 새 도서 추가 \r\n" + "2. 도서 전체 조회 \r\n"
					+ "3. 도서 검색 조회  \r\n" + "4. 도서 삭제 \r\n" + "5. 도서 명 오름차순 정렬 \r\n" + "9. 종료 \r\n" + "메뉴 번호 입력 : ");
			String menu = sc.nextLine();
			switch (menu) {
			case "1":

				break;
			case "2":

				break;
			case "3":

				break;
			case "4":

				break;
			case "5":

				break;
			case "9":
				System.out.println("프로그램 종료 ");
				exit = false;
				break;

			default:
				break;
			}
		}
	}

	public void insertBook() {
		System.out.println("===== 새 도서 추가 ===== \r\n" + "책 정보를 입력해주세요. ");
		System.out.println("도서 명 :");
		String title = sc.nextLine();
		System.out.println("저자 명 : ");
		String author = sc.nextLine();
//		Book vo = new Book(title, author, author, 0);
	}

	public void selectList() {

	}

	public void searchBook() {

	}

	public void deleteBook() {

	}

	public void ascBook() {

	}
}
