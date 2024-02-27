package week3.doit;

public class StudentTest {

	public static void main(String[] args) {
		Student stuLee = new Student(1001, "Lee");
		stuLee.addSubject("국어", 100);
		stuLee.addSubject("math", 50);
		
		Student stuKim = new Student(1002, "Kim");
		stuKim.addSubject("English", 80);
		stuKim.addSubject("math", 70);
		
		stuLee.showStudentInfo();
		System.out.println("=================");
		stuKim.showStudentInfo();
	}

}
