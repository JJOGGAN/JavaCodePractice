package lambda;

public class TestStringConcat {
	public static void main(String[] args) {
		
	String s1 ="Hello";
	String s2 ="World";
	StringConcatlmpl concat1 = new StringConcatlmpl();
	concat1.makeString(s1, s2);
	
	StringConcat concat2 = (s,v) -> System.out.println("lambda : "+s+" & "+v);
	concat2.makeString(s1, s2);
	
	//interface를 class에서 재정의 하지 않고 바로 호출
	//람다식을 사용 함으로써 보다 간결해짐
	}
}
