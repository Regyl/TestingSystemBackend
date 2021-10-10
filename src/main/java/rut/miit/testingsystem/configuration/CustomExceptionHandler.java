package rut.miit.testingsystem.configuration;

import org.jboss.logging.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import rut.miit.testingsystem.exception.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    /*@ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handleAllExceptions(Exception e) {
        Map<String, Object> body = new HashMap<>(2);
        body.put("timestamp", LocalDateTime.now());
        body.put("message", e.getMessage());
        return body;
    }*/

    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleSQLException(SQLException e) {
        Map<String, Object> body = new HashMap<>(3);
        body.put("SQL state", e.getSQLState());
        body.put("message", e.getMessage().substring(e.getMessage().indexOf("Ключ")));
        body.put("timestamp", LocalDateTime.now());
        return body;
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException e) { //repos methods delete without checking request id
        Map<String, Object> body = new HashMap<>(2);
        body.put("timestamp", LocalDateTime.now());
        body.put("message", e.getMessage());
        return body;
    }

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleStudentNotFoundException(StudentNotFoundException e) {
        Map<String, Object> body = new HashMap<>(2);
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Request student not found");
        return body;
    }

    @ExceptionHandler(StudentGroupNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleStudentGroupNotFoundException(StudentGroupNotFoundException e) {
        Map<String, Object> body = new HashMap<>(2);
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Request student group not found");
        return body;
    }

    @ExceptionHandler(SubjectNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleSubjectNotFoundException(SubjectNotFoundException e) {
        Map<String, Object> body = new HashMap<>(2);
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Request subject not found");
        return body;
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleUserAlreadyExists(UserAlreadyExistsException e) {
        Map<String, Object> body = new HashMap<>(2);
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "User already exists");
        return body;
    }




}
