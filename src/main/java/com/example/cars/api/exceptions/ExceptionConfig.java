package com.example.cars.api.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.*;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.Serializable;

@RestControllerAdvice
public class ExceptionConfig extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            EmptyResultDataAccessException.class
    })
    public ResponseEntity<Void> raiseNotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler({
            IllegalArgumentException.class
    })
    public ResponseEntity<Void> raiseBadRequest() {
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .body(new CustomProblemDetail(ex.getBody()));
    }



    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    protected static class CustomProblemDetail implements Serializable {
        private int status;
        private String title;
        private String detail;
        private String message;

        protected CustomProblemDetail(String message) {
            this.message = message;
        }

        protected CustomProblemDetail(ProblemDetail problemDetail) {
            status = problemDetail.getStatus();
            detail = problemDetail.getDetail();
            title = problemDetail.getTitle();
        }

        protected CustomProblemDetail(ProblemDetail problemDetail, String message) {
            status = problemDetail.getStatus();
            title = problemDetail.getTitle();
            detail = problemDetail.getDetail();
            this.message = message;
        }

        public int getStatus() {
            return status;
        }

        public String getTitle() {
            return title;
        }

        public String getDetail() {
            return detail;
        }

        public String getMessage() {
            return message;
        }
    }
}
