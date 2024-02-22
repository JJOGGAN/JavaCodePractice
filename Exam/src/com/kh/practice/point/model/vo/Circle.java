package com.kh.practice.point.model.vo;

public class Circle extends Point{
	private int radius;

	public Circle() {
		super();
	}

	public Circle(int x, int y,int radius) {
		//TODO Point 상속 받아서 넣어야하나?
		super(x,y);
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {

		return  getX()+", "+getY() + ", "+ radius ;
	}
	
	
}
