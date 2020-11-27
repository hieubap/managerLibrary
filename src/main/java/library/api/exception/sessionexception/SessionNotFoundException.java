package library.api.exception.sessionexception;

public class SessionNotFoundException extends RuntimeException {
    public SessionNotFoundException() {
        super("Can't not find session");
    }
}
