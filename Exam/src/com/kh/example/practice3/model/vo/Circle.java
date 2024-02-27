package com.kh.example.practice3.model.vo;

public class Circle {
	private static final double PI = 3.14;
	private static int radius = 1;

	public Circle() {
	}

	public void incrementRadius() {
		radius++; // 반지름 1씩 증가
	}

	public void getAreaOfCircle() { // 원 넓이
		double result = PI * radius * radius;
		System.out.println("원의 넓이 : "+result);
	}

	public void getSizeOfCircle() {	//원 둘레
		double result = PI * radius * 2;
		System.out.println("원의 둘레 : "+result);
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	
	
}
