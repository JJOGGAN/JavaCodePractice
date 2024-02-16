package mclass.week3.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestCollection2 {
	public static void main(String[] args) {

		// banana lemon melon 추가
		// 2번 항목을 삭제하고
		// display
		List<String> fruitList = new ArrayList<>(); // 담을 공간 확보

		// 등록
		System.out.println("과일 등록");
		fruitList.add("banana"); // 글등록
		fruitList.add("lemon"); // 글 등록
		fruitList.add("melon"); // 글 등록
		// 조회
		System.out.println("글목록조회");
		for (String fruit : fruitList) {
			System.out.println(fruit);
		}
		// 2번 항목 보기
		System.out.println("2번째 글 확인");
		System.out.println(fruitList.get(1));
		// 삭제
//		fruitList.remove(1); //index로 값 삭제
		fruitList.remove("banana");
//		fruitList.removeAll(fruitList);
		// 조회
		System.out.println("글목록조회");
		for (String fruit : fruitList) {
			System.out.println(fruit);
		}
		System.out.println("=====Iterator =====");

		// Iterator()
		// 형변환 - 자동, 강제
		// 내가 가지고 있던 값을 유지한채로 형변환 -> 다른 메소드를 사용하고 싶기 때문에!
		Iterator<String> fruitIterator = fruitList.iterator(); // iterator -> Iter로 형변환
		System.out.println(fruitIterator); // 모양이 iterator로 바뀜
		while (fruitIterator.hasNext()) {
			String fruit = fruitIterator.next(); // String return
			System.out.println(fruit);
		} // enhanced for문과 동일함

		System.out.println("=====Map=====");

		// Map 활용
		// b-1 : banana, b-2: lemon, a-1:potato a-2: banana '상품코드-상품명' 추가
		// "b-2" 상품 재고가 없음으로 삭제요청
		// 모든 상품을 상품코드-상품 display
		Map<String, String> fruitMap = new HashMap<String, String>();
		// Map은 value 출력 시 순서가 다름
		// 등록
		System.out.println("\n==새상품 등록==");
		fruitMap.put("a-1", "potato");
		fruitMap.put("b-1", "banana");
		fruitMap.put("a-2", "banana");
		fruitMap.put("b-2", "lemon");
		// 출력
		System.out.println("\n==상품목록 출력==");
		// System.out.println(fruitMap.entrySet()); 그냥 출력 내가 원하는 형태로 출력하긴 어려움
		Set<String> fruitSet = fruitMap.keySet(); // Map -> Set 자료형 변환
		// 상품코드만 담을 Set 만들기 모든 key를 객체에 담아 return
		System.out.println("\n----key return----");
		for (String fruitKey : fruitSet) {
			System.out.println(fruitKey + " - " + fruitMap.get(fruitKey));
		}
//		TODO iterator로 바꿔서 출력해보기
		System.out.println("-----Iterator ver-----");
		Iterator<String> fruitIter = fruitMap.keySet().iterator();

		// 삭제 요청
		System.out.println("b-2 상품 내용 보기");
		System.out.println(fruitMap.get("b-2"));
		System.out.println("----확인----");
		// 삭제
		System.out.println("b-2 상품 - 삭제");
		fruitMap.remove("b-2");
		// 출력
		System.out.println("\n==삭제 후 상품목록==");
		// System.out.println(fruitMap.entrySet());
		for (String fruitKey : fruitSet) {
			System.out.println(fruitKey + " - " + fruitMap.get(fruitKey));
		}
		System.out.println("====Map===");
		System.out.println(fruitMap); // {a-1=potato, b-1=banana, a-2=banana}
		System.out.println("====List===");
		System.out.println(fruitList); // [banana, melon]
		// 참조 자료형이라 toString메소드를 사용하여 출력됨 그래서 저렇게 나옴

//		TODO 14일 5교시 code 작성 후 따라해보기


	}
}
