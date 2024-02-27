package kh.mclass.threadTest;

public class ThreadB implements Runnable{
	//2번 방법 implements Runnable 로 호출
@Override
public void run() {
	System.out.println("ThreadB가 독립적으로 하는 일");
	
	for(int i =1  ; i <5 ;i++) {
		System.out.println("=====B "+i+"단 =====");
		for(int j = 1 ; j<i ; j++) {
			System.out.print("*");
		}
		System.out.println();
	}
	
}

}
