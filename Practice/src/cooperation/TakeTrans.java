package cooperation;

public class TakeTrans {

	public static void main(String[] args) {
		Student joy = new Student("joy", 5000);
		Student bob = new Student("bob", 10000);
		
		Bus bus100 =new Bus(100);
		joy.takeBus(bus100);
		joy.showInfo();
		bus100.showInfo();
		
		Subway subGreen = new Subway("2호선");
		bob.takeSubway(subGreen);
		bob.showInfo();
		subGreen.showInfo();
		
	}

}
