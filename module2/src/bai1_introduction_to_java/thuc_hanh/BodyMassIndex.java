package bai1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class BodyMassIndex {
    public static void main(String[] args) {
        System.out.println("Enter width and height");
        Scanner sc = new Scanner(System.in);
        float width = sc.nextFloat();
        float height = sc.nextFloat();
        double bmi = width / Math.pow(height,2);

        if (bmi < 18.5){
            System.out.print("Underweight");
        } else if (bmi < 25){
            System.out.print("Nomal");
        } else if (bmi < 30){
            System.out.print("Overweight");
        } else {
            System.out.print("Obese");
        }
    }
}
