package kh.mclass.threadTest.cake;

public class ProducerConsumerTest {
	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		buffer.put(10);

		Producer p = new Producer(buffer);
		Thread c = new Thread(new Consumer(buffer));
		// Consumer는 Consumer implements Runnable 이기 때문에 Thread에 넣어줘야함
		
		/*Thread c = new Thread(new Consumer(new Buffer())); 하면 안되는 이유*/
		/*buffer라는 객체 하나를 가지고 생산자와 소비자가 같이 써야하기 때문에
		 * 변수에 담아서 각각의 Producer와 Consumer에 넣어줘야함
		 * 만약 Consumer에 new Buffer을 써버리면 각각 다른 객체를 담았기 때문에
		 * 무한 대기만 한다.
		 * */
		p.setDaemon(true);
		p.start();
		c.start();
	}
}