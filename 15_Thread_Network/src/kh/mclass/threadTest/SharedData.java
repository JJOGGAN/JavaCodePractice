package kh.mclass.threadTest;

public class SharedData {
	private int number = 12;
	private volatile boolean isChanged; // 휘발성
//volatile 휘발성 : 컴파일러의 재량을 제한함 - C에서 자주 언급된
//nv (non-volatile) : 사라지지 않게 하는 메모리 공간 / 껐다켜도 안 사라지는 공간 / DB공간?
//최적화(비휘발성) : 메모리에 기록된 값을 계속 가져다 사용하는 것

	public SharedData() {}

	public synchronized void calcNumber() {
		number *= 3;
		System.out.println("changed ...... " + number);
	}

	public synchronized void printNumber() {
		System.out.println("number : " + number);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isChanged() { //boolean type은 get대신 is로 메소드명 작성(관례)
		return isChanged;
	}

	public void setChanged(boolean isChanged) {
		this.isChanged = isChanged;
	}

}
