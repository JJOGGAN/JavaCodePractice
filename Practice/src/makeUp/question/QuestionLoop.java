package makeUp.question;

import java.util.Scanner;

public class QuestionLoop {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		loop :
		while(true) {
			System.out.print("000 : ");
			int answer = sc.nextInt();
			switch (answer) {
			case 1:
				System.out.println("1");
				break;
			case 2:
				System.out.println("2");
				break;
			case 3:
				System.out.println("3");
				break loop;
			default:
				System.out.println("0");
				break;
			}
		}
	}

}
