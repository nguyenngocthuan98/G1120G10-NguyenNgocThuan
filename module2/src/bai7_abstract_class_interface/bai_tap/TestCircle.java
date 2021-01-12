package bai7_abstract_class_interface.bai_tap;

import bai6_inherit.thuc_hanh.Circle;

import java.util.Random;

public class TestCircle extends Circle implements Resizeable {

    public TestCircle() {
    }

    public TestCircle(double radius) {
        super(radius);
    }

    public TestCircle(String color, boolean filled, double radius) {
        super(color, filled, radius);
    }

    @Override
    public void resize(double percent) {
        setRadius(getRadius() * (percent / 100));
    }

    @Override
    public String toString() {
        return "Radius: " + getRadius() + ", Area: " + Math.floor(getArea() * 100) / 100;
    }

    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new TestCircle();
        circles[1] = new TestCircle(12);
        circles[2] = new TestCircle(7);

        System.out.println("After:");
        for (Circle resCir : circles) {
            System.out.println(resCir.toString());
        }

        Random generator = new Random();

        System.out.println("Before resize:");
        for (Circle resCir : circles) {
            Resizeable resizeable1 = (Resizeable) (resCir);
            double value = generator.nextInt(100) + 1;
//            double value = 1 + Math.round(99 * Math.random());
            resizeable1.resize(value);
            System.out.println("With size = " + value + " => " + resCir.toString());
        }
    }
}
