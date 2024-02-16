package mclass.week3.exception;

import java.util.Objects;

//The serializable class EvenException does not declare a static final serialVersionUID field of type long
public class EvenException extends Throwable{
//	class명의 워닝 주의해서 볼 것
	private Integer number = null;
	
	public EvenException(int number) {
		this.number = number;
	}

	@Override
	public String getMessage() {
		if(number == null) {
			return "숫자가 아닙니다.";
		}else {
			return number +"는 짝수가 아닙니다.";
		}
		//return super.getMessage();
	}

}
