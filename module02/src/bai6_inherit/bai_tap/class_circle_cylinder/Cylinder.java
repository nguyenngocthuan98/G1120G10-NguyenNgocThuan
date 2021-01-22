package bai6_inherit.bai_tap.class_circle_cylinder;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return super.getArea() * getHeight();
    }

    @Override
    public String toString() {
        return "With " + super.toString() +
                "\nCylinder have area = " + getArea();
    }

    public static void main(String[] args) {
        Circle cr1 = new Cylinder();
        System.out.println(cr1.toString());

        Circle cr2 = new Cylinder(3.23d);
        System.out.println(cr2.toString());

        Circle cr3 = new Cylinder(2.4d, "yellow", 4.2d);
        System.out.println(cr3.toString());
    }
}
