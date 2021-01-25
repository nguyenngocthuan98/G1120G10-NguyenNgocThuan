package bai15_exception_handling_debug.bai_tap;

import bai15_exception_handling_debug.bai_tap.exceptions.AgeCheckingException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Age {
    private static int inputAge() throws AgeCheckingException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("input age: ");
        int age = 0;
        try {
            age = scanner.nextInt();
            if (age < 0) throw new AgeCheckingException("age not < 0.");
        } catch (InputMismatchException e) {
            throw new AgeCheckingException("age must be string.");
        }
        return age;
    }

    public static void main(String[] args) {
        try {
            int age = inputAge();
            System.out.println("Age is: " + age);
        } catch (AgeCheckingException e) {
            System.out.println(e.getMessage());
        }
    }
}

