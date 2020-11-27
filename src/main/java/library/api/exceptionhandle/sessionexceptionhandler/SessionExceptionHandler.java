package library.api.exceptionhandle.sessionexceptionhandler;


import library.api.entity.Session;
import library.api.exception.sessionexception.AllFieldOfSessionIsNotNullException;
import library.api.exception.sessionexception.SessionIsExistException;
import library.api.exception.sessionexception.SessionNotFoundException;
import library.api.exceptionhandle.responceEntity.EntityResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SessionExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = SessionIsExistException.class)
    public ResponseEntity<EntityResponse<Session>> SessionExistExceptionHandler(SessionIsExistException SessionIsExistException){
        EntityResponse<Session> sessionEntityResponse = new EntityResponse<>(HttpStatus.BAD_REQUEST,SessionIsExistException.getMessage(),null);
        return new ResponseEntity<>(sessionEntityResponse,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = AllFieldOfSessionIsNotNullException.class)
    public ResponseEntity<EntityResponse<Session>> allFieldOfSessionIsNotNullExceptionHandler(AllFieldOfSessionIsNotNullException allFieldOfSessionIsNotNullException){
        EntityResponse<Session> sessionEntityResponse = new EntityResponse<>(HttpStatus.BAD_REQUEST,allFieldOfSessionIsNotNullException.getMessage(),null);
        return new ResponseEntity<>(sessionEntityResponse,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = SessionNotFoundException.class)
    public ResponseEntity<EntityResponse<Session>> SessionNotFoundExceptionHandler(SessionNotFoundException SessionNotFoundException){
        EntityResponse<Session> sessionEntityResponse = new EntityResponse<>(HttpStatus.NOT_FOUND,SessionNotFoundException.getMessage(),null);
        return new ResponseEntity<>(sessionEntityResponse,HttpStatus.NOT_FOUND);
    }
}
