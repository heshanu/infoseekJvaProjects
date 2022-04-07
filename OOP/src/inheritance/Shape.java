package inheritance;

public abstract class Shape {
	public Shape(String color) {
		this.color = color;
	}

	private String color;

	public String getColor() {
		return this.color;
	}

	public abstract double calculateArea();

	public abstract double calculatePeremter();

	public abstract String toString();
}
