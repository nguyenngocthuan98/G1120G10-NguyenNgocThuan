package bai19_string_regex.bai_tap;

import java.util.regex.Pattern;

public class ValidateClassName {
//    private static final String REGEX_CLASS_NAME = "(C|A|P)\\d{4}(G|H|I|K|L|M)";
    private static final String REGEX_CLASS_NAME = "^([CAP])\\d{4}([GHIKLM])$"; // replace for above

    public static void main(String[] args) {
        String[] classname = {"C0318G", "M0318G", "P0323A", "A123P", "C1120G"};
        for (String str : classname) {
            System.out.println(str + " is valid? " + Pattern.matches(REGEX_CLASS_NAME, str));
        }
    }
}
