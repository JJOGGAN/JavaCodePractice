package practice.array;

import java.util.Iterator;

public class TwoDimension2 {

	public static void main(String[] args) {
//		2차원 배열 선언
		int[][] arr = new int [2][3];	
//		출력
		for(int i = 0; i<arr.length;i++) {
			for(int j = 0; j<arr[i].length;j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println(arr.length);	//행의 길이
		System.out.println(arr[0].length); //열의 길이
	}

}
