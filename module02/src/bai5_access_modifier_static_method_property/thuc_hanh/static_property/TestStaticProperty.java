package bai5_access_modifier_static_method_property.thuc_hanh.static_property;

public class TestStaticProperty {
    public static void main(String[] args) {
        Car xe1 = new Car("Mercedes", "AMG V8");
        System.out.println(Car.number_of_cars); // 1
        System.out.println(Car.number_of_cars); // 1
        Car xe2 = new Car("Corola Cross", "Hybrid");
        System.out.println(Car.number_of_cars); // 2
    }
}
