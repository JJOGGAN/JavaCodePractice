package lambda;

//람다식은 하나의 인터페이스에 하나의 메서드로만 선언가능
//FunctionalInterface : 함수형 인터페이스를 의미, 하나를 초과한 메서드 선언은 오류가 남
@FunctionalInterface  
public interface MyNumber {
	int getMax(int num1, int num2);
	//int add(int num1, int num2);  //오류 발생
}
