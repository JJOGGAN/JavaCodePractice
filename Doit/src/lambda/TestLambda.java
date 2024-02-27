package lambda;

interface PrintString{
	void showString(String str);
}


public class TestLambda {
	public static void main(String[] args) {
		PrintString lambdaStr = s->System.out.println(s);
		lambdaStr.showString("람다 1");
		showMyString(lambdaStr); //람다식을 대입한 변수 전달
		
		PrintString reStr = returnString();
		reStr.showString("hello");
	
	}
	
	public static void showMyString (PrintString p) { //파라미터를 인터페이스 형식으로 받음
		p.showString("Hello lambda 2"); //인터페이스를 재정의 한 것이라고 보면 될 듯
	}
	
	public static PrintString returnString() {
		 return s -> System.out.println(s+"world");
	}
	// public void showString (s){System.out.println(s+"world");} 와 같다고 보면 됨
}
