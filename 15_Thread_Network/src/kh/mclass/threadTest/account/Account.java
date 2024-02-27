package kh.mclass.threadTest.account;

public class Account {
	private static int balance;
	// static 변수이므로 balance값 하나를 모든 객체가 공유함

	public static int getBalance() {// getter setter에도 기본적으로 static이 붙어서 생성됨
		return balance;
	}

	public static void setBalance(int balance) {
		Account.balance = balance;
	}

	public synchronized void withDraw(int money) {
		// synchronized를 특정부분이나 메소드에 줄 수 있다.
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 출금하는 메소드
		/* synchronized (this) */ { // synchronized로 관리할 대상을 적어주는 것 this = balance
			if (balance >= money) { // 여기서 일시정지 상태로 감
				System.out.println("출금 : " + money);
				balance -= money;
			} else {
				System.out.println("잔액부족");
			}
		}
	}

}
