package lambda;

public class StringConcatlmpl implements StringConcat {

	//추상메소드 재정의
	@Override
	public void makeString(String s1, String s2) {
		System.out.println(s1 +", "+s2);
	}
	
}
