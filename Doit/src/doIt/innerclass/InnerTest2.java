package doIt.innerclass;


class OutClass2 {
	private int num = 10;
	private static int sNum = 20;

	static class InstaticClass {
		int inNum = 100;
		static int sInNum = 200;

		void inTest() {
			// num += 10;
			System.out.println("InstaticClass inNum " + inNum + "(내부 클래스의 인스턴스 변수 사용)");
			System.out.println("InstaticClass sInNum " + sInNum + "(내부 클래스의 정적 변수 사용)");
			System.out.println("OutClass2 sNum " + sNum + "(외부 클래스의 정적 변수 사용)");
		}

		// static int sInNum = 200;
		static void sTest() {
			System.out.println("OutClass2 sNum = " + sNum + " 외부 클래스의 정적 변수 사용");
			System.out.println("InstaticClass sInNum = " + sInNum + " 내부 클래스의 정적 변수 사용");
		}
	}

}

public class InnerTest2 {
	public static void main(String[] args) {
		OutClass2.InstaticClass sInClass =new OutClass2.InstaticClass();
		System.out.println("정적 내부 클래스 일반 메서드 호출");
		sInClass.inTest();
	}

}
