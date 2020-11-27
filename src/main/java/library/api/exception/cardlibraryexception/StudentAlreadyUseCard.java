package library.api.exception.cardlibraryexception;

public class StudentAlreadyUseCard extends RuntimeException {
    public StudentAlreadyUseCard() {
        super("Student already use card");
    }
}
