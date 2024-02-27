package doIt;

public class ControlStatementQuiz3 {
	/* 단보다 곱하는 수가 작거나 같을 경우까지만 출력 */
	public static void main(String[] args) {
		System.out.println("=======구구단 세로버전=========");
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (i<j) {
					break;
				}
				System.out.print(j + " * " + i + " = " + (j * i) + "    ");
			}
			System.out.println();
		}


	}

}
