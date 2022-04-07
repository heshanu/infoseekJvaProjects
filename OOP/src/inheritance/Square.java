package inheritance;

public class Square extends Shape{
	private int width;

	public Square(String color,int width) {
		super(color);
		this.width=width;
	}
	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return width*width;
	}

	@Override
	public double calculatePeremter() {
		// TODO Auto-generated method stub
		return width*4;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Square is created color "+super.getColor()+" width "+width+" ,Area "+calculateArea()+", Premiter "+" "+calculatePeremter();
	}

}
