package mclass.week3.collection;

// 교재 p.388-400
class Point{
	int x;
	int y;
}
class ChildPoint extends Point{
	int x;
	int y;
}
class Triangle<T extends Point>{ //상위클래스제한 / Point를 부모를 둔 모든 자식이 올 수 있음 / <자식 extends 부모>
	T po1,po2,po3;
}
//class TriangleEx<T super Point>{ //하위클래스제한 /Point를 자식?으로 둔 클래스가 올 수 있음???
//	T po1,po2,po3;
//}


//public class GenericEx<T> {
public class GenericEx<T ,S > {// ==> 여러개도 넣을 수 있음 
	// 우리가 직접 제너릭을 만들어 보겠음
	// 보통 대문자 하나를 적음 (관례)

	// GenericEx 클래스 안에서 사용할 수 있음

	private T a1;

	public T getA1() {
		return a1;
	}

	public void setA1(T a1) {
		this.a1 = a1;
	}

	// method 안에서 쓰는 제너릭
	public <K> K methodGeneric(K a2) { // 해당 method 안에서만 새로이 자료형을 받고 싶을 때 꺾쇠 사용
		return a2;
	}
	
	public <S> S method2Generic(Object[] a2, int index,S a3) { 
		//제너릭을 제대로 사용하려면(가이드가 제대로 나오게 하려면) 파라미터에도 넣어줘야함
		return (S)a2[index];
	}

	public static void main(String[] args) {
//		GenericEx<T> ex1 = new GenericEx<T>(); 로 뜸
		GenericEx<String,Integer> ex1 = new GenericEx<String,Integer>();
		ex1.setA1("-----ex1-----");

		GenericEx<Integer,Double> ex2 = new GenericEx<Integer,Double>();
		ex2.setA1(123);
//		ex2.setA1("word"); --> error

		String r1 = ex1.methodGeneric("aaa");			// return => String Type
		Integer r2 = ex1.methodGeneric(3); 				// return => Integer Type
		Double r3 = ex1.methodGeneric(3.141592); 		// return => Double Type
		Student r4 = ex1.methodGeneric(new Student()); 	// return => Student Type
		
		Object obj = ex1.method2Generic(new Integer[] {1,2,3,4},1,5);
		
	}
}
