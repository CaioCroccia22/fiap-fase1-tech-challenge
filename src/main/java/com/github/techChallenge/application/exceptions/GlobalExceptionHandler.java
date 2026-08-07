package com.github.techChallenge.application.exceptions;

import com.github.techChallenge.shared.ConflictException;
import com.github.techChallenge.shared.NotFoundException;
import com.github.techChallenge.shared.UnauthorizedException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

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


    private static final Logger logger =
            LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private final ProblemDetailFactory problemDetailFactory;

    public GlobalExceptionHandler(
            ProblemDetailFactory problemDetailFactory
    ) {
        this.problemDetailFactory = problemDetailFactory;
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ProblemDetail> handleConflict(
            ConflictException exception,
            HttpServletRequest request
    ) {
        ProblemDetail problemDetail = problemDetailFactory.create(
                HttpStatus.CONFLICT,
                exception.getTitle(),
                exception.getMessage(),
                exception.getCode(),
                request
        );

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(problemDetail);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ProblemDetail> handleNotFound(
            NotFoundException exception,
            HttpServletRequest request
    ) {
        ProblemDetail problemDetail = problemDetailFactory.create(
                HttpStatus.NOT_FOUND,
                exception.getTitle(),
                exception.getMessage(),
                exception.getCode(),
                request
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(problemDetail);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ProblemDetail> handleUnauthorized(
            UnauthorizedException exception,
            HttpServletRequest request
    ) {
        ProblemDetail problemDetail = problemDetailFactory.create(
                HttpStatus.UNAUTHORIZED,
                exception.getTitle(),
                exception.getMessage(),
                exception.getCode(),
                request
        );

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(problemDetail);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ProblemDetail> handleValidation(
            MethodArgumentNotValidException exception,
            HttpServletRequest request
    ) {
        Map<String, String> violations = new LinkedHashMap<>();

        exception
                .getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        violations.putIfAbsent(
                                error.getField(),
                                error.getDefaultMessage()
                        )
                );

        ProblemDetail problemDetail = problemDetailFactory.create(
                HttpStatus.BAD_REQUEST,
                "Dados inválidos",
                "Um ou mais campos da requisição são inválidos.",
                "VALIDATION_ERROR",
                request
        );

        problemDetail.setProperty("violations", violations);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(problemDetail);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ProblemDetail> handleUnreadableMessage(
            HttpMessageNotReadableException exception,
            HttpServletRequest request
    ) {
        ProblemDetail problemDetail = problemDetailFactory.create(
                HttpStatus.BAD_REQUEST,
                "Requisição inválida",
                "O corpo da requisição está ausente ou possui formato inválido.",
                "INVALID_REQUEST_BODY",
                request
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(problemDetail);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ProblemDetail> handleDataIntegrityViolation(
            DataIntegrityViolationException exception,
            HttpServletRequest request
    ) {
        logger.warn(
                "Uma restrição de integridade do banco foi violada.",
                exception
        );

        ProblemDetail problemDetail = problemDetailFactory.create(
                HttpStatus.CONFLICT,
                "Conflito de dados",
                "A operação viola uma restrição de integridade dos dados.",
                "DATA_INTEGRITY_CONFLICT",
                request
        );

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(problemDetail);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProblemDetail> handleUnexpectedException(
            Exception exception,
            HttpServletRequest request
    ) {
        logger.error(
                "Erro inesperado ao processar a requisição.",
                exception
        );

        ProblemDetail problemDetail = problemDetailFactory.create(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Erro interno do servidor",
                "Ocorreu um erro inesperado ao processar a solicitação.",
                "INTERNAL_SERVER_ERROR",
                request
        );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(problemDetail);
    }
}
