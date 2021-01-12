package bai7_abstract_class_interface.thuc_hanh.comparator;

import bai6_inherit.thuc_hanh.Circle;

import java.util.Arrays;
import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {
    @Override
    public int compare(Circle o1, Circle o2) {
//        if (o1.getRadius() > o2.getRadius()) return 1;
//        else if (o1.getRadius() < o2.getRadius()) return -1;
//        else return 0;
        // line 16 is optimize of lines 12, 13, 14.
        return Double.compare(o1.getRadius(), o2.getRadius());
    }

    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(2.3);
        circles[1] = new Circle();
        circles[2] = new Circle("rainbow",false,3.4);

        System.out.println("Pre-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }

//        Comparator circleComparator  = new CircleComparator();
        // line 31 is optimize of lines 29.
        Comparator<Circle> circleComparator  = new CircleComparator();
        Arrays.sort(circles, circleComparator);

        System.out.println("After-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
    }
}
