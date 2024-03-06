package com.kh.practice.dimension;

import java.util.Random;

public class DimensionPractice {
	public void practice1() {

		String[][] arr = new String[3][3];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				String n = "(" + i + " , " + j + ")";
				arr[i][j] = n;
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public void practice4() {
		int[][] arrNum = new int[4][4];
		
		int sumTotal = 0;
		int row = arrNum.length-1; //행
		int column = arrNum.length-1; //열
		
		for (int i = 0; i < arrNum.length-1; i++) {
			for (int j = 0; j < arrNum[i].length-1; j++) {
				arrNum[i][j] = (int) (Math.random() * 10 + 1);
				arrNum[i][column] +=arrNum[i][j]; 
				arrNum[row][j] +=arrNum[i][j]; 
				arrNum[row][column] +=arrNum[i][j]*2; 
			}
		}
		
		//출력
		for (int i = 0; i < arrNum.length; i++) {
			for (int j = 0; j < arrNum[i].length; j++) {
				System.out.print(arrNum[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public void practice6() {
		String[][] strArr = new String[][] { { "이", "까", "왔", "앞", "힘" }, { "차", "지", "습", "으", "냅" },
				{ "원", "열", "니", "로", "시" }, { "배", "심", "다", "좀", "다" }, { "열", "히", "! ", "더", "!! " } };
		for (int i = 0; i < strArr.length; i++) {
			for (int j = 0; j < strArr[i].length; j++) {
				System.out.print(strArr[j][i]+" ");
			}
			System.out.println();
		}
	
	
	}
	 public void practice9(){
		 String studentName = "남나나";
		 
		 
	 }
	public static void main(String[] args) {
	}
}
