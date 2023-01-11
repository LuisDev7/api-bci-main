package cl.bci.api.response;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ApiExceptionResponse {


    private final Integer httpStatus;
    private final String message;
    private final List<String> errorMessages;

    public ApiExceptionResponse(Integer httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.errorMessages = null;
    }

    public ApiExceptionResponse(Integer httpStatus, List<String> errorMessages) {
        this.httpStatus = httpStatus;
        this.message = "";
        this.errorMessages = errorMessages;
    }

    public Integer getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }
}
