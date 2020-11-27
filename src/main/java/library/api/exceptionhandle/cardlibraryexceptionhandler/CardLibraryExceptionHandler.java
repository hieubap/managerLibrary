package library.api.exceptionhandle.cardlibraryexceptionhandler;

import library.api.entity.CardLibrary;

import library.api.exception.cardlibraryexception.AllFieldOfCardLibraryIsNotNullException;
import library.api.exception.cardlibraryexception.CardLibraryIsExistException;
import library.api.exception.cardlibraryexception.CardLibraryNotFoundException;
import library.api.exceptionhandle.responceEntity.EntityResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CardLibraryExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = CardLibraryIsExistException.class)
    public ResponseEntity<EntityResponse<CardLibrary>> CardLibraryExistExceptionHandler(CardLibraryIsExistException CardLibraryIsExistException){
        EntityResponse<CardLibrary> cardLibraryEntityResponse = new EntityResponse<>(HttpStatus.BAD_REQUEST,CardLibraryIsExistException.getMessage(),null);
        return new ResponseEntity<>(cardLibraryEntityResponse,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = AllFieldOfCardLibraryIsNotNullException.class)
    public ResponseEntity<EntityResponse<CardLibrary>> allFieldOfCardLibraryIsNotNullExceptionHandler(AllFieldOfCardLibraryIsNotNullException allFieldOfCardLibraryIsNotNullException){
        EntityResponse<CardLibrary> cardLibraryEntityResponse = new EntityResponse<>(HttpStatus.BAD_REQUEST,allFieldOfCardLibraryIsNotNullException.getMessage(),null);
        return new ResponseEntity<>(cardLibraryEntityResponse,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = CardLibraryNotFoundException.class)
    public ResponseEntity<EntityResponse<CardLibrary>> CardLibraryNotFoundExceptionHandler(CardLibraryNotFoundException CardLibraryNotFoundException){
        EntityResponse<CardLibrary> cardLibraryEntityResponse = new EntityResponse<>(HttpStatus.NOT_FOUND,CardLibraryNotFoundException.getMessage(),null);
        return new ResponseEntity<>(cardLibraryEntityResponse,HttpStatus.NOT_FOUND);
    }
}
