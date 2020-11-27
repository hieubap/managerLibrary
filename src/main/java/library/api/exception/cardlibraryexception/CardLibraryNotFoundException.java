package library.api.exception.cardlibraryexception;

public class CardLibraryNotFoundException extends RuntimeException {
    public CardLibraryNotFoundException() {
        super("Can't not find card library");
    }
}
