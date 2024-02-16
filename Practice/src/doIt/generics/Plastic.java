package doIt.generics;

public class Plastic extends Material {
	public void doPrinting() {
		System.out.println("Plastic 재료로 출력합니다.");
	}

	@Override
	public String toString() {
		return "재료는 Plastic입니다.";
	}
	/*
	 * toString이 자동으로 Override되어 생성되는 이유 toString은 Object에 기본적으로 들어있는 것 나는 Plastic에
	 * 있는 toString을 쓰고 싶으니 Override를 해서 쓰는 것이 맞음 GenericPrinterTest에서 범용 메서드인
	 * toString 말고 내가 개별적으로 만들 info()메서드를 사용하면 에러발생 제너릭으로 설정 해놨는데 Plastic 자료형에서만 쓸 수
	 * 있는 걸 설정해두었기 때문 제너릭으로 자료형 설정 시 메서드명에 주의가 필요해보임
	 */
}
