package inheritance.inherit.test;

import inheritance.inherit.sample.Child;
import inheritance.inherit.sample.Parent;

public class TestOverriding {
	public static void main(String[] args) {
	Parent p = new Parent();
	Child c = new Child();
	p.display(); // display method에 public 접근제한자가 있어야 연결 됨
	c.display();
	c.out();
}
}
