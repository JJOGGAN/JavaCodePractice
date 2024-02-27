package mclass.week3.collection;

import java.util.Scanner;

public class TestBubbleSort {
	public static void main(String[] args) {
		// 버블정렬
		//Integer[] arr = new Integer[] { 3, 5, 2, 7, 1, 4, 6 }; 
		
		Double[] arr=  new Double[] {9.1,7.4,7.3,5.0,1.1};

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				// if(arr[j] < arr[j-1]) //내림차순
				if (arr[j] > arr[j + 1]) { // 오름차순
					// swap
					//int temp = arr[j];
					double temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			System.out.print((i+1)+"차 : ");
			printArray(arr);
			//new TestBublleSort().printArr(arr); 로 호출가능(static을 안 붙였을 때)
			//사용빈도에 따라 static method, class method로 사용할지 정하면 됨
			//static method : 여러 class에 광범위적으로 사용될 때
			//class method : 사용 빈도가 적을 때

		}
		System.out.println("=====버블정렬 후=====");
		printArray(arr);

		System.out.println();
		int[] arrInt = new int[] { 3, 2, 5, 8, 1 };
		int temp1 = arrInt[0];
		arrInt[0] = arrInt[1];
		arrInt[1] = temp1;
		for (int i = 0; i < arrInt.length; i++) {
			System.out.print(arrInt[i] + " ,");
		}

		Scanner sc= new Scanner(System.in);
		System.out.println("정수 두개를 띄워쓰기와 함께 입력하세요.");
		int a= sc.nextInt();
		int b = sc.nextInt();
		System.out.println("정수 하나를 입력하세요.");
		int c = sc.nextInt();
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
	}
	//static 안 적으면 오류남 main이 static영역에 공간을 차지하고 있기 때문에 method도 static이 있어야함
	//Object로 받아서 자료형에 상관없이 다 받을 수 있음
	//Object로 받았기 때문에 참조자료형으로 생성해야함 -> int가 아닌 Integer로 생성해야함
	public static void printArray(Object[] objectArr) {
		System.out.print("[");
		for (int i = 0; i < objectArr.length; i++) {
			System.out.print(objectArr[i] + ", ");
		}
		System.out.println("]");
	}
	

	
}
