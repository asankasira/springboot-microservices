package org.asankasi.javaguide.exception;

import org.asankasi.javaguide.dto.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundError(ResourceNotFoundException ex,
                                                                    WebRequest request) {
        var errorResponse = createErrorResponse(ex.getMessage(), request);
        errorResponse.setErrorCode("DEPARTMENT_NOT_FOUND");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    private ErrorDetails createErrorResponse(String msg, WebRequest request) {
        var errorDetails = new ErrorDetails();
        errorDetails.setMessage(msg);
        errorDetails.setTimestamp(LocalDateTime.now());
        errorDetails.setPath(request.getDescription(false));
        return errorDetails;
    }
}
