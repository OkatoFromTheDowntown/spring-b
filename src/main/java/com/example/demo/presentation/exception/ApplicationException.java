package com.example.demo.presentation.exception;

/**
 * Normal Exception definitions
 *
 * @author okato
 */
public class ApplicationException extends RuntimeException {
    public ApplicationException(String msg) {
        super(msg);
    }
}
