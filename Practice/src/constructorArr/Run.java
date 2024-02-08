package constructorArr;

public class Run {

	public static void main(String[] args) {
		ConstructorArr[] arr = new ConstructorArr[2];
		arr[0]= new ConstructorArr();
		arr[1]= new ConstructorArr();
		
		arr[0].setName("a");
		arr[0].setAge(1);
		arr[1].setName("b");
		arr[1].setAge(2);
		
		for(int i = 0; i<arr.length;i++) {
			System.out.println(arr[i].getName());
			System.out.println(arr[i].getAge());
		}
	}
}
