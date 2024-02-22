package doIt.stream;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class IntArrayTest {
	public static void main(String[] args) {
		double[] arr = {11.2,13.3,3.3,4.1,5.33333333333};
		int[] arr2 = {1,23,4,2};
		
		
		//arr 이라는 배열의 값의 합
		long sumVal2 = Arrays.stream(arr2).sum();
		double sumVal = Arrays.stream(arr).sum();
		Double aveVal = Arrays.stream(arr).average().getAsDouble(); //Optional이 아닌 Double로 하고 싶을 때
		OptionalDouble aveValDouble = Arrays.stream(arr).average();
		OptionalDouble minVal = Arrays.stream(arr).min();
		//arr 배열의 요소 갯수 반환 // count는 long을 return하므로 int으로 형변환
		int count = (int) Arrays.stream(arr).count();
		
		System.out.println(sumVal2);
		System.out.println(sumVal);
		System.out.println(minVal);
		System.out.println(count);
		System.out.println(aveVal);
		System.out.println(aveValDouble);
	}
}
