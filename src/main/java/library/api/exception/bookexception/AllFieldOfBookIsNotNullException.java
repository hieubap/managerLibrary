package library.api.exception.bookexception;

public class AllFieldOfBookIsNotNullException extends RuntimeException {
    public AllFieldOfBookIsNotNullException() {
        super("All field of book is not null");
    }
}
