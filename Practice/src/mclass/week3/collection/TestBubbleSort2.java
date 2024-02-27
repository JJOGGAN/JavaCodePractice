package mclass.week3.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestBubbleSort2 {

	public static void main(String[] args) {
		
//		Integer배열 버블정렬
		Integer[] arrInt = new Integer[] {5,1,3,9,6,3,8,7};
		
		for(int i = 0 ; i<arrInt.length-1;i++) {
			for(int j = 0; j<arrInt.length-i-1;j++) {
				if(arrInt[j] >arrInt[j+1]) {
					int temp = arrInt[j];
					arrInt[j] =arrInt[j+1];
					arrInt[j+1] = temp;
				}
			}
		}
		System.out.print("[");
		for(int i = 0 ; i<arrInt.length;i++) {
			System.out.print(arrInt[i]+", ");
		}
		System.out.println("]\n");
		
//		String을 char로 변환하여 버블정렬		
		String[] arrStr = new String[] {"A","B","C","D"};
		for(int i = 0 ; i<arrStr.length-1;i++) {
			for(int j = 0; j<arrStr.length-i-1;j++) {
				char temp1 = arrStr[i].charAt(0);
				char temp2 = arrStr[i+1].charAt(0);
				if(temp1 > temp2) {
					arrStr[j] = String.valueOf(temp2);
					arrStr[j+1] = String.valueOf(temp1);
				}
			}
		}
		System.out.print("[");
		for(int i = 0 ; i<arrStr.length;i++) {
			System.out.print(arrStr[i]+", ");
		}
		System.out.println("]\n");
		
//		char 정렬
		String str = "akBdienSLWOQ";
		char[] charArr = str.toCharArray(); //String to char Array
		Arrays.sort(charArr);  // 알파벳순 정렬
		String result = String.valueOf(charArr); // 또는 new String(charArr);
		System.out.println(result);
	}
}
