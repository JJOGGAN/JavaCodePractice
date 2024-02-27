package doIt.exception;

public class ArrayExceptionHandling {

	public static void main(String[] args) {
		int[] arr = new int[5];
		
		try {
			for(int i = 0 ; i <=5 ; i++) {
				arr[i] = i;
				System.out.println(arr[i]);
			}
		}catch (ArrayIndexOutOfBoundsException e) { //배열의 크기를 넘어감
			System.out.println(e);
			System.out.println("예외처리 불가");
		}
		System.out.println("시스템 종료");
	}

}
