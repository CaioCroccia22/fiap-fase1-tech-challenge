package com.github.techChallenge.shared;

public abstract class UnauthorizedException extends ApplicationException {

    protected UnauthorizedException(
            String code,
            String title,
            String message
    ) {
        super(code, title, message);
    }
}