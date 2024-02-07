package constructor;

public class PersonTest {
	public static void main(String[] args) {
		Person person1 = new Person();	//기본 생성자 호출
		person1.name = "A";
		person1.weight = 85.5F;
		person1.height = 180.5F;
		
//		인스턴스 초기화와 동시에 클래스 생성
		Person person2 = new Person("B", 75.5F, 160.0F); 
		
		
	}

}
