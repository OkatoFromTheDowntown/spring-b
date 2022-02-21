package com.example.demo.application.exception;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author okato
 */
public class ApplicationException extends Exception {

    public String title;

    public int status;

    public String description;

    public String errType;

    public String errCode;

    public String timestamp = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a z Z"));

    public ApplicationException(ApplicationExceptionBuilder builder) {
        this.title = builder.title;
        this.status = builder.status;
        this.description = builder.description;
        this. errType = builder.errType;
        this.errCode = builder.errCode;
    }

    public static ApplicationExceptionBuilder builder() {
        return new ApplicationExceptionBuilder();
    }

    public static class ApplicationExceptionBuilder {
        private String title;

        private int status;

        private String description;

        private String errType;

        private String errCode;

        public ApplicationException build() {
            return new ApplicationException(this);
        }

        public ApplicationExceptionBuilder withTitle(final String title) {
            this.title = title;
            return this;
        }

        public ApplicationExceptionBuilder withStatus(final int status) {
            this.status = status;
            return this;
        }

        public ApplicationExceptionBuilder withDescription(final String desc) {
            this.description = desc;
            return this;
        }

        public ApplicationExceptionBuilder withErrType(final String errType) {
            this.errType = errType;
            return this;
        }

        public ApplicationExceptionBuilder withErrCode(String errCode) {
            this.errCode = errCode;
            return this;
        }

    }

}
