package inheritance.inherit.sample;

import inheritance.kh.mclass.B;

public class Student extends Person implements InterfaceSample{
//	inplement로 interface를 받아 왔으니 미완성본을 가져온 것이다.
//	나는 아직 완선된 클래스가 아니니 얼른 fix해라
//	F2로 quick fix 이용해서 add(@#$##$)눌러서 기본 메소드 자동으로 생성
	private String subject;
//생성순서 생성자 toString getter setter
	public Student() {}

	public Student(String subject) {
		super();
		this.subject = subject;
	}

	public Student(String subject,String name) {
		super(name);//name을 가지고 Person을 자기러가는
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Student [subject=" + subject + "]";
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public void out() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method3() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method4() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}


}
