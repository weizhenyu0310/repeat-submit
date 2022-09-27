package com.repeatsubmit.autoconfigure;

/**
 * exception
 *
 * @author repeatsubmit
 */
public class RepeatSubmitException extends RuntimeException {

    public RepeatSubmitException() {
        super();
    }

    /**
     * @param message
     */
    public RepeatSubmitException(String message) {
        super(message);
    }

}
