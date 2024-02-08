package inheritance.inherit.run;

import inheritance.inherit.sample.InterfaceSample;
import inheritance.inherit.sample.Person;
import inheritance.inherit.sample.Professor;
import inheritance.inherit.sample.Student;

public class TestAbstract {
	public static void main(String[] args) {
		Student s1 = new Student("java");
		s1.out();
		Student s2 = new Student("java", "서재원");
		s2.out();

		Professor p1 = new Professor("컴공");
		p1.out();
		Professor p2 = new Professor("컴공", "닥터");
		p2.out();

//		InterfaceSample interface1 = new InterfaceSample();
		
		Person person1 = new Person() {

			 @Override  
			public void out() {
				System.out.println("abstract class일 경우 new ()하면 지금처럼 구체적으로 적으라고 함");
			}
		};
		person1.out();
	}
}
