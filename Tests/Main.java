package Tests;

public class Main {
	public static void main(String[] args) {
		// Circle obj = new Circle(10);

		Cylinder obj = new Cylinder(10, 5);

		System.out.println(obj.getVolume());
	}
}

class Circle {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	public double getArea() {
		return Math.PI * radius * radius;
	}
}

class Cylinder extends Circle {
	private double height;

	public Cylinder(double radius, double height) {
		super(radius);
		this.height = height;
	}

	public double getVolume() {
		return getArea() * height;
	}
}
