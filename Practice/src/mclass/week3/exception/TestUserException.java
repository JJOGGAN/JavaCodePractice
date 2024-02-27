package mclass.week3.exception;

import java.util.Scanner;

public class TestUserException {
	public static void main(String[] args) {

		// view역할 - 문구를 넣는 곳
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int input = sc.nextInt();

		CheckEven ce = new CheckEven();
		try {
			int result = ce.printEvent(input);
			if (result == input) { //result == input 일 때, 정상작동이라고 간주
				// input = 3 일 경우, result에 값이 담기지 않음
				System.out.println(result + " : 정상입력");
			}
		} catch (EvenException e) {
			System.out.println("짝수가 아니잖음 ㅡㅡ");
			e.printStackTrace();
		}
	}
}
