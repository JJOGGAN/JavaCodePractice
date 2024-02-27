package mclass.week3.collection;

public class TestStringAPI {
	public static void main(String[] args) {
		//String 미리 만들어둔 메소드
		//1. 기능에 맞는 이름 찾기
		//2. parameter argument 맞게 작성하기
		//3. return 자료형 확인해서 변수에 담기
		String str1 = "hello World";
		String str2 = "hello world";
		String str3 = "hello zorld";
		
		System.out.println("===charAt===");
		char ch = str1.charAt(4); //'o'
		System.out.println(ch);
		
		//compareTo() : ASCII 코드 값 비교
		System.out.println("===compareTo===");
		int compareInt1 = str1.compareTo(str3);
		int compareInt2 = str2.compareTo(str1);
		System.out.println(compareInt1); //-35
		System.out.println(compareInt2); //32
		
		System.out.println("hello world".compareTo("hello zorld")); //-3
		
		System.out.println("===concat===");
		System.out.println("a b c".concat("ABCD")); //a b cABCD
		System.out.println("?"+"이것까지 바꿔준다고?".concat("a b c")); 
		//?이것까지 바꿔준다고?a b c
		//.기준으로 양쪽 먼저 결함 후 +로 연결
		//값을 합하여 새로운 공간을 할당하고 그 구역의 주소값을 갖게 됨
		
		System.out.println("===equals===");
		System.out.println(str1.equals(str2)); //false
		System.out.println("===equalsIgnoreCase===");
		System.out.println(str1.equalsIgnoreCase(str2)); //true 대소문자 무시
		
		//replace
//		regex = regular expression 정규표현식
		System.out.println("===replace===");
		String result = str1.replace('o', 'x'); //hellx Wxrld
		System.out.println(result);
		String result2 = str1.replaceFirst("l", "m");//hemlo World
		System.out.println(result2); 
		result2 = str1.replaceFirst("Worl", "wor");//hemlo word
		System.out.println(result2); 
		
		//replaceAll
		result = str1.replaceAll("[a-z]", "ㅋ"); //ㅋㅋㅋㅋㅋ Wㅋㅋㅋㅋ
		//a~z까지의 값은 ㅋ로 바꿔라
		System.out.println(result);
		
		//subString
		System.out.println("===substring===");
		result = str1.substring(3); // lo World
		System.out.println(result);
		result = str1.substring(3,7); // lo W    3부터 6(7-1)까지 
		System.out.println(result);
		
		//split
		System.out.println("===split===");
		String[] arrStr = str1.split(" "); // 스페이스를 기준으로 값이 나눠짐
		for(int i = 0; i <arrStr.length;i++) {
			System.out.println(arrStr[i]);
		}
		System.out.println("====");
		String[] arrStr1 = str1.split("l"); //l을 기준으로 값이 나눠집 l은 안 들어감
		for(int i = 0; i <arrStr1.length;i++) {
			System.out.print(arrStr1[i]); //[he][][o Wor][d]
			if(i<arrStr1.length) {
				System.out.print(", ");
			}
		}
		
		//향상된 for문 : Index를 몰라도 될 땐 이거 쓰면 됨, 조건식 불가
		System.out.println("\n=====Enhanced for문=====");
		for (String string : arrStr1) {
			System.out.print("["+string+"]"); //[he][][o Wor][d]
		}
	}
}
