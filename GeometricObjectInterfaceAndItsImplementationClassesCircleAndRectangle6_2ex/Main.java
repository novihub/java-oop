package GeometricObjectInterfaceAndItsImplementationClassesCircleAndRectangle6_2ex;

public class Main {
	public static void main(String[] args) {
		GeometricObject[] geometricObjects = new GeometricObject[2];
		geometricObjects[0] = new Circle(5);
		geometricObjects[1] = new Rectangle(5, 3);

		for (GeometricObject geometricObject : geometricObjects) {
			System.out.println(geometricObject);
			System.out.println("Area: " + geometricObject.getArea());
			System.out.println("Perimeter: " + geometricObject.getPerimeter());
			System.out.println();
		}
	}
}

interface GeometricObject {
	double getArea();
	double getPerimeter();
}

class Circle implements GeometricObject {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}
}

class Rectangle implements GeometricObject {
	private double width;
	private double height;

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		return width * height;
	}

	@Override
	public double getPerimeter() {
		return 2 * (width + height);
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}
}