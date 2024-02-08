package inheritance.kh.mclass;

public class B {
	private int num1;
	private String str1;
	public void method1() {
		System.out.println("method1 B");
	}
	public void method2() {
		System.out.println("method2");
	}
	@Override
	public String toString() {
		return "B [num1=" + num1 + ", str1=" + str1 + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
