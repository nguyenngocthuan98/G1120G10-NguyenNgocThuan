package bai10_dsa_list.bai_tap.arraylist;

import java.util.ArrayList;

public class ArrayListTest {
    public static class Student {
        private int id;
        private String name;

        public Student() {
        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "id= " + id + ", name= " + name;
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student(1, "Thuan1");
        Student student2 = new Student(2, "Thuan2");
        Student student3 = new Student(3, "Thuan3");
        Student student4 = new Student(4, "Thuan4");
        Student student5 = new Student(5, "Thuan5");

        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(student1);
        studentArrayList.add(student2);
        studentArrayList.add(student3);
        studentArrayList.add(student4);
        studentArrayList.add(student5);

        System.out.println(studentArrayList.toString());
    }

}
