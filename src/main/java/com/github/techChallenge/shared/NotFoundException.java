package com.github.techChallenge.shared;

public abstract class NotFoundException extends ApplicationException {

    protected NotFoundException(
            String code,
            String title,
            String message
    ) {
        super(code, title, message);
    }
}