package bai5_access_modifier_static_method_property.bai_tap;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double r) {
        this.radius = r;
    }
    // try to change the access modifier of methods below
    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }
}
