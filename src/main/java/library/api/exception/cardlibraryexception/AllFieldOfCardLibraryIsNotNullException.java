package library.api.exception.cardlibraryexception;

public class AllFieldOfCardLibraryIsNotNullException extends RuntimeException {
    public AllFieldOfCardLibraryIsNotNullException() {
        super("All field of card library is not null");
    }
}
