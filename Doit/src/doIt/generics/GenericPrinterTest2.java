package doIt.generics;

public class GenericPrinterTest2 {
	public static void main(String[] args) {
		
		GenericPrinter<Powder> powderPrinter = new GenericPrinter<Powder>();
		powderPrinter.setMeterial(new Powder());
		powderPrinter.printing();
		
		GenericPrinter<Plastic> plasticPrinter = new GenericPrinter<Plastic>();
		plasticPrinter.setMeterial(new Plastic());
		plasticPrinter.printing();

		
		
	}
}
