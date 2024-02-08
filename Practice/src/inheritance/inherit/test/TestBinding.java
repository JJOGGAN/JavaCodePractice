package inheritance.inherit.test;

import inheritance.inherit.sample.Child;
import inheritance.inherit.sample.Parent;

public class TestBinding {
	public static void main(String[] args) {
		// Binding (동적, 정적)
		// 컴파일 시, 정적 바인딩 -> .class가 만들어지고 아직 main을 실행하기 전
		// 실행 시, 동적 바인딩 -> overriding이 되면서 Child의 method 실행
		// 다형성일 때 동적 바인딩의 움직임 알기 쉬움
		Parent p = new Parent();
		p.display();	//Parent의 display 호출
		System.out.println("===정적/동적 바인딩===");
		
		//Up Casting
		Parent bind = new Child(); //beause 다형성
		bind.display(); //Child의 display 호출 Override 했으니까! -> 선언부 꼭 확인하기
						//Override 안 했으면 Parent의 display 호출 -> 선언부 꼭 확인하기
		
		//Down Casting 강제형변환 부모가 강제적으로 자식 클래스로 형변환
		//bind.out; error 강제로 접근은 가능
		((Child)bind).out();
		
		Child c = new Child();
		//Child error = new Parent(); error 자식은 부모를 품을 수 없다.
	}
}
