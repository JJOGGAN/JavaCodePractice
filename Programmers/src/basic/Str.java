package basic;

import java.util.Scanner;

public class Str {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        if (1<=a.length()&&a.length()<=1000000) {
        	System.out.println(a);
		}
	}
}
