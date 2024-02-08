package inheritance.inherit.run;

import java.util.ArrayList;
import java.util.LinkedList;

public class TestInterface {
	public static void main(String[] args) {
//		int[] arr = new int [4]; 와 유사
		  //		자료형	변수명
		ArrayList<Integer> intList = new ArrayList<Integer>();
		ArrayList<String> strList = new ArrayList<String>();
//		List<Integer> intList2 = new ArrayList<Integer>();  자주 사용하게 될 것이다..
//		List<String> strList2 = new ArrayList<String>();    다형성!!!!
		LinkedList<String> strLink = new LinkedList<String>();
		
		intList.add(3);
		intList.add(4);
		intList.add(5);
		System.out.println("size : "+intList.size());
		intList.add(6);
		intList.add(6);
		System.out.println("size : "+intList.size());
		intList.remove(2);
		System.out.println("size : "+intList.size());
		System.out.println(intList);
		
		strList.add("홍길동");
		strList.add("고길동");
		strList.add("둘리");
		System.out.println("size : "+strList.size());
		System.out.println("strList : "+strList);
		
//		size : 3
//		size : 5
//		size : 4
//		[3, 4, 6, 6]
//		size : 3
//		strList : [홍길동, 고길동, 둘리]
	}
}
