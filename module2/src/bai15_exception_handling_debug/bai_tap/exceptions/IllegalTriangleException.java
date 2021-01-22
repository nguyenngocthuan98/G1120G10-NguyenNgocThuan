package bai15_exception_handling_debug.bai_tap.exceptions;

public class IllegalTriangleException extends Exception {
    public IllegalTriangleException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Error of rectangle: " + super.getMessage();
    }
}