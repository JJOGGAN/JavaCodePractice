package classpart;

public class StudentTest2 {

	public static void main(String[] args) {
		Student studentA = new Student();
		studentA.studentName="안연수";
		
		Student studentB = new Student();
		studentB.studentName = "kimbada";
		
//		주소값이 출력됨
		System.out.println(studentA); //classpart.Student@4d591d15
		System.out.println(studentB); //classpart.Student@4aa8f0b4-
	}

}
