package doIt;

import java.util.Scanner;

public class ControlStatementQuiz5 {
	/* 다이아몬드 만들기 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("트리 층수 : ");

		int f = sc.nextInt(); 
		for (int a = 1; a <= f; a++) {
			for (int i = a * 2; i < (f * 2); i++) {
				System.out.print(" ");
			}
			for (int s = 2*a-1; s > 0; s--) {
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
