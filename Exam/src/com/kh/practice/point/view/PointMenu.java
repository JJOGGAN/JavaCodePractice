package com.kh.practice.point.view;

import java.util.Scanner;

import com.kh.practice.point.controller.CircleController;
import com.kh.practice.point.controller.RectangleController;

public class PointMenu {
	Scanner sc = new Scanner(System.in);
	CircleController cc = new CircleController();
	RectangleController rc = new RectangleController();
	private final String menuX= "X whkvy :"; 

	public void mainMenu() {
		// TODO 메인메뉴 출력, 잘못 입력했을 시 다시 반복
		boolean exit = true;
		while (exit) {
			System.out.println("===== 메뉴 =====");
			System.out.println("1. 원 ");
			System.out.println("2. 사각형");
			System.out.println("9. 끝내기 ");
			System.out.print("메뉴 번호 : ");
			String menuNum = sc.nextLine();
			switch (menuNum) {
			case "1":
				circleMenu();
				break;
			case "2":
				rectangleMenu();
				break;
			case "9":
				System.out.println("종료합니다.");
				exit = false;
				break;

			default:
				System.out.println("잘못된 메뉴입니다.");
				break;
			}
		}
	}

	public void circleMenu() {

		System.out.println("===== 원 메뉴 =====");
		System.out.println("1. 원 둘레 ");
		System.out.println("2. 원 넓이");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");
		String menuNum = sc.nextLine();
		switch (menuNum) {
		case "1":
			calcCircum();
			break;
		case "2":
			calcCircleArea();
			break;
		case "9":
		default:
			break;
		}

	}

	public void rectangleMenu() {
		System.out.println("===== 사각형 메뉴 =====");
		System.out.println("1. 사각형 둘레 ");
		System.out.println("2. 사각형 넓이");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");
		String menuNum = sc.nextLine();
		switch (menuNum) {
		case "1":
			calcPerimeter();
			break;
		case "2":
			calcRectArea();
			break;
		case "9":
		default:
			break;
		}
	}

	public void calcCircum() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		System.out.print("반지름 : ");
		int radius = sc.nextInt();
		sc.nextLine();
		String str = cc.calcCircum(x, y, radius);
		System.out.print("둘레 : " + str);
		System.out.println();
	}

	public void calcCircleArea() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		System.out.print("반지름 : ");
		int radius = sc.nextInt();
		sc.nextLine();
		String str = cc.calcArea(x, y, radius);
		System.out.print("넓이 : " + str);
		System.out.println();
	}

	public void calcPerimeter() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		System.out.print("높이 : ");
		int height = sc.nextInt();
		System.out.print("너비 : ");
		int wight = sc.nextInt();
		sc.nextLine();
		String str = rc.calcPerimeter(x, y, height, wight);
		System.out.print("둘레 : " + str);
		System.out.println();
	}

	public void calcRectArea() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		System.out.print("높이 : ");
		int height = sc.nextInt();
		System.out.print("너비 : ");
		int wight = sc.nextInt();
		sc.nextLine();
		String str = rc.calcArea(x, y, height, wight);
		System.out.print("넓이 : " + str);
		System.out.println();
	}

}
