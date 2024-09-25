package MovableInterfaceAndItsImplementationClassesMovablePointAndMovableCircle6_4ex;

public class Main {
	public static void main(String[] args) {
		Movable m1 = new MovablePoint(5, 6, 10, 15);
		System.out.println(m1);
		m1.moveLeft();
		System.out.println(m1);
		m1.moveDown();
		System.out.println(m1);

		Movable m2 = new MovableCircle(2, 1, 2, 20, 5);
		System.out.println(m2);
		m2.moveRight();
		System.out.println(m2);
		m2.moveUp();
		System.out.println(m2);
	}
}

interface Movable {
	void moveUp();

	void moveDown();

	void moveLeft();

	void moveRight();
}

class MovablePoint implements Movable {
	private int x;
	private int y;
	private int xSpeed;
	private int ySpeed;

	public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
		this.x = x;
		this.y = y;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getxSpeed() {
		return xSpeed;
	}

	public int getySpeed() {
		return ySpeed;
	}

	@Override
	public void moveUp() {
		y += ySpeed;
	}

	@Override
	public void moveDown() {
		y -= ySpeed;
	}

	@Override
	public void moveLeft() {
		x -= xSpeed;
	}

	@Override
	public void moveRight() {
		x += xSpeed;
	}

	@Override
	public String toString() {
		return "MovablePoint [(x=" + x + ", y=" + y + "), speed=(x=" + xSpeed + ", y=" + ySpeed + ")]";
	}
}

class MovableCircle implements Movable {
	private int radius;
	private MovablePoint center;

	public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
		this.radius = radius;
		this.center = new MovablePoint(x, y, xSpeed, ySpeed);
	}

	@Override
	public void moveUp() {
		center.moveUp();
	}

	@Override
	public void moveDown() {
		center.moveDown();
	}

	@Override
	public void moveLeft() {
		center.moveLeft();
	}

	@Override
	public void moveRight() {
		center.moveRight();
	}

	@Override
	public String toString() {
		return "MovableCircle [(x=" + center.getX() + ", y=" + center.getY() + "), speed=(x=" + center.getySpeed() + ", y=" + center.getxSpeed()
				+ "), radius="
				+ radius + "]";
	}
}