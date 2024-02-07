package practice.array;

public class CharArray {
	public static void main(String[] args) {
		char[] alphabets = new char[26];
		char ch = 'A';
		char a = 'a';

		for (int i = 0; i < alphabets.length; i++, ch++) { // i와 ch 둘 다 증가
			alphabets[i] = ch;
		}
		for (int i = 0; i < alphabets.length; i++) {
			System.out.println(alphabets[i] + " , " + (int) alphabets[i]);
		}

	}

}
