package rut.miit.testingsystem.api.config;

import org.jboss.logging.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import rut.miit.testingsystem.exception.EntityNotFoundException;
import rut.miit.testingsystem.exception.UserAlreadyExistsException;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            EntityNotFoundException.class,
            UserAlreadyExistsException.class,
            EmptyResultDataAccessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleEntityNotFoundException(RuntimeException e) {
        return getBody(e.getMessage());
    }

    private Map<String, Object> getBody(String message) {
        Map<String, Object> body = new HashMap<>(2);
        body.put("timestamp", LocalDateTime.now());
        body.put("message", message);
        return body;
    }




}
