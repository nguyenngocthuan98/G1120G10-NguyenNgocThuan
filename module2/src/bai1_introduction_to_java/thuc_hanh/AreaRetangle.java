package bai1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class AreaRetangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float width;
        float height;
        float result;
        System.out.println("Enter width and height");
        width = sc.nextFloat();
        height = sc.nextFloat();
        result = width * height;
        System.out.println("Width = " + width + " ,height = " + height + " => area result = " + result);
    }
}
