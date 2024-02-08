package inheritance.kh.mclass;

public class Equals {

	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "abc";
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));
		System.out.println("str1: "+str1.hashCode());
		System.out.println("str2: "+str2.hashCode());
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		
		System.out.println("==============");
		String str3 = new String("abc");
		String str4 = new String("abc");
		System.out.println(str3 == str4);
		System.out.println(str3.equals(str4));
		System.out.println("str3: "+str3.hashCode());
		System.out.println("str4: "+str4.hashCode());
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));
		
	}

}
