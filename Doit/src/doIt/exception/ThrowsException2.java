package doIt.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsException2 {
	public Class loadClass(String fileName, String className) throws FileNotFoundException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		Class c = Class.forName(className);
		return c;
	}

	public static void main(String[] args) {
		ThrowsException2 test = new ThrowsException2();
		try {
			test.loadClass("a.txt", "java.lang.String");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("FileNotFoundException이다");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ClassNotFoundException이다");
		} catch (Exception e) {		//RuntimeException 예외 처리를 위해 Exception
			e.printStackTrace();
			System.out.println("Exception이다"); 
		}
	}
}
