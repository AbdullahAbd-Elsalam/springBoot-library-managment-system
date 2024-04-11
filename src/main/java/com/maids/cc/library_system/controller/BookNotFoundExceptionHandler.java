package com.maids.cc.library_system.controller;

import com.maids.cc.library_system.Exception.BookNotFoundError;
import com.maids.cc.library_system.Exception.EmptyException;
import com.maids.cc.library_system.Exception.TypeNotMatchException;
import com.maids.cc.library_system.Exception.response.BookResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookNotFoundExceptionHandler {
    // handle your exception of product not found
    @ExceptionHandler
    public ResponseEntity<BookResponseError> ProductError(BookNotFoundError exception){

        BookResponseError responseError=new BookResponseError();
        responseError.setCode(HttpStatus.NOT_FOUND.value());
        responseError.setMessege(exception.getMessage());
        responseError.setTimeStamp(System.currentTimeMillis());

        return  new ResponseEntity<>(responseError,HttpStatus.NOT_FOUND);

    }

    // test another exception
    @ExceptionHandler
    public ResponseEntity<BookResponseError> empityError(EmptyException exception){

        BookResponseError responseError=new BookResponseError();
        responseError.setCode(HttpStatus.BAD_REQUEST.value());
        responseError.setMessege(exception.getMessage());
        responseError.setTimeStamp(System.currentTimeMillis());

        return  new ResponseEntity<>(responseError,HttpStatus.BAD_REQUEST);

    }

    // test another exception
    @ExceptionHandler
    public ResponseEntity<BookResponseError> TypeError(TypeNotMatchException exception){

        BookResponseError responseError=new BookResponseError();
        responseError.setCode(HttpStatus.BAD_REQUEST.value());
        responseError.setMessege(exception.getMessage());
        responseError.setTimeStamp(System.currentTimeMillis());

        return  new ResponseEntity<>(responseError,HttpStatus.BAD_REQUEST);

    }
}
