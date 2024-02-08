package inheritance.inherit.sample;

import inheritance.kh.mclass.B;

public interface InterfaceSample {
	public final int MAX_COUNT = 10;

	void method1();

	void method2();

	void method3();

	void method4();

	// abstract 없이 선언 가능!
	// 해당 규격을 공통적으로 강제화할 때 abstract을 사용
	// 모든 method가 abstract을 사용할 때 interface 사용
	// class들의 규칙이 될 것
	//public도 생략됨 무조건 public으로 설정되기 때문
}
