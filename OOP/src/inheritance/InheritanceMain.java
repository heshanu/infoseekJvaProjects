package inheritance;

public class InheritanceMain {

	public static void main(String[] args) {
		Square sq=new Square("blue",10);
		System.out.println(sq);
		System.out.println("==================");
		Circle c=new Circle("red", 10.5);
		System.out.println(c);
		System.out.println("==================");
		Pegasus p=new Pegasus();
		p.fly();
		p.run();
	}

}
 