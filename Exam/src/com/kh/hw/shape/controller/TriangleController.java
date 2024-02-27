package com.kh.hw.shape.controller;

import com.kh.hw.shape.model.vo.Shape;

public class TriangleController {
	private Shape s = new Shape();
	
	//받은 파라미터를 초기화 시킨 후 계산결과 반환
	public double calcArea(double height, double width) {
		s.setHeight(height);
		s.setWidth(width);
		double result = width * height / 2;
		return result;
	}

	// color 값 변경
	public void paintColor(String color) {
		s.setColor(color);
	}
	
	//Shape의 필드 반환
	public String print() {
		// TODO 어떤 모양인지 반환값에 합쳐 반환??
		String result = "삼각형" + s.information();
		return result;
	}
}
