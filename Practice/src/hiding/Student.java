package hiding;

public class Student {
	int studentID;
	private String studentName;
	int grade;
	String address;
	
	public String getStudentName() { //학생의 이름 반환
		return studentName;
	}

	public void setStudentName(String studentName) { //학생의 이름 대입
		this.studentName = studentName;
	}
}
