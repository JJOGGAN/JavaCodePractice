package mclass.week3.exception;

public class CheckEven { // vo 역할
	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int printEvent(int number) throws EvenException{
		this.number = number;
		if (number % 2 != 0) {
			throw new EvenException(number);
		} else {
			return number;
		}
	}
}
