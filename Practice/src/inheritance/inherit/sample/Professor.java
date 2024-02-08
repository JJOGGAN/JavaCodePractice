package inheritance.inherit.sample;

public class Professor extends Person{
	private String major;

	public Professor() {}

	public Professor(String major) {
		super();
		this.major = major;
	}

	public Professor(String major,String name) {
		super(name);
		this.major = major;
	}

	@Override
	public String toString() {
		return "Professor [major=" + major + "]";
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	public void out(int q) {
		System.out.println("저는 "+getName()+"교수입니다.");
		System.out.println(major+"를 전공하고 있습니다.");
	}
	@Override
	public void out() {	
		//애초에 정의되지 않은 것을 선언한 것이라 오버라이딩과 표식이 조금 다름
		
	}
	
}
