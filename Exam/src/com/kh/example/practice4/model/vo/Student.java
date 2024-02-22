package com.kh.example.practice4.model.vo;

public class Student {
	// 초기화블럭을 이용해 각 필드 초기화 ??

	private static int grade;
	private int classroom;
	private String name;
	private double height;
	private char gender;

	public Student() {

	}
	


	public void information() {
		System.out.printf("학년 :%d  반 :%d 이름 : %s 키 : %f  성별 : %c", grade, classroom, name, height, gender);
	}


//	Getter Setter
	
	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public int getClassroom() {
		return classroom;
	}


	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}
	
	
	
	
}
