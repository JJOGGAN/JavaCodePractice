package mclass.test.poly;

public class TestPolyArgument {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		b.buy(new Chair());
		b.buy(new Desk());
		b.buy(new Light());
	}
}

class Furniture {
	// The field Furniture.price is not visible :
	// price가 private으로 되어있음
	/* private */ int price; // 제품가격 //private으로 잠궈나서 쓸 수가 없음

	public Furniture(int price) {
		this.price = price;
	}
}

class Light extends Furniture {
	public Light() {
		super(10); // 부모 클래스의 생성자 호출
	}

	@Override
	public String toString() {
		return "Light";
	}

	public void lightMethod() {
		System.out.println("Light는 배송할 수 없습니다.");
	}
}

class Chair extends Furniture {
	public Chair() {
		super(100); // 부모 클래스의 생성자 호출
	}

	@Override
	public String toString() {
		return "Chair";
	}

	public void chairMethod() {
		System.out.println("배송해드리겠습니다.");
	}
}

class Desk extends Furniture {
	public Desk() {
		super(200);
	}

	@Override
	public String toString() {
		return "Desk";
	}

	public void deskMethod() {
		System.out.println("배송해드리겠습니다.배송비가 20원입니다.");
	}
}

class Buyer {
	private int money = 500;

	public void buy(Furniture f) {
		if (money < f.price) {
			System.out.println("잔액부족!");
			return;
		}
		money -= f.price;
		System.out.println(f + " 구매성공! 잔액: " + money + " 만원");
		//pseudo-code 슈도 코드
//		if (f == desk){
//			deskMethod();
//		} else if (f == chair) {
//			chairMethod();
//		}
//		((Desk)f).deskMethod();  //DownCasting : error 발생 Chair가 Desk형태로 Casting 될 수 없다.
//		((Chair)f).chairMethod(); //error : Desk를 Chair로 Casting할 수 없어
		if(f instanceof Desk) {
			((Desk)f).deskMethod();
		}
		if(f instanceof Chair) {
			((Chair)f).chairMethod();
		}
		if(f instanceof Light) {
			((Light)f).lightMethod();
		}
		
//		instanceof : 비교 연산자 '=='와 같은 순위라고 보면 될 듯
	}
}
