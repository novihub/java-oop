package InterfacesResizableAndGeometricObject6_5ex;

public class Main {
	public static void main(String[] args) {
		GeometricObject[] geometricObjects = new GeometricObject[2];
		geometricObjects[0] = new Circle(5);
		geometricObjects[1] = new ResizableCircle(5);

		for (GeometricObject geometricObject : geometricObjects) {
			System.out.println(geometricObject);
			System.out.println("Area: " + geometricObject.getArea());
			System.out.println("Perimeter: " + geometricObject.getPerimeter());
			if (geometricObject instanceof Resizable) {
				((Resizable) geometricObject).resize(50);
				System.out.println("After resizing by 50%: ");
				System.out.println(geometricObject);
				System.out.println("Area: " + geometricObject.getArea());
				System.out.println("Perimeter: " + geometricObject.getPerimeter());
			}
			System.out.println();
		}
	}
}

interface GeometricObject {
	double getPerimeter();

	double getArea();
}

class Circle implements GeometricObject {
	protected double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}
}

interface Resizable {
	void resize(int percent);
}

class ResizableCircle extends Circle implements Resizable {

	public ResizableCircle(double radius) {
		super(radius);
	}

	public void resize(int percent) {
		radius = radius * percent / 100;
	}

	@Override
	public String toString() {
		return "ResizableCircle [radius=" + radius + "]";
	}
}