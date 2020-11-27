package library.api.exceptionhandle.studentexceptionhandler;


import library.api.entity.Student;
import library.api.exception.studentexception.AllFieldOfStudentIsNotNullException;
import library.api.exception.studentexception.StudentIsExistException;
import library.api.exception.studentexception.StudentNotFoundException;
import library.api.exceptionhandle.responceEntity.EntityResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = StudentIsExistException.class)
    public ResponseEntity<EntityResponse<Student>> StudentExistExceptionHandler(StudentIsExistException StudentIsExistException){
        EntityResponse<Student> studentEntityResponse = new EntityResponse<>(HttpStatus.BAD_REQUEST,StudentIsExistException.getMessage(),null);
        return new ResponseEntity<>(studentEntityResponse,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = AllFieldOfStudentIsNotNullException.class)
    public ResponseEntity<EntityResponse<Student>> allFieldOfStudentIsNotNullExceptionHandler(AllFieldOfStudentIsNotNullException allFieldOfStudentIsNotNullException){
        EntityResponse<Student> studentEntityResponse = new EntityResponse<>(HttpStatus.BAD_REQUEST,allFieldOfStudentIsNotNullException.getMessage(),null);
        return new ResponseEntity<>(studentEntityResponse,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = StudentNotFoundException.class)
    public ResponseEntity<EntityResponse<Student>> StudentNotFoundExceptionHandler(StudentNotFoundException StudentNotFoundException){
        EntityResponse<Student> studentEntityResponse = new EntityResponse<>(HttpStatus.NOT_FOUND,StudentNotFoundException.getMessage(),null);
        return new ResponseEntity<>(studentEntityResponse,HttpStatus.NOT_FOUND);
    }
}
