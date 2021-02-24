package final_test.commons;

public class NotFoundSavingException extends Exception {
    public NotFoundSavingException() {
    }

    @Override
    public String getMessage() {
        return "MÃ SỔ TIẾT KIỆM KHÔNG TỒN TẠI";
    }
}
