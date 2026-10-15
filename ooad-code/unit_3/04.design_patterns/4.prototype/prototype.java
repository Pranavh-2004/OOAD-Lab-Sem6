import java.util.Objects;

abstract class Shape {
    protected int x;
    protected int y;
    protected String color;

    public Shape() {}

    public Shape(Shape other) {
        if (other != null) {
            this.x = other.x;
            this.y = other.y;
            this.color = other.color;
        }
    }

    public abstract Shape clone();

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Shape)) return false;
        Shape shape = (Shape) other;
        return this.x == shape.x && this.y == shape.y && this.color.equals(shape.color);
    }
}

class Rectangle extends Shape {
    protected int width;
    protected int height;

    public Rectangle() {}

    public Rectangle(Rectangle other) {
        super(other);
        if (other != null) {
            this.width = other.width;
            this.height = other.height;
        }
    }

    public Shape clone() {
        return new Rectangle(this);
    }

    public boolean equals(Object other) {
        if (!(other instanceof Shape) || !super.equals(other)) return false;
        Rectangle shape = (Rectangle) other;
        return shape.width == other.width && shape.height == other.height;
    }
}

class Prototype {
    public static void main(String args[]) {
    }
}
