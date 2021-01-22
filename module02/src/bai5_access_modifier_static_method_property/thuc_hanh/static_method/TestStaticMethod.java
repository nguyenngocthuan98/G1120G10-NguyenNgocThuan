package bai5_access_modifier_static_method_property.thuc_hanh.static_method;

public class TestStaticMethod {

    public static void main(String[] args) {
        Student.change_school(); //calling change_school method

        //creating objects
        Student std1 = new Student(1, "Javic");
        Student std2 = new Student(2, "John");
        Student std3 = new Student(3, "Nam");

        //calling display method
        std1.display();
        std2.display();
        std3.display();
    }
}
