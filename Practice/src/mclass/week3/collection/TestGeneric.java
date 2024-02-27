package mclass.week3.collection;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {

	public static void main(String[] args) {
// 		!! 다양한 타입의 객체를 다루는 
//		!! 메소드나 클래스의 타입을 
//		!! 미리 명시해  <선언해 줌으로써>
//			줌으로써 컴파일 시 타입을 체크할 수 있도록 하고,
//		!! 형변환을 하는 번거로움 없이 사용하게 해주는 것으로 
//			배열이나 이후 배울 컬렉션 사용 시
//		!! 데이터 타입의 안정성을 높일 수 있다
//		overloading의 한계를 극복할 수 있다 - 새로운 자료형에 대처하지 못함
		
		
		//List list = new ArrayList(); 
		/* 자료형이 명시되어 있지 않아 의도하지 않은 자료형이 들어갈 수 있는 위험이 있음 */
		
		//List<E> list = new ArrayList<E>(); //<E>가 제너릭
		List<String> list = new ArrayList<String>();
		//list.add(123); //error
		list.add("123");
		
		
		
	}
}
