package doIt.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
//예외 다중처리
public class ThrowsException {
	public Class loadClass(String fileName, String className)throws FileNotFoundException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		Class c = Class.forName(className);
		return c;
	}
	public static void main(String[] args) {
		ThrowsException test  = new ThrowsException();
		try {
			test.loadClass("a.txt", "java.lang.String"); 
		} catch (FileNotFoundException | ClassNotFoundException e) {// 여러 예외처리를 한 번에
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
