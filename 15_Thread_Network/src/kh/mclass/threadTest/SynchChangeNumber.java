package kh.mclass.threadTest;

public class SynchChangeNumber extends Thread{
private SharedData sdata;

public SynchChangeNumber(SharedData sdata) {
	this.sdata = sdata;
}
@Override
public void run() {
	for (int k = 1; k <= 5; k++) {
		sdata.calcNumber();

		// 해당 스래드가 공유자원 사용이 끝난 상태라면
		if (this.getState() == Thread.State.TERMINATED) { 
			//this 이 클래스 그 자체
			/* !!!! this 대신 super 사용 가능
			 * 왜냐! 이 클래스에 지금 오버라이드 된 애가 없으니 괜춘
			 * super는  주로 오버라이딩 된 상태에서 (해당 클래스에 동인한 메소드가 있을 때)
			 * 			꼭! 부모 클래스의 메소드를 가져와야한다 할 때 사용
			 * 			그런 경우가 아니면 굳이 super을 사용하지 않고 this
			 * 			구분 짓기 좋으려고 사용하기도 함 근데 여긴 구분 지을 게 없으니까 super 안 씀
			 * */
			// 다른 스래드한테 신호를 보냄
			this.notify(); 
		}
	}
}
}
