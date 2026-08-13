package com.github.techChallenge.infrastructure.security;

public interface ISecurityConfig {
    public String   passwordEncoder(String rawPassword);
    public boolean  passwordValidate(String rawPassword, String encodedPassword);
}
