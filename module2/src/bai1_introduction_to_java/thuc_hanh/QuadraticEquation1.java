package bai1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class QuadraticEquation1 {
    public static void main(String[] args) {
        System.out.println("Given a equation as 'a * x + b = 0', please enter constants:");
        Scanner sc = new Scanner(System.in);
        float a = sc.nextFloat();
        float b = sc.nextFloat();
        result(a, b);
    }

    public static void result(float a, float b){
        if (a == 0) {
            System.out.println("The equation has no solution");
        } else {
            float output = -b / a;
            System.out.println("The equation has solution = " + output);
        }
    }
}
