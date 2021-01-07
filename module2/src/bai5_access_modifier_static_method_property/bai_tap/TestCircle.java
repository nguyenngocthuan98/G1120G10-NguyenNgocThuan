package bai5_access_modifier_static_method_property.bai_tap;

public class TestCircle {

    public static void main(String[] args) {
        Circle round1 = new Circle(5);
        System.out.println(round1.getRadius()); //5.0
        Circle round2 = new Circle();
        System.out.println(round2.getColor()); //red
        System.out.println(round2.getRadius()); //1.0

    }
}