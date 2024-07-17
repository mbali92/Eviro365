package com.example.Eviro365.ErrorHandling;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleValidationError {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> valueValidationErrors(MethodArgumentNotValidException ex){ 

        Map<String, Object> errorMessages = new LinkedHashMap<String,Object>();

        List<String> errorMessegesList =  ex.getBindingResult()
        .getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());

        errorMessages.put("Invalid value errors", errorMessegesList);

        return new ResponseEntity<Object>(errorMessages,HttpStatus.BAD_REQUEST);
    }
}
