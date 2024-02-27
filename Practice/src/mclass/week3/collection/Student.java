package mclass.week3.collection;

public /* abstract */ class Student {
	//학생 - 개념 = Object = class = Type
	
	private String id;
	private String name;
	private String phone;
	private int age;
	private double attendance;
	
	//Getter / Setter  게터,세터
	//각 원하는 필드의 메서드 생성
	//생성할 위치에 커서
	//우클릭 - source - Generate Getter and Setter
	//getter = 읽기
	//setter = 쓰기
	
	public String getId() {//id 읽기는 가능하지만 (public)
		return id;
	}

	public void setId(String id) { //id 쓰기는 못하게 할게(private)
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	private void setAge(int age) {
		this.age = age;
	}

	public double getAttendance() {
		return attendance;
	}

	public void setAttendance(double attendance) {
		this.attendance = attendance;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", phone=" + phone + ", age=" + age + ", attendance="
				+ attendance + "]";
	}
	

	/* abstract void exam() ; */
//	{
//		System.out.println("평가 잘 보세요");
//		
//		System.out.println("점수는 ..");
//	}
}
