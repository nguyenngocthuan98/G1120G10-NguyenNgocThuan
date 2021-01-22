package bai15_exception_handling_debug.bai_tap;

import bai15_exception_handling_debug.bai_tap.exceptions.AgeCheckingException;
import bai15_exception_handling_debug.bai_tap.exceptions.IllegalTriangleException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Triangle {
    public static boolean compareXYZ(float x, float y, float z) {
        if ((x + y) < z) {
            return false;
        } else if ((x + z) < y) {
            return false;
        } else if ((y + z) < x) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) throws IllegalTriangleException {
        Scanner scanner = new Scanner(System.in);
        float inputA;
        float inputB;
        float inputC;
        System.out.println("Enter side a, b, c: ");
        try {
            inputA = scanner.nextFloat();
            inputB = scanner.nextFloat();
            inputC = scanner.nextFloat();
            if (inputA < 0 || inputB < 0 || inputC < 0) throw new IllegalTriangleException("Sides < 0");
            if (!compareXYZ(inputA, inputB, inputC))
                throw new IllegalTriangleException("Sum of 2 sides is not greater than the other side");
        } catch (InputMismatchException e) {
            throw new IllegalTriangleException("Sides must be number");
        }

        System.out.println("Side a = " + inputA + ", b = " + inputB + ", c" + inputC);
    }
}

//    private static int nhapTuoiNhanVien() throws AgeCheckingException {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Hãy nhập tuổi nhân viên: ");
//        int tuoi = 0;
//        try {
//            tuoi = scanner.nextInt();
//            if (tuoi < 0) throw new AgeCheckingException("tuổi không được nhỏ hơn 0.");
//        } catch (InputMismatchException e) {
//            throw new AgeCheckingException("tuổi phải là một số.");
//        }
//        return tuoi;
//    }
//
//    public static void main(String[] args) {
//        try {
//            int tuoi = nhapTuoiNhanVien();
//            System.out.println("Tuổi đã nhập: " + tuoi);
//        } catch (AgeCheckingException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//}

