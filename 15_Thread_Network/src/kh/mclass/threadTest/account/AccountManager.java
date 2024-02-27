package kh.mclass.threadTest.account;

public class AccountManager extends Thread {
	private Account ac;
	private String threadName;

	public AccountManager() {
	}

	public AccountManager(String threadName) {

		this.threadName = threadName;
	}

	@Override
	public void run() {
		ac = new Account();
		ac.setBalance(1000);

		while (ac.getBalance() > 0) {
			System.out.println("현재 잔액 : " + ac.getBalance());
			// 출금할 돈을 랜덤으로 처리함 : 백원 단위로 함
			int money = new java.util.Random().nextInt(10) * 100;
			// import로 Random 호출해도 됨
			System.out.println(threadName + "이/가 출금할 돈 : " + money);
			ac.withDraw(money);

		}
	}

}
