package practice.array;

public class BookArray {
	public static void main(String[] args) {
		Book[] library = new Book[5];
		for(int i = 0; i< library.length;i++) {
			System.out.println(library[i]);
		}
//		null 출력됨
//		필드 선언만 했기 때문에 null 출력
	}
}
