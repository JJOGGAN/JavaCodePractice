package week3.doit;

import java.util.ArrayList;

public class Student {
	int studentID;
	String studentName;
	ArrayList<Subject> subjectList; //

	public Student(int studentID, String studentName) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		subjectList = new ArrayList<Subject>();
	}

	public void addSubject(String name, int score) {
		Subject subject = new Subject();
		subject.setName(name);
		subject.setScorePoint(score);
		subjectList.add(subject);
	}

	public void showStudentInfo() {
		int total = 0;
		for (Subject s : subjectList) {
			total = s.getScorePoint();
			System.out.println(studentName + "학생의" + s.getName() + "과목 성적은 " + s.getScorePoint() + "입니다.");
		}
	}

}
