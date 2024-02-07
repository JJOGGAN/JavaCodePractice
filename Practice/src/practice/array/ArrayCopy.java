package practice.array;

public class ArrayCopy {

	public static void main(String[] args) {
		int[] array1 = {10,20,30,40,50};
		int[] array2 = {1,2,3,4,5};
		
		System.arraycopy(array1, 0, array2, 0, 3);
		for(int i = 0; i < array2.length;i++) {
			System.out.print(array2[i] +"\t");
		}
		
//		array2[0]에 array1[0]의 값을 대입할 것이고 총 3개의 값을 순차적으로 복사넣기할 것이다.
//		10	20	30	4	5	
	}

}
