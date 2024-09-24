package Tests;

class Point2D {
	private double x;
	private double y;

	public Point2D() {
		x = y = 0;
	}

	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void setXY(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double[] getXY() {
		return new double[] { x, y };
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}

class Point3D extends Point2D {
	private double z;

	public Point3D() {
		super();
		z = 0;
	}

	public Point3D(double x, double y, double z) {
		super(x, y);
		this.z = z;
	}

	public double getZ() {
		return z;
	}

	public double[] getXYZ() {
		return new double[] { getX(), getY(), z };
	}

	public void setXYZ(double x, double y, double z) {
		setXY(x, y);
		this.z = z;
	}
}

public class Lecture {
	public static void main(String[] args) {
		Point2D new1 = new Point2D();
		Point2D new2 = new Point2D(10, 10);

		new1.setXY(10, 20);

		Point3D new3 = new Point3D();
		Point3D new4 = new Point3D(10, 20, 30);
	}
}
