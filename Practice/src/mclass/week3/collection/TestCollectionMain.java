package mclass.week3.collection;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestCollectionMain {
	public static void main(String[] args) {
		List<String> strList = new LinkedList<String>(); //다형성
		strList.add("A");
		strList.add("B");
		strList.add("C");
		strList.add("D");
		strList.add("!@");
		
		System.out.println(strList.get(2)); //C
		System.out.println(strList.remove(1)); //값을 리턴해주고 삭제함
		System.out.println(strList); //[A, C, D, !@]
		System.out.println(strList.isEmpty()); //false
		
		System.out.println("===정렬 전===");
		System.out.println(strList);
		
		System.out.println("==========");
//		System.out.println(strList.sort(null));
		
		System.out.println("===정렬 후===");
		Collections.sort(strList); //정렬 전으로 되돌릴 수 없다.
		System.out.println(strList);
		
		
		strList.clear(); //배열 삭제
		System.out.println(strList.isEmpty()); // true
	}
}
