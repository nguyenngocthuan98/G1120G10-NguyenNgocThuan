package bai5_access_modifier_static_method_property.thuc_hanh.static_method;

public class Student {
    private int id;
    private String name;
    private static String school = "CodeGym";

    //constructor
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //method
    static void change_school() {
        school = "CODEGYM";
    }

    //method
    void display() {
        System.out.println("ID: " + id + ", NAME: " + name + ", SCHOOL: " + school);
    }
}
