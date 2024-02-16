package doIt.stream.others;

import java.io.Console;

public class ConsoleTest {
	public static void main(String[] args) {
		Console console = System.console();
		
		System.out.println("name: ");
		String name = console.readLine();
		System.out.println("job: ");
		String job = console.readLine();
		System.out.println("사번: ");
		char[] arr = console.readPassword();
		String strArr = new String(arr);
		
		System.out.println(name);
		System.out.println(job);
		System.out.println(strArr);

	}
}

//name:
//Kim
//job:
//Student
//사번:
//
//Kim
//Student
//1234123pasadsfkasdf
