package SuperclassShapeAndItsSubclassesCircleRectangleAndSquare4_5ex;

public class Main {
    public static void main(String[] args) {
        // Test Shape class
        Shape shape = new Shape();
        System.out.println(shape);

        Shape shape2 = new Shape("blue", false);
        System.out.println(shape2);

        // Test Circle class
        Circle circle = new Circle();
        System.out.println(circle);

        Circle circle2 = new Circle(2.5, "yellow", true);
        System.out.println(circle2);
        System.out.println("Circle area: " + circle2.getArea());
        System.out.println("Circle perimeter: " + circle2.getPerimeter());

        // Test Rectangle class
        Rectangle rectangle = new Rectangle(2.0, 4.0);
        System.out.println(rectangle);
        System.out.println("Rectangle area: " + rectangle.getArea());
        System.out.println("Rectangle perimeter: " + rectangle.getPerimeter());

        Rectangle rectangle2 = new Rectangle(2.0, 4.0, "red", false);
        System.out.println(rectangle2);

        // Test Square class
        Square square = new Square(3.0);
        System.out.println(square);
        System.out.println("Square area: " + square.getArea());
        System.out.println("Square perimeter: " + square.getPerimeter());

        Square square2 = new Square(3.0, "black", true);
        System.out.println(square2);
    }
}

class Shape {
    private String color = "green";
    private boolean filled = true;

    public Shape() {
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "A Shape with color of " + color + " and " + (filled ? "filled" : "Not filled");
    }
}

class Circle extends Shape {
    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "A Circle with radius=" + radius + ", which is a subclass of " + super.toString();
    }
}

class Rectangle extends Shape {
    private double width = 1.0;
    private double length = 1.0;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * length;
    }

    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return "A Rectangle with width=" + width + " and length=" + length + ", which is a subclass of "
                + super.toString();
    }
}

class Square extends Rectangle {

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    @Override
    public void setWidth(double side) {
        super.setWidth(side);
        super.setLength(side);
    }


    @Override
    public void setLength(double side) {
        super.setLength(side);
        super.setWidth(side);
    }

    public double getSide() {
        return getWidth();
    }

    @Override
    public String toString() {
        return "A Square with side=" + getSide() + ", which is a subclass of " + super.toString();
    }
}