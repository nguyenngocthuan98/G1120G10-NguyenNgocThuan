package bai6_inherit.bai_tap.class_circle_cylinder;

public class Circle {
    protected double radius;
    protected String color;

    public Circle() {
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.floor(((Math.pow(getRadius(), 2) + Math.PI) * 1000) / 1000);
    }

    @Override
    public String toString() {
        return "rircle's radius: " + getRadius() + ", color's: " + getColor() + " and rircle's area = " + getArea();
    }

    public static void main(String[] args) {
        Circle circle1 = new Circle();
        System.out.println(circle1);

        Circle circle2 = new Circle(5.0d, "rose gold");
        System.out.println(circle2);
    }
}
