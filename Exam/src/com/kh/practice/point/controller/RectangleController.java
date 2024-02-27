package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Rectangle;

public class RectangleController {
	private Rectangle r = new Rectangle();

	public String calcArea(int x, int y, int height, int width) {
		// TODO 넓이 계산 result ...? point에 제대로 들어갔는지 확인
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		int area = height * width;
		String result = Integer.toString(area);
		return r.toString() + " / " + result;
	}

	public String calcPerimeter(int x, int y, int height, int width) {
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		int perimeter = height * width * 2;
		String result = Integer.toString(perimeter);
		return r.toString() + " / " + result;
	}

}
