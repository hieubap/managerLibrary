package library.api.exception.studentexception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException() {
        super("Can't not find student");
    }
}
