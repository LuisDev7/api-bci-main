package cl.bci.api.exception;

import cl.bci.api.response.ApiExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity handlerConstraintViolation(ConstraintViolationException ex) {
        List<String> errores = new ArrayList<>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errores.add(violation.getMessage());
        }
        ApiExceptionResponse apiExeption = new ApiExceptionResponse(HttpStatus.BAD_GATEWAY.value(), errores);

        return new ResponseEntity(apiExeption, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(EmailException.class)
    public ResponseEntity userException(EmailException ex) {
        ApiExceptionResponse apiExeption = new ApiExceptionResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), ex.getMessage());

        return new ResponseEntity(apiExeption, HttpStatus.UNPROCESSABLE_ENTITY);

    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity passwordException(UserException ex) {
        List<String> errores = new ArrayList<>();

        ex.getResults()
                .getFieldErrors()
                .forEach(f -> errores.add(f.getField() + ": " + f.getDefaultMessage()));
        ApiExceptionResponse apiExeption = new ApiExceptionResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), errores);
        return new ResponseEntity(apiExeption, HttpStatus.UNPROCESSABLE_ENTITY);

    }
}
