package doIt.generics;

public class GenericPrinterTest {
	public static void main(String[] args) {
		GenericPrinter<Powder> powderPrinter = new GenericPrinter<Powder>();
		powderPrinter.setMeterial(new Powder());
		Powder powder = powderPrinter.getMeterial();
		System.out.println("powderPrinter: "+powderPrinter);
		System.out.println("powder : "+powder);
		
		GenericPrinter<Plastic> plasticPrinter = new GenericPrinter<Plastic>();
		plasticPrinter.setMeterial(new Plastic());
		Plastic plastic = new Plastic();
		plasticPrinter.setMeterial(plastic);
		Plastic plastic2 = plasticPrinter.getMeterial();
		System.out.println("plasticPrinter : "+plasticPrinter);
		System.out.println("plastic2 : "+plastic2);
		System.out.println("plastic : "+plastic);

//		GenericPrinter<Integer> powderPrinter2 = new GenericPrinter<Integer>();
//		powderPrinter2.setMeterial(134567829);
		
		
	}
}
