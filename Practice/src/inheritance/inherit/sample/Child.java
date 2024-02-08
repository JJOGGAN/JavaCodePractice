package inheritance.inherit.sample;

public class Child extends Parent {
	private int num=2;
	public Child() {
		//super(); 기본 생성자의 super 생략가능
		this(10);	//this와 super는 같이 사용 X
	}
	public Child(int a) {
		super();
		System.out.println("파라미터 int a");
	}
	public void out() {
		System.out.println("자식 클래스 out메소드");
	}
	
	@Override
	 public void display() { //부모와 똑같이 생긴 method
		System.out.println("==부모의 메소드 재정의==");
		System.out.println("num: "+num);
		System.out.println("super.num: "+super.num);
		super.display(); //Parent의 메소드를 오버라이딩하려면 super필요
	}
}
