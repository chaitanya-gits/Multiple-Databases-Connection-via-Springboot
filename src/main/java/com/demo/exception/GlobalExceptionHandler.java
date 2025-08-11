package com.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ProblemDetail handleProductNotFoundException(ProductNotFoundException e){
        ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
        detail.setProperty("message","not found");
        detail.setStatus(HttpStatus.valueOf(400));
        detail.setProperty("timestamp", LocalDateTime.now().toString());
        return detail;
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ProblemDetail handleUserNotFoundException(UserNotFoundException e){
        ProblemDetail probDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,e.getMessage());
        probDetail.setProperty("message","Not Found");
        probDetail.setProperty("timestamp", LocalDateTime.now().toString());
        probDetail.setStatus(HttpStatus.valueOf(400));
        return probDetail;
    }


    //@ExceptionHandler(ProductNotFoundException.class)
    //public ProblemDetail handleProductNotFoundException(ProductNotFoundException e) {
    //         ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
    //         pd.setProperty("message", "not found");
    //         return pd;
    //    }

}
