package practice.array;

public class ArrayTest3 {
	public static void main(String[] args) {
		double[] data = new double[5];
		int size = 0; //유요한 값이 저장된 배열 갯수 세기
		
		data[0] = 10.0; size++; //유효값이 들어갔으니 size 증가
		data[1] = 20.0; size++;
		data[2] = 30.0; size++;
		
		for(int i = 0 ; i< size;i++) {  //유효값이 들어간 배열만 출력
			System.out.println(data[i]);
		}
	}
}
