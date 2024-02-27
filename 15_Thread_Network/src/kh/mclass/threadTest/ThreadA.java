package kh.mclass.threadTest;

public class ThreadA extends Thread {
	// 1번 방법 extends Thread 로 호출
	// 서브 스레드를 독립적으로 실행시키려면
	// run을 호출해야해요

	@Override
	public void run() { // 서브 스레드가 독립적으로 움직이는 곳 run!!
		System.out.println("ThreadA가 독립적으로 하는 일");

		for (int i = 2; i < 4; i++) {
			System.out.println("=====" + i + "단 =====");
			for (int j = 1; j < 9; j++) {
				System.out.println(i + " * " + j + " = " + (i + j));
//				try {
//					Thread.sleep(10); 
//					// 1000 = 1 sec
//					// Thread.sleep(1000); = "쓰레드는 1초 쉬고 싶어요"
//				} catch (Exception e) {
//					System.out.println("오류났어요");
//				}
			}
			System.out.println();
		}
//		List String
	}

	public void method1() {
		System.out.println("ThreadA method1 ()");
	}
}
