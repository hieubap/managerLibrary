package library.api.exceptionhandle.headbookexceptionhandler;

import library.api.entity.HeadBook;

import library.api.exception.headbookexception.AllFieldOfHeadBookIsNotNullException;
import library.api.exception.headbookexception.HeadBookIsExistException;
import library.api.exception.headbookexception.HeadBookNotFoundException;
import library.api.exceptionhandle.responceEntity.EntityResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HeadBookExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = HeadBookIsExistException.class)
    public ResponseEntity<EntityResponse<HeadBook>> HeadBookExistExceptionHandler(HeadBookIsExistException HeadBookIsExistException){
        EntityResponse<HeadBook> headBookEntityResponse = new EntityResponse<>(HttpStatus.BAD_REQUEST,HeadBookIsExistException.getMessage(),null);
        return new ResponseEntity<>(headBookEntityResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = AllFieldOfHeadBookIsNotNullException.class)
    public ResponseEntity<EntityResponse<HeadBook>> allFieldOfHeadBookIsNotNullExceptionHandler(AllFieldOfHeadBookIsNotNullException allFieldOfHeadBookIsNotNullException){
        EntityResponse<HeadBook> headBookEntityResponse = new EntityResponse<>(HttpStatus.BAD_REQUEST,allFieldOfHeadBookIsNotNullException.getMessage(),null);
        return new ResponseEntity<>(headBookEntityResponse,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = HeadBookNotFoundException.class)
    public ResponseEntity<EntityResponse<HeadBook>> HeadBookNotFoundExceptionHandler(HeadBookNotFoundException HeadBookNotFoundException){
        EntityResponse<HeadBook> headBookEntityResponse = new EntityResponse<>(HttpStatus.NOT_FOUND,HeadBookNotFoundException.getMessage(),null);
        return new ResponseEntity<>(headBookEntityResponse,HttpStatus.NOT_FOUND);
    }
}
