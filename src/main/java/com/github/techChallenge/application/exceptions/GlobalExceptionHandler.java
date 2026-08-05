package com.github.techChallenge.application.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.time.LocalDateTime;


@RestControllerAdvice
public class GlobalExceptionHandler  {

    private static final String TYPE_BASE = "https://api.techchallenge.com/errors/";

    @ExceptionHandler(UserNotFoundException.class)
    public ProblemDetail handleUserNotFound(UserNotFoundException ex) {
        return this.buildProblem(HttpStatus.NOT_FOUND, "Usuário não encontrado", ex);
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public ProblemDetail handleDuplicateEmail(DuplicateEmailException ex) {
        return this.buildProblem(HttpStatus.CONFLICT, "E-mail já cadastrado", ex);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ProblemDetail handleInvalidCredentials(InvalidCredentialsException ex) {
        return this.buildProblem(HttpStatus.UNAUTHORIZED, "Credenciais inválidas", ex);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ProblemDetail handleInvalidPassword(InvalidPasswordException ex) {
        return this.buildProblem(HttpStatus.BAD_REQUEST, "Senha inválida", ex);
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleUnexpected(Exception ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Ocorreu um erro inesperado ao processar a requisição. Tente novamente mais tarde.");
        problem.setTitle("Erro interno do servidor");
        problem.setType(URI.create(TYPE_BASE + "internal-error"));
        problem.setProperty("errorCode", "internal-error");
        problem.setProperty("timestamp", LocalDateTime.now());
        return problem;
    }


    private ProblemDetail buildProblem(HttpStatus status, String title, BusinessException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(status, ex.getMessage());
        problem.setTitle(title);
        problem.setType(URI.create(TYPE_BASE + ex.getErrorCode()));
        problem.setProperty("errorCode", ex.getErrorCode());
        problem.setProperty("timestamp", LocalDateTime.now());
        return problem;
    }
}
