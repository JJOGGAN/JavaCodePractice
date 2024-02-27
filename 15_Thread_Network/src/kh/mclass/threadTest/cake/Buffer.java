package kh.mclass.threadTest.cake;

public class Buffer {
	private int data;
	private boolean empty = true;

	public synchronized  int get() {
		System.out.println("get");
		while (empty) { // 비어있다면 대기 (false가 되면 15행으로 감)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		empty = true;
		notifyAll(); // wqit 상황을 풀어주겠다
		return data; // data 값 return
	}

	public  synchronized   void put(int data) {
		System.out.println("put");
		// synchronized가 붙으면 느려지긴 함 그렇지만 안전함
		while (!empty) { //(true가 되면 29행으로)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		empty = false;
		this.data = data;
		notifyAll();
	}
}