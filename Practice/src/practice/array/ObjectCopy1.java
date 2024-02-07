package practice.array;

public class ObjectCopy1 {

	public static void main(String[] args) {
		//배열값 복사하기
		Book[] array1 = new Book[3];
		Book[] array2 = new Book[3];
		
		array1[0] = new Book("태백산맥", "조정래");
		array1[1] = new Book("데미안", "헤르만 헤세");
		array1[2] = new Book("어떻게 살 것인가", "유시민");
		System.arraycopy(array1, 0, array2, 0, 3);
		
		for(int i  = 0; i < array2.length;i++) {
			array2[i].showBookInfo();
		}
		
	}

}
