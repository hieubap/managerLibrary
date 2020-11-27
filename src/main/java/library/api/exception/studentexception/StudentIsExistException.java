package library.api.exception.studentexception;

public class StudentIsExistException extends RuntimeException {
    public StudentIsExistException() {
        super("Student is exist in another head book");
    }
}
