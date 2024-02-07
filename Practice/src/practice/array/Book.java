package practice.array;

public class Book {
	private String bookName;
	private String author;

//	Shift + Alt + s : source 창 열림 
//	Generate Constructor using Fields : 생성자 생성
//	 기본 생성자
	public Book() {} 

	public Book(String bookName, String author) { // 책 이름과 저자를 파라미터로 받는 생성자
		super();
		this.bookName = bookName;
		this.author = author;
	}

//  Generate Getters and Setters : Getters & Setters 생성
	public String getBookName() {
		return bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

// 책 정보를 출력해 주는 메서드
	public void showBookInfo() {
		System.out.println(bookName + " , " + author);
	}

}
