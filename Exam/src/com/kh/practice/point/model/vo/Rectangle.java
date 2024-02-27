package com.kh.practice.point.model.vo;

public class Rectangle extends Point {
	private int width;
	private int height;

	public Rectangle() {
		super();
	}

	public Rectangle(int x, int y, int width, int height) {
		// TODO 상속할 때 super에 넣으면 되나...?
		super(x, y);
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return getX() + " , " + getY() + " " + width + " " + height;
	}

}
