package inheritance;

public class Pegasus extends Horse implements Bird {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("i can run");

	}

	@Override
	public void fly() {
		System.out.println("i can fly");

	}

}
