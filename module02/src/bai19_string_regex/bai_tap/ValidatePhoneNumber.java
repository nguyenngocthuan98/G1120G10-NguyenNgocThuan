package bai19_string_regex.bai_tap;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidatePhoneNumber {
    private static final String REGEX_PHONE_NUMBER = "^\\([\\d]{2}\\)-\\([0][\\d]{9}\\)$";

    public static void main(String[] args) {
        String[] phoneNumber = {"(84)-(0978489648)", "(a8)-(22222222)"};
        System.out.println("FORM is: (xx)-(0xxxxxxxxx)");
        for (String strTest : phoneNumber) {
            System.out.println(strTest + " is valid? " + Pattern.matches(REGEX_PHONE_NUMBER, strTest));
        }
    }
}
