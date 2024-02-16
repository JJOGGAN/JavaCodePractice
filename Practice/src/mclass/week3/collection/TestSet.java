package mclass.week3.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class TestSet {
	public static void main(String[] args) {
		System.out.println("==set 중요 + Map과 함께==");
		System.out.println("== 중복값 X , index X ==");
		// String형 Set 생성
		Set<String> hs = new HashSet<String>();
		hs.add("java");
		hs.add("oracle");
		hs.add("java");
		hs.add("html"); // 중복값 X , 순서 X
		System.out.println(hs); // 순서 없음
		// 특정 값 확인하고플 때 쓰는 메서드 X
		// 한 개씩 뽑아서 보려면 enhanced for문을 써야함
		for (String e : hs) {
			System.out.println(e);
//			switch (e) {		
//			case "java":		//java값일 때 출력멈춤
//				System.out.println(e);
//				break;
//			}
		}
		System.out.println("===TreSet===");
		Set<String> ss = new TreeSet<String>();
		ss.add("java");
		ss.add("oracle");
		ss.add("html");
		for (String e : ss) {
			System.out.println(e);
		}
		System.out.println("==Map (key,value) 1. key는 Set형태 + String==");
		Map<String, Integer>map1 = new HashMap<String, Integer>();
		//key에는 String만 넣는다고 보면 됩니다.
		//value는 자료형 제한 없음
		//hashmap vs hashtable  ->성능차이
		//map1.put(null, null)
	}
}
