package practice;

public class Array0206 {

	public static void main(String[] args) {
		int[] arrName = new int[5];
		for (int i = 0; i < arrName.length; i++) {
			arrName[i] = i + 1;
			System.out.print(arrName[i] + " , ");
		}
		System.out.println();

		System.out.println("===, 없애기(for문)==");
		for (int i = 0; i < arrName.length; i++) {
			System.out.print(arrName[i]);

			if (i != arrName.length - 1) { // != 대신 < 사용가능
				System.out.print(" , ");
			}
		}
		System.out.println("\n\n===또 다른 표현===");
		for (int i = 0; i < arrName.length; i++) {
			System.out.print(arrName[i]);

			if (i == arrName.length - 1) {
				break;
			}
			System.out.print(" , ");
		}

		System.out.println("\n\n===while문===");
		int count = 0;
		while (true) {
			System.out.print(arrName[count]);

			count++;
			if (count == arrName.length) {
				break;
			}
			System.out.print(" , ");
		}

		System.out.println("\n===2중 반복문===");
		int[][] arr = new int[5][3];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = (i + 1) * 10 + j + 1;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
