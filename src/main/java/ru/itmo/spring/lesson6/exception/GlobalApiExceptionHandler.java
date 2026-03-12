package ru.itmo.spring.lesson6.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.itmo.spring.lesson6.exception.dto.ErrorDto;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.I_AM_A_TEAPOT;

@RestControllerAdvice
public class GlobalApiExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorDto handleNPE(NullPointerException e) {
        return new ErrorDto((long) BAD_REQUEST.value(), "Specify data");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(I_AM_A_TEAPOT)
    public ErrorDto handleCVE(ConstraintViolationException e) {
        return new ErrorDto((long) I_AM_A_TEAPOT.value(), "Specify UUID");
    }
}
