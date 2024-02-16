package mclass.week3.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComplexDataType {
	public static void main(String[] args) {
		// List<Map<String, Student>> listL = new ArrayList<Map<String,Student>>();
		// List 안의 Map 형태는 잘 사용하지 않음
		// WHY ?? TODO 11:30영상 재확인

		System.out.println("******* 여러 컬렉션 복합자료형 *******");

		// 가장 대표 자료형 - 바같쪽 생성(할당)됨
		List<Map<String, Student>> list = new ArrayList<Map<String, Student>>();
		// 안쪽 - 생성(할당)됨
		Map<String, Student> map = new HashMap<String, Student>();
		// 최종 내부 - 생성(할당)됨
		Student instance = new Student();

		// 최종내부 값 채우기
		instance.setId("ABC");
		instance.setId("Hong");
		// 밖 - 값 채우기
		map.put("1001", instance);
		// 가장 밖 - 값 채우기
		list.add(map);

		// 실습
		Map<String, List<Student>> comp1 = new HashMap<String, List<Student>>(); // Student에 값을 채우는게 최종 목표

		List<Student> comp2 = new ArrayList<Student>();

		Student comp3 = new Student();

		comp3.setId("second");
		comp3.setId("Kim");
		comp2.add(comp3);
		comp1.put("maclss", comp2);

		Student comp3_2 = new Student();
		comp3_2.setId("third");
		comp3_2.setId("333");
		comp3_2.setName("GuGu");
		comp3_2.setName("GuGu2");
		comp2.add(comp3_2);
		comp1.put("mClass", comp2);

		List<Student> kClass = new ArrayList<Student>();

		Student comp4 = new Student();

		comp4.setId("second");
		comp4.setId("Kim");
		kClass.add(comp4);
		comp1.put("kClass", kClass);

		Student comp4_2 = new Student();
		comp4_2.setId("third");
		comp4_2.setId("333");
		comp4_2.setName("GuGu");
		comp4_2.setName("GuGu2");
		kClass.add(comp4_2);
		comp1.put("kClass", kClass);

		System.out.println(comp1);
		// Map은 vo와 가장 비슷함
		/*
		 * ******* 여러 컬렉션 복합자료형 ******* 
		 * {kClass= 
		 * [Student [id=Kim, name=null,
		 * phone=null, age=0, attendance=0.0], 
		 * Student [id=333, name=GuGu2, phone=null,
		 * age=0, attendance=0.0]], 
		 * maclss= [Student [id=Kim, name=null, phone=null,
		 * age=0, attendance=0.0], Student [id=333, name=GuGu2, phone=null, age=0,
		 * attendance=0.0]], 
		 * mclss=
		 * [ Student [id=Kim, name=null, phone=null, age=0,
		 * attendance=0.0], Student [id=333, name=GuGu2, phone=null, age=0,
		 * attendance=0.0]] }
		 */

		System.out.println("\n********** 복합 자료형2 **********");
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("1-1", 123);
		mapObj.put("1-2", "hello");
		mapObj.put("1-3", " I am speaking potato");
		mapObj.put("1-4", comp2); // comp2 => List<Student>

		System.out.println(mapObj);
		/*
		 * ********** 복합 자료형2 ********** 
		 * {1-1=123, 
		 * 1-2=hello, 
		 * 1-3= I am speaking potato,
		 * 1-4= 
		 * [Student [id=Kim, name=null, phone=null, age=0, attendance=0.0], Student
		 * [id=333, name=GuGu2, phone=null, age=0, attendance=0.0]]}
		 */
	}
}
