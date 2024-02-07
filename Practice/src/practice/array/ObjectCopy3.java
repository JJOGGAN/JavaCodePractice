package practice.array;

public class ObjectCopy3 {

	public static void main(String[] args) {
		// 배열값 복사하기
		Book[] array1 = new Book[3];
		Book[] array2 = new Book[3];

		array1[0] = new Book("태백산맥", "조정래");
		array1[1] = new Book("데미안", "헤르만 헤세");
		array1[2] = new Book("어떻게 살 것인가", "유시민");

//		array2배열 인스턴스 생성
		array2[0] = new Book();
		array2[1] = new Book();
		array2[2] = new Book();
		
		for (int i = 0; i < array1.length; i++) {
			array2[i].setBookName(array1[i].getBookName());
			array2[i].setAuthor(array1[i].getAuthor());
		}
		
//		배열에 복사하여 값 넣기 (깊은 복사)		
		for (int i = 0; i < array2.length; i++) {
			array2[i].showBookInfo();
		}
//		arry1의 0번째 배열값 바꾸기
		array1[0].setBookName("나목");
		array1[0].setAuthor("박완서");
		
//		array1의[0]의 값이 변경됨
		System.out.println("=====array1=====");
		for (int i = 0; i < array1.length; i++) {
			array1[i].showBookInfo();
		}
		
		System.out.println("=====array2=====");
		for (int i = 0; i < array2.length; i++) {
			array2[i].showBookInfo();
		}
	}
}
