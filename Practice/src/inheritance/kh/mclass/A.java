package inheritance.kh.mclass;

public class A {
	private int num1;
	protected void method1() {
		System.out.println("method A" + 1);
	}

	public String toString() {
		return "A [num1=" + num1 + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
