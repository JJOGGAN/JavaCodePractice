package com.kh.example.practice3.run;

import com.kh.example.practice3.model.vo.Circle;

public class Run {

	public static void main(String[] args) {
		Circle circle = new Circle();
		circle.getAreaOfCircle();	//원 넓이 출력
		circle.getSizeOfCircle();	//원 둘레
		
		circle.incrementRadius();	//반지름 1증가
		circle.incrementRadius();	//1 증가 (반지름이 2일 경우 넓이와 둘레 값이 같음)
		
		circle.getAreaOfCircle();	//재출력
		circle.getSizeOfCircle();
	}

}
