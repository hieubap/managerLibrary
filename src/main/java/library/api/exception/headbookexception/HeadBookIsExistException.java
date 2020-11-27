package library.api.exception.headbookexception;

public class HeadBookIsExistException extends RuntimeException {
    public HeadBookIsExistException() {
        super("Head book is exist in another head book");
    }
}
