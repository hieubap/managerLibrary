package library.api.exception.cardlibraryexception;

public class CardLibraryIsExistException extends RuntimeException {
    public CardLibraryIsExistException() {
        super("Card library is exist in another head book");
    }
}
