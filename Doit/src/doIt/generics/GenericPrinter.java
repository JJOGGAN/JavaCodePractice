package doIt.generics;

public class GenericPrinter<T extends Material> { //T의 자료형을 Material을 상속받는 자료형들로 제한함
	private T material; // 자료형을 T로 선언

	public void setMeterial(T meterial) {
		this.material = meterial;
	}

	// T 자료형 변수 meterial을 반환
	public T getMeterial() {
		return material;
	}

	public String toString() {
		return material.toString();
	}
	public void printing() {
		material.doPrinting();
	}
	

//	public static void main(String[] args) {
//		GenericPrinter<Powder> p = new GenericPrinter<Powder>();
//		System.out.println(p.toString());
//		GenericPrinter<Integer> p2 = new GenericPrinter<Integer>();
//		System.out.println(p2.toString());
//	}

}
