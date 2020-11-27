package library.api.exception.studentexception;

public class AllFieldOfStudentIsNotNullException extends RuntimeException {
    public AllFieldOfStudentIsNotNullException() {
        super("All field of student is not null");
    }
}
