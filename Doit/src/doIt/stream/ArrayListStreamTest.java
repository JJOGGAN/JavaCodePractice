package doIt.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListStreamTest {
	public static void main(String[] args) {
		List<String> sList = new ArrayList<String>();
		sList.add("bb");
		sList.add("aa");
		sList.add("cc");
		
		Stream<String> streamA = sList.stream(); //스트림 생성
		streamA.forEach(s->System.out.print(s+" "));
		System.out.println();
		
		//스트림을 새로 생성해서 정렬하고 요소를 하나씩 꺼내어 출력
		sList.stream().sorted().forEach(s->System.out.print(s+" "));
		
		//원래 sort를 쓰려면 Comparator나 Comparable이 선행되어야함
		//컴퓨터는 정렬의 기준을 모르기 때문
		//지금은 String형이라서 자동으로 기준을 잡고 정렬해준 상태
	
		System.out.println(sList.stream().count()); //오류 발생 안 함
		System.out.println(sList.stream().count()); // 오류 발생 안 함
		System.out.println(streamA.count()); //오류 발생 
		//한 번 생성하고 사용한 스트림은 재사용 할 수 없다.
		//15행에서 streamA를 사용했기 때문에 27행에선 재사용할 수 없다.
		//다만 25,26행은 각각 다른 스트림으로 간주되어 오류가 발생하지 않는다.(new Stuent 같은거 )
	}
}
//bb aa cc 
//aa bb cc 3
//3
// java.lang.IllegalStateException: stream has already been operated upon or closed
