package bai4_class_object.thuc_hanh;

import java.util.Scanner;

public class Rectangle {
    // khai báo các thuộc tính (properties)
    private double width, height;

    // tạo getter
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    // định nghĩa các phương thức khởi tạo (contructors) có tham số truyền vào
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Định nghĩa các phương thức getArea(), getPerimeter(), display()
    public double getArea() {
        return getHeight() * getWidth();
    }

    public double getPerimeter() {
        return (getHeight() + getWidth()) * 2;
    }

    public String display() {
        return "Rectangle have width: " + width + ", height: " + height;
    }
}
