package doIt.generics;

public class Point<T,V> {
	T x;
	V y ;
	public Point(T x, V y) { //자료형 파라미터
		this.x = x;
		this.y = y;
	}
	
	public T getX() {
		return x;
	}
	
	public V getY() {
		return y;
	}
	
}
