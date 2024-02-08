package inheritance.kh.mclass;

public class C extends A{ //C가 A를 상속받는다
//	private int num1;
//	public void method1() {
//		System.out.println("method1");
//	}
	//A class에 있는 자료를 포함하여 새성
	private String str;
	public void method3() {
		System.out.println("method3");
	}
	@Override
	public String toString() {
		return "C [str=" + str + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}
	@Override //재정의에 대한 제약을 위해서도 작성하는 것이 좋음
	public void method1() {
		System.out.println("C가 다시 재정의 함 method"+1);
	}
}
