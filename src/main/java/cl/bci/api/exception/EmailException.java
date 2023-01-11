package cl.bci.api.exception;

import org.springframework.http.HttpStatus;

public class EmailException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private HttpStatus httpStatus;
    private String message;


    public EmailException(HttpStatus httpStatus, String message) {
        super();
        this.httpStatus = HttpStatus.valueOf(httpStatus.value());
        this.message = message;
    }


    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
