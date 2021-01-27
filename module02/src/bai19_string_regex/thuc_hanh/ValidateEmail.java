package bai19_string_regex.thuc_hanh;

import java.util.regex.Pattern;

public class ValidateEmail {
    private static final String REGEX_EMAIL = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public static void main(String[] args) {
        String[] emailChecks = {"a@gmail.com", "ab@yahoo.com", "abc@hotmail.com", "@gmail.com", "ab@gmail.", "@#abc@gmail.com"};
        for (String emailCheck : emailChecks) {
            System.out.println(emailCheck + " : is valid? " + Pattern.matches(REGEX_EMAIL, emailCheck));
        }
    }
}
