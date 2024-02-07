package thisex;


class Example{
	public int day;
	public int month;
	public int year;

	public void setYear(int year) {
		this.year = year;
	}
	public void printThis() {
		System.out.println(this); //엥???
	}
	
}

public class BirthDay {
	public static void main(String[] args) {
		Example ddd = new Example();
		ddd.setYear(2000);
		System.out.println(ddd);
		ddd.printThis();
	}
	
}
