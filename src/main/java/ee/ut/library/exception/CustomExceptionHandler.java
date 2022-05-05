package ee.ut.library.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static ee.ut.library.domain.enums.ErrorText.*;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex) {
        log.debug("Exception - {} and {}", ex.getClass(), ex.getMessage());
        final ErrorResponse errorResponse = ErrorResponse.builder()
                .title(ERR_USER_NOT_FOUND.getDescription())
                .message(ex.getMessage())
                .build();
        log.error("ERROR - {}, {}", ex.getMessage(), ex.getStackTrace());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(GeneralException.class)
    protected ResponseEntity<ErrorResponse> handleGeneralException(GeneralException ex) {
        log.debug("Exception - {} and {}", ex.getClass(), ex.getMessage());
        final ErrorResponse errorResponse = ErrorResponse.builder()
                .title(ERROR.getDescription())
                .message(ex.getMessage())
                .build();
        log.error("ERROR - {}, {}", ex.getMessage(), ex.getStackTrace());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConversionFailedException.class)
    protected ResponseEntity<ErrorResponse> handleConflict(RuntimeException ex) {
        log.debug("Exception - {} and {}", ex.getClass(), ex.getMessage());
        final ErrorResponse errorResponse = ErrorResponse.builder()
                .title(ERROR.getDescription())
                .message(ex.getMessage())
                .build();
        log.error("ERROR - {}, {}", ex.getMessage(), ex.getStackTrace());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        StringBuilder errors = new StringBuilder();

        ex.getBindingResult().getAllErrors().forEach(error -> errors.append(((FieldError) error).getField())
                .append(" ")
                .append(error.getDefaultMessage()).append("\n"));

        final ErrorResponse errorResponse = ErrorResponse.builder()
                .title(VALIDATION_FAILED.getDescription())
                .message(errors.toString())
                .build();
        log.error("ERROR - {}, {}", ex.getMessage(), errors);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedException.class)
    protected ResponseEntity<ErrorResponse> handleUnauthorizedException(UnauthorizedException ex) {
        log.debug("Exception - {} and {}", ex.getClass(), ex.getMessage());
        final ErrorResponse errorResponse = ErrorResponse.builder()
                .title(ERROR.getDescription())
                .message(ex.getMessage())
                .build();
        log.error("ERROR - {}, {}", ex.getMessage(), ex.getStackTrace());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }
}
