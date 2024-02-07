package doIt;

/*구구단을 짝수단만 출력하라 continue사용
 * */

public class ControlStatementQuiz2 {
	public static void main(String[] args) {
		//TODO 세로 짝수 구구단
//		System.out.println("============짝수 구구단============ ");
//		for (int i = 1; i < 10; i++) {
//			for (int dan = 2; dan < 10; dan += 2) {
//				System.out.printf("%d * %d = %d\t", dan, i, (dan * i));
//			}
//			System.out.println();
//		}
		
		//TODO 짝수 구구단 continue사용
//		System.out.println("\n============짝수 구구단============ continue");
//		for (int dan = 1; dan < 10; dan++) {
//			if ((dan % 2) != 0) {
//				// System.out.println();
//				continue;
//			}
//			for (int i = 1; i < 10; i++) {
//				System.out.printf("%d * %d = %d\t", dan, i, (dan * i));
//			}
//			System.out.println();
//		}
		//TODO 세로 짝수 구구단 continue사용
		System.out.println("\n============짝수 구구단======세로버전====== continue");
		for (int i = 1; i < 10; i++) {
			for (int dan = 1; dan < 10; dan++) {
				if ((dan % 2) == 1) {
					continue;
				}
				System.out.printf("%d * %d = %d\t", dan, i, (dan * i));
			}
			System.out.println();
		}

	}
}
