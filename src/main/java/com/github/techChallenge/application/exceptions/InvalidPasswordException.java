package com.github.techChallenge.application.exceptions;


public class InvalidPasswordException extends BusinessException {

    public InvalidPasswordException(String message) {
        super("invalid-password", message);
    }
}
