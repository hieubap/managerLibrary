package library.api.exception.bookexception;

public class BookIsExistException extends RuntimeException {
    public BookIsExistException() {
        super("Book is exist in another head book");
    }
}
