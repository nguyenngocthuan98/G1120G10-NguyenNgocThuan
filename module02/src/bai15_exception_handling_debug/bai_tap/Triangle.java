package bai15_exception_handling_debug.bai_tap;

import bai15_exception_handling_debug.bai_tap.exceptions.IllegalTriangleException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Triangle {

    public static boolean compareXYZ(float x, float y, float z) {
        if ((x + y) < z || (x + z) < y || (y + z) < x) {
            return false;
        } else {
            return true;
        }
    }

    public static void inputValues(float inputA, float inputB, float inputC) throws IllegalTriangleException {
        try {
            if (inputA < 0 || inputB < 0 || inputC < 0) throw new IllegalTriangleException("One of sides smaller 0.");
            if (!compareXYZ(inputA, inputB, inputC))
                throw new IllegalTriangleException("Sum of 2 sides is not greater than the other side.");
        } catch (InputMismatchException e) {
            throw new IllegalTriangleException("All sides must be number.");
        }

        System.out.println("Side a = " + inputA + ", side b = " + inputB + ", side c = " + inputC);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float inputA;
        float inputB;
        float inputC;

        try {
            System.out.println("Enter sides a, b, c: ");
            inputA = scanner.nextFloat();
            inputB = scanner.nextFloat();
            inputC = scanner.nextFloat();

            inputValues(inputA, inputB, inputC);
        } catch (IllegalTriangleException exception) {
            System.out.println(exception.getMessage());;
        }
    }
}


