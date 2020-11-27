package library.api.exception.sessionexception;

public class AllFieldOfSessionIsNotNullException extends RuntimeException {
    public AllFieldOfSessionIsNotNullException() {
        super("All field of session is not null");
    }
}
