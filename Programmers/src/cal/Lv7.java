package cal;

import java.util.Scanner;

public class Lv7 {
	
	public static void main(String[] args) {
		String[] id ={"joonas","baekjoon"};
		Scanner sc = new Scanner(System.in);
		
		for(int i =0; i <id.length;i++ ) {
			System.out.print(id[i]+"\t");
		}
		
		System.out.print("ID: ");
		String userID = sc.nextLine();
		
		
		
		for(int i =0; i <id.length;i++ ) {
			if (userID.equals(id[i])) {
				System.out.println(userID+"??!");
			}
		}
	}
}
