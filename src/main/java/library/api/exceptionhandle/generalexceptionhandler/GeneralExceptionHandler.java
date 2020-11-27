package library.api.exceptionhandle.generalexceptionhandler;

import library.api.entity.CardLibrary;
import library.api.exception.generalexception.ServerErrorException;
import library.api.exceptionhandle.responceEntity.EntityResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = ServerErrorException.class)
    public ResponseEntity<EntityResponse<CardLibrary>> ServerErrorHandler(ServerErrorException serverErrorException){
        EntityResponse<CardLibrary> cardLibraryEntityResponse = new EntityResponse<>(HttpStatus.BAD_REQUEST,serverErrorException.getMessage(),null);
        return new ResponseEntity<>(cardLibraryEntityResponse,HttpStatus.BAD_REQUEST);
    }

}
