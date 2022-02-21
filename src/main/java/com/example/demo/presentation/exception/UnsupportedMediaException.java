package com.example.demo.presentation.exception;

import org.springframework.web.server.UnsupportedMediaTypeStatusException;

/**
 * Application unsupported media exception definitions
 *
 * @author okato
 */
public class UnsupportedMediaException extends UnsupportedMediaTypeStatusException {
    public UnsupportedMediaException(String msg) {
        super(msg);
    }
}
