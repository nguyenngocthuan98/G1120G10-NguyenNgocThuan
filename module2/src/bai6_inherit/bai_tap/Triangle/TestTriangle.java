package bai6_inherit.bai_tap.Triangle;

import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        double a;
        double b;
        double c;
        String color = "";
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Enter a: ");
            a = scanner.nextDouble();
            if (a <= 0) {
                System.out.println("a is illegal!");
            }
        } while (a <= 0);

        do {
            System.out.print("Enter b: ");
            b = scanner.nextDouble();
            if (b <= 0) {
                System.out.println("b is illegal!");
            }
        } while (b <= 0);

        do {
            System.out.print("Enter c: ");
            c = scanner.nextDouble();
            if (c <= 0) {
                System.out.println("c is illegal!");
            }
        } while (c <= 0);

        scanner.nextLine();
        System.out.print("Enter color: ");
        color = scanner.nextLine();

        Triangle triangle = new Triangle(a, b, c);
        triangle.setColor(color);

        System.out.println(triangle);
    }
}
