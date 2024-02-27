package com.kh.example.practice4.run;

import com.kh.example.practice4.model.vo.Student;

public class Run {

	public static void main(String[] args) {
		Student student = new Student();
		
		student.setClassroom(2);
		student.setGrade(7);
		student.setGender('W');
		student.setHeight(155.5);
		student.setName("jjoggan");
		
		student.information();
	}

}
