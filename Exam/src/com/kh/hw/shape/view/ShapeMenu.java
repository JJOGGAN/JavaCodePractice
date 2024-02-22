package com.kh.hw.shape.view;

import java.util.Scanner;

import com.kh.hw.shape.controller.SquareController;
import com.kh.hw.shape.controller.TriangleController;

public class ShapeMenu {
	Scanner sc = new Scanner(System.in);
	SquareController scr = new SquareController();
	TriangleController tc = new TriangleController();

//	===== 도형 프로그램 ===== 
//			3. 삼각형 
//			4. 사각형 
//			9. 프로그램 종료
	public void inputMenu() {
		int faultInputCount = 0;
		exit: // 라벨을 이용하여 반복문 종료
		while (true) {
			System.out.println("===== 도형 프로그램 =====");
			System.out.println("3. 삼각형");
			System.out.println("4. 사각형");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호 : ");
			String menuNum = sc.nextLine();
			switch (menuNum) {
			case "3":
				triangleMenu();
				faultInputCount = 0;
				break;
			case "4":
				squareMenu();
				faultInputCount = 0;
				break;
			case "9":
				System.out.println("프로그램을 종료합니다.");
				break exit;
			default:
				faultInputCount++;
				if (faultInputCount > 4) {
					System.out.println("입력 횟수(5회)를 초과하여 강제종료합니다.");
					break exit;
				}
				System.out.println("잘못된 번호입니다. 다시 입력하세요.");
				break;
			}
		}
	}

	public void triangleMenu() {

		exit: // 라벨을 이용하여 반복문 종료
		while (true) {
			System.out.println("===== 삼각형 =====");
			System.out.println("1. 삼각형 면적");
			System.out.println("2. 삼각형 색칠");
			System.out.println("3. 삼각형 정보");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			String menuNum = sc.nextLine();
			switch (menuNum) {
			case "1":
			case "2":
				inputSize(3, Integer.parseInt(menuNum));
				break;
			case "3":
				printInformation(3);
				break;
			case "9":
				break exit;
			default:
				System.out.println("잘못된 번호입니다. 다시 입력하세요.");
				break;
			}
		}
	}

	public void squareMenu() {
		exit: // 라벨을 이용하여 반복문 종료
		while (true) {
			System.out.println("===== 사각형 =====");
			System.out.println("1. 사각형 둘레");
			System.out.println("2. 사각형 면적");
			System.out.println("3. 사각형 색칠");
			System.out.println("4. 사각형 정보");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			String menuNum = sc.nextLine();
			switch (menuNum) {
			case "1":
			case "2":
			case "3":
				inputSize(4, Integer.parseInt(menuNum));
				break;
			case "4":
				printInformation(4);
				break;
			case "9":
				break exit;
			default:
				System.out.println("잘못된 번호입니다. 다시 입력하세요.");
				break;
			}
		}
	}

	public void inputSize(int type, int menuNum) {
		// 너비 높이를 받아 요청 처리 or 색깔 변경
		if ((type == 3 && menuNum == 2) || (type == 4 && menuNum == 3)) {
			System.out.print("색깔을 입력하세요 : ");
			String color = sc.nextLine();
			if (type == 3) {
				tc.paintColor(color);
			} else if (type == 4) {
				scr.paintColor(color);
			}
			System.out.println("색이 수정되었습니다.");
		} else {
			System.out.print("높이 : ");
			String heightStr = sc.nextLine();
			double height = Double.parseDouble(heightStr);
			System.out.print("너비 : ");
			String weightStr = sc.nextLine();
			double weight = Double.parseDouble(weightStr);

			if (type == 3) {
				System.out.println("삼각형 면적 : " + tc.calcArea(height, weight));

			} else if (type == 4 && menuNum == 1) {
				System.out.println("사각형 둘레 : " + scr.calcPerimeter(height, weight));

			} else if (type == 4 && menuNum == 2) {
				System.out.println("사각형 면적 : " + scr.calcArea(height, weight));
			}
		}
	}

	// 파라미터에 따라 삼각형/사각형 정보출력
	public void printInformation(int type) {
		if (type == 3) {
			System.out.println(tc.print());
		} else if (type == 4) {
			System.out.println(scr.print());
		}
	}
}
