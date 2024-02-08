package inheritance.kh.mclass;

public class Run {

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		C c = new C();
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		a.method1();
		b.method1();
		c.method1();
	}

}
