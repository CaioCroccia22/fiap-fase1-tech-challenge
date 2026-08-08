package com.github.techChallenge.application.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

@Component
public class ProblemDetailFactory {

    public ProblemDetail create(
            HttpStatus status,
            String title,
            String detail,
            String code,
            HttpServletRequest request
    ) {
        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(status, detail);

        String problemType = code
                .toLowerCase(Locale.ROOT)
                .replace("_", "-");

        problemDetail.setTitle(title);
        problemDetail.setType(
                URI.create("/problems/" + problemType)
        );
        problemDetail.setInstance(
                URI.create(request.getRequestURI())
        );

        problemDetail.setProperty("code", code);
        problemDetail.setProperty(
                "timestamp",
                OffsetDateTime.now().truncatedTo(ChronoUnit.MILLIS)
        );

        return problemDetail;
    }
}