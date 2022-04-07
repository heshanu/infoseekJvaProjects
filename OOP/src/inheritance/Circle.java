package inheritance;

public class Circle extends Shape {
	private double r;

	public Circle(String color, double r) {
		super(color);
		this.r = r;

	}

	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return Math.PI*r*r;
	}

	@Override
	public double calculatePeremter() {
		// TODO Auto-generated method stub
		return 2*Math.PI*r;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "circle is created color "+super.getColor()+" radius "+r+" ,Area "+calculateArea()+", Premiter "+" "+calculatePeremter();
	}

}
