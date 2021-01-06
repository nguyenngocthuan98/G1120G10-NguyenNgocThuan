package bai4_class_object.bai_tap;

import java.util.Scanner;

public class QuadraticEquation {
    private float a, b, c;

    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }

    public float getC() {
        return c;
    }

    public QuadraticEquation(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {
        return (Math.pow(getB(), 2) - 4 * getA() * getC());
    }

    public double getRoot1() {
        return (-getB() + Math.sqrt(Math.pow(getB(), 2) - 4 * getA() * getC())) / (2 * getA());
    }

    public double getRoot2() {
        return (-getB() - Math.sqrt(Math.pow(getB(), 2) - 4 * getA() * getC())) / (2 * getA());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a: ");
        float input_a = sc.nextFloat();
        System.out.print("Enter b: ");
        float input_b = sc.nextFloat();
        System.out.print("Enter c: ");
        float input_c = sc.nextFloat();

        QuadraticEquation quadraticEquation = new QuadraticEquation(input_a, input_b, input_c);
        double delta = quadraticEquation.getDiscriminant();
        if (delta < 0) {
            System.out.println("The equation has no roots");
        } else if (delta == 0) {
            System.out.println("The equation has one root: " + quadraticEquation.getRoot1());
        } else {
            System.out.println("The equation have 2 roots is: " + quadraticEquation.getRoot1() + " and " + quadraticEquation.getRoot2());
        }
    }
}
