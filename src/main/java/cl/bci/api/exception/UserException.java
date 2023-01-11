package cl.bci.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

public class UserException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer httpStatus;
    private BindingResult results;

    public UserException(Integer httpStatus, BindingResult results) {
        this.httpStatus = httpStatus;
        this.results = results;
    }

    public Integer getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(Integer httpStatus) {
        this.httpStatus = httpStatus;
    }

    public BindingResult getResults() {
        return results;
    }

    public void setResults(BindingResult results) {
        this.results = results;
    }
}
