package inheritance.inherit.sample;

public abstract class Person {
	private String name;
	public Person() {}
	
	public Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void out();
	//자식 클래스들의 out의 강제화 시킴
	//어떻게 인사할 진 너희한테 맡기겠어
}
