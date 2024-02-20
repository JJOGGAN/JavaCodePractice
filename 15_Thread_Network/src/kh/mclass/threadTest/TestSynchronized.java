package kh.mclass.threadTest;

public class TestSynchronized {
	public static void main(String[] args) {

		// 공유영역 동기화 오류 해결 테스트
		SharedData shareObj = new SharedData();

//		SynchReadNumber
//		SynchChangeNumber
//		TODO start test 해보세요

		SynchReadNumber srn = new SynchReadNumber(shareObj);
		System.out.println("srn : " + srn.getState());
		srn.start();
		System.out.println("srn : " + srn.getState());
		SynchChangeNumber scn = new SynchChangeNumber(shareObj);
		System.out.println("scn : " + scn.getState());
		scn.start();
		System.out.println("scn : " + scn.getState());

	}
}
