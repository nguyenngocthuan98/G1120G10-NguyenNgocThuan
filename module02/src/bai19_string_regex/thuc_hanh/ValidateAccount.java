package bai19_string_regex.thuc_hanh;

import java.util.regex.Pattern;

public class ValidateAccount {
    private static final String REGEX_ACCOUNT_NAME = "^[_a-z0-9]{6,}$";

    public static void main(String[] args) {
        String[] emailChecks = {"123abc_", "_abc123", "______", "123456","abcdefgh", ".@", "12345", "1234_", "abcde"};
        for (String emailCheck : emailChecks) {
            System.out.println(emailCheck + " : is valid? " + Pattern.matches(REGEX_ACCOUNT_NAME, emailCheck));
        }
    }
}
