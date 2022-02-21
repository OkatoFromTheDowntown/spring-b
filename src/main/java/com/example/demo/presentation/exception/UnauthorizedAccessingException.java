package com.example.demo.presentation.exception;

/**
 * @author okato
 */
public class UnauthorizedAccessingException extends RuntimeException{
    public UnauthorizedAccessingException(String msg) {
        super(msg);
    }
}
