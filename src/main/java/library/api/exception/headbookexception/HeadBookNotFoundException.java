package library.api.exception.headbookexception;

public class HeadBookNotFoundException extends RuntimeException {
    public HeadBookNotFoundException() {
        super("Can't not find head book");
    }
}
