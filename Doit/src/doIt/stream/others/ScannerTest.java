package doIt.stream.others;

import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("name: ");
		String name = sc.nextLine();
		System.out.println("job: ");
		String job = sc.nextLine();
		System.out.println("사번: ");
		int num = sc.nextInt();
	}

}
