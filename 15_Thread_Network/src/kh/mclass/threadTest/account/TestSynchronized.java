package kh.mclass.threadTest.account;

public class TestSynchronized {
	public static void main(String[] args) {
		Thread t1 = new AccountManager("ATM");  //ac와 threadName에 ATM가 들어감
		Thread t2 = new AccountManager("인터넷 뱅킹");
		Thread t3 = new AccountManager("모바일 앱");
		t1.start();
		t2.start();
		t3.start();
		
		/*balance는 static 변수이므로 
		 * t1,t2,t3는 하나의 static변수 balance의 값을 공유함
		 * ex) t1에서 300출금
		 * t2에서 보면 700원 남음
		 * */
//		sleep에 들어간 순서대로 깨어나는 것이 아님
	}
}
