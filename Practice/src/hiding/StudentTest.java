package hiding;

public class StudentTest {

	public static void main(String[] args) {
		Student studentA = new Student();
		// studentA.studentName="안연수";  오류 발생
		studentA.setStudentName("감자");
		System.out.println(studentA.getStudentName());
	}

}
