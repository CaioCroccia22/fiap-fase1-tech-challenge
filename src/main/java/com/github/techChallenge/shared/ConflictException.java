package com.github.techChallenge.shared;

public abstract class ConflictException extends ApplicationException {

    protected ConflictException(
            String code,
            String title,
            String message
    ) {
        super(code, title, message);
    }
}