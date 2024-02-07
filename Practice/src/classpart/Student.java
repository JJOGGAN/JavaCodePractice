package classpart;

public class Student {
	//Field
	int studentID;
	String studentName;
	int grade;
	String address;
	
	public void showStudentInfo() {	//이름 주소 출력
		System.out.println(studentName +" , "+address);
	}

	public String getStudentName() { //학생의 이름 반환
		return studentName;
	}

	public void setStudentName(String studentName) { //학생의 이름 대입
		this.studentName = studentName;
	}
	
}
