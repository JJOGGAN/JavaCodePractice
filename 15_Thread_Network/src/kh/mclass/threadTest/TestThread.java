package kh.mclass.threadTest;

public class TestThread {
public static void main(String[] args) {
	System.out.println("Main Thread Start");
	
	//새로운 일꾼
	ThreadA ta= new ThreadA();
	ta.start(); 
	//start => 서브 스레드야 일을 시작하렴 run호출
	//run 은 얘가 일을 시작할 수 있을 때 실행됨
	ta.setPriority(10);
	
	
//	ta.method1(); // main thread 가 하는 일
//	Runnable로 작성
//	Runnable엔 start가 없음 
//	'잊지마 run 작성해야해'라는 것을 강조하기 위한 것일 뿐이다.
//	쓰레드에 넣어줘야함
//  Thread야 ThreadB를 줄테니 쓰레드로 써주렴
	Thread tb= new Thread(new ThreadB());
	tb.start();
	tb.setPriority(1);
	
	System.out.println("Main Thread End");
}
}
