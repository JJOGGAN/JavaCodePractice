package doIt.generics;

public class GenericMethod {

	public static<T,V> double makeRectangle(Point<T,V>p1,Point<T,V>p2) {
		double left = ((Number)p1.getX()).doubleValue(); //p1의 x값을 꺼내서 Number로 변환하고 double로 변환
		double right = ((Number)p2.getX()).doubleValue(); 
		double top = ((Number)p1.getY()).doubleValue(); 
		double bottom = ((Number)p2.getY()).doubleValue(); 
		
		double width = right - left; 	//p2 - p1
		double height =  bottom - top;	//p2 - p1
		
		return (width * height);
	}
	
	public static void main(String[] args) {
		Point<Integer, Double> p1 = new Point<Integer, Double>(0,0.0);
		Point<Integer, Double> p2 = new Point<Integer, Double>(10,10.0);
		
		double rect = GenericMethod.<Integer,Double>makeRectangle(p1, p2);
		System.out.println("두 점으로 만들어진 사각형의 넓이는 "+rect+"입니다");
	}

}
