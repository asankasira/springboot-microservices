package org.asanka.javaguide.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundExp(ResourceNotFoundException ex,
                                                                  WebRequest webRequest) {
        var errorDetails = createErrorDetails(ex.getMessage(), webRequest);
        errorDetails.setErrorCode("USER_NOT_FOUND");

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorDetails> handleEmailAlreadyExistsExp(EmailAlreadyExistsException ex,
                                                                  WebRequest webRequest) {
        var errorDetails = createErrorDetails(ex.getMessage(), webRequest);
        errorDetails.setErrorCode("USER_EMAIL_ALREADY_EXISTS");

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGenericExp(Exception ex,
                                                         WebRequest webRequest) {
        var errorDetails = createErrorDetails(ex.getMessage(), webRequest);
        errorDetails.setErrorCode("INTERNAL_ERROR");

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        var errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });

        return new ResponseEntity<>(errors, HttpStatus.valueOf(status.value()));
    }

    private ErrorDetails createErrorDetails(String message, WebRequest webRequest) {
        var errorDetails = new ErrorDetails();
        errorDetails.setMessage(message);
        errorDetails.setTimestamp(LocalDateTime.now());
        errorDetails.setPath(webRequest.getDescription(false));
        return errorDetails;
    }
}
