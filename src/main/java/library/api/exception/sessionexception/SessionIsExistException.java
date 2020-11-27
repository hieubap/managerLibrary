package library.api.exception.sessionexception;

public class SessionIsExistException extends RuntimeException {
    public SessionIsExistException() {
        super("Session is exist in another head book");
    }
}
