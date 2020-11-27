package library.api.exception.generalexception;

public class ServerErrorException extends RuntimeException {
    public ServerErrorException() {
        super("Server error");
    }
}
