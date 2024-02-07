package doIt;

import java.util.Scanner;

public class ControlStatementQuiz4 {
	/* 별 트리 만들기 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("트리 층수 : ");

		int f = sc.nextInt(); 
		for (int a = 1; a <= f; a++) {
			for (int i = a * 2; i < (f * 2); i++) {
				System.out.print(" ");
			}
			for (int s = 0; s < a*2-1; s++) {
				System.out.print("*"); 
				if (s == a*2+1) {
					break;
				}
				System.out.print(" ");
			}
			System.out.println();

		}
		
	}

}
