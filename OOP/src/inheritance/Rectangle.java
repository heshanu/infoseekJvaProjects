package inheritance;

public class Rectangle extends Shape {
	private double width;
	private double height;

	public Rectangle(String color, double width, double height) {
		super(color);
		this.height = height;
		this.width = width;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return width*height;
	}

	@Override
	public double calculatePeremter() {
		// TODO Auto-generated method stub
		return 2*(width+height);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Rectangle is created color "+super.getColor()+" width "+width+ " " +height+" ,Area "+calculateArea()+", Premiter "+" "+calculatePeremter();
	}

}
