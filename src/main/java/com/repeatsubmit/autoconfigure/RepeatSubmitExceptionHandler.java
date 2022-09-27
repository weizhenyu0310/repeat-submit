package com.repeatsubmit.autoconfigure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ExceptionHandler
 *
 * @author repeatsubmit
 */
@RestControllerAdvice
public class RepeatSubmitExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(RepeatSubmitExceptionHandler.class);

    @ExceptionHandler(RepeatSubmitException.class)
    public ResponseEntity<?> error(RepeatSubmitException e){
        log.error(e.getMessage());
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
