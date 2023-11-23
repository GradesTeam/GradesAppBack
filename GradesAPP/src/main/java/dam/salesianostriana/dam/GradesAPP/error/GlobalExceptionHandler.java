package dam.salesianostriana.dam.GradesAPP.error;

import dam.salesianostriana.dam.GradesAPP.error.impl.ApiValidationSubError;
import dam.salesianostriana.dam.GradesAPP.exception.NotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.*;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValid(MethodArgumentNotValidException exception){
        List<ApiValidationSubError> validationErrors = exception.getBindingResult().getAllErrors().stream()
                .map(ApiValidationSubError::fromObjectError)
                .toList();
        return ErrorResponse.builder(exception, HttpStatus.BAD_REQUEST, exception.getMessage())
                .title("Invalid data error")
                .type(URI.create("https://api.grades-team.com/errors/not-found"))
                .property("Fields errors", validationErrors)
                .build();
    }
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse handleNotFoundGeneral(EntityNotFoundException exception){
        return ErrorResponse.builder(exception, HttpStatus.NOT_FOUND, exception.getMessage())
                .title("Entity not found")
                .type(URI.create("https://api.grades-team.com/errors/not-found"))
                .property("timestamp", Instant.now())
                .build();
    }

}
