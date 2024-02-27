package kh.mclass.threadTest.cake;

public class Consumer implements Runnable{
private Buffer buffer;

	public Consumer(Buffer buffer) {
	this.buffer = buffer;
}

	@Override
	public void run() {
		for(int i = 0 ; i < 10 ; i ++) {
			int data = buffer.get();
			System.out.println("소비자: "+i+"번 케익을 구매하였습니다.");
			try {
				Thread.sleep((int)(Math.random()*100)); //Math.random은 소수값
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
