package practice0202;

public class Practice0202 {

	public static void main(String[] args) {
		int x = 1;
		System.out.println(x);

		x = x + 1;
		System.out.println(x);

		x ++;
		System.out.println(x);

		x += 2;
		System.out.println(x);

		
		
		x *= 2; //  x = x * 2;와 같은 의미
		System.out.println(x);

		x = +1;	//양수 1을 x에 대입
		System.out.println(x);
		
		
		System.out.println("y연산");
		int y = 10;
		System.out.println(y++);
		System.out.println(++y);
		
		 y = 10;
		System.out.println(++y);
		System.out.println(y++);
		System.out.println();
	}

}
