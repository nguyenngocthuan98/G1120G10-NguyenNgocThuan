package bai15_exception_handling_debug.bai_tap.exceptions;

public class AgeCheckingException extends Throwable {
    public AgeCheckingException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Error: " + super.getMessage();
    }
}
