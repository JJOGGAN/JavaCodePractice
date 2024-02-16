package mclass.week3.collection;

public class TestStringBuffer {
	public static void main(String[] args) {
		// StringBuffer sbf = "스트링버퍼값";
		StringBuffer sbf = new StringBuffer("스트링버퍼값");
		String str1 = new String("스트링객체 만들어서 비교 == 안 됨 .equals");

		String immutable1 = "aaa";
		immutable1 = "bbb";
		// heap에 String 방(aaa)이 생기고 그 주소값을 immutable1에 넣음
		//(bbb)방을 새로 만들어서 그 주소값을 immutable1에 넣음
		//영역의 크기를 바꿀 수 없기 때문에 String은 불변이다
		
		sbf.append("기존 문자를 가변적으로 바꿀 수 있기 때문에 추가하는 append메소드가 제공됨");

	}
}
