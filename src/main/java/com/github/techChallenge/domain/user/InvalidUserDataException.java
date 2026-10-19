package com.github.techChallenge.domain.user;

import java.util.Map;

public class InvalidUserDataException extends IllegalArgumentException {

    private final Map<String, String> violations;

    public InvalidUserDataException(Map<String, String> violations) {
        super("Os dados do usuário são inválidos.");
        this.violations = Map.copyOf(violations);
    }

    public Map<String, String> getViolations() {
        return violations;
    }
}