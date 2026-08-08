package com.github.techChallenge.shared;

public abstract class ApplicationException extends RuntimeException {

    private final String code;
    private final String title;

    protected ApplicationException(
            String code,
            String title,
            String message
    ) {
        super(message);
        this.code = code;
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }
}