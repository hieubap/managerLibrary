package library.api.exceptionhandle.bookexceptionhandler;

import library.api.entity.Book;
import library.api.exception.bookexception.AllFieldOfBookIsNotNullException;
import library.api.exception.bookexception.BookIsExistException;
import library.api.exception.bookexception.BookNotFoundException;
import library.api.exceptionhandle.responceEntity.EntityResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class BookExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = BookIsExistException.class)
    public ResponseEntity<EntityResponse<Book>> bookExistExceptionHandler(BookIsExistException bookIsExistException){
        EntityResponse<Book> bookEntityResponse = new EntityResponse<>(HttpStatus.BAD_REQUEST,bookIsExistException.getMessage(),null);
        return new ResponseEntity<>(bookEntityResponse,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = AllFieldOfBookIsNotNullException.class)
    public ResponseEntity<EntityResponse<Book>> allFieldOfBookIsNotNullExceptionHandler(AllFieldOfBookIsNotNullException allFieldOfBookIsNotNullException){
        EntityResponse<Book> bookEntityResponse = new EntityResponse<>(HttpStatus.BAD_REQUEST,allFieldOfBookIsNotNullException.getMessage(),null);
        return new ResponseEntity<>(bookEntityResponse,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = BookNotFoundException.class)
    public ResponseEntity<EntityResponse<Book>> bookNotFoundExceptionHandler(BookNotFoundException bookNotFoundException){
        EntityResponse<Book> bookEntityResponse = new EntityResponse<>(HttpStatus.NOT_FOUND,bookNotFoundException.getMessage(),null);
        return new ResponseEntity<>(bookEntityResponse,HttpStatus.NOT_FOUND);
    }
}
