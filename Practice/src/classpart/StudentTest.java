package classpart;

public class StudentTest {

	public static void main(String[] args) {
		Student studentA = new Student();
		studentA.studentName="안연수";
		System.out.println(studentA.getStudentName());
		
		Student studentB = new Student();
		studentB.studentName = "kimbada";
		System.out.println(studentB.getStudentName());
	}

}
