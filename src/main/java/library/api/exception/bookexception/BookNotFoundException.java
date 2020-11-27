package library.api.exception.bookexception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException() {
        super("Can't not find book");
    }
}
