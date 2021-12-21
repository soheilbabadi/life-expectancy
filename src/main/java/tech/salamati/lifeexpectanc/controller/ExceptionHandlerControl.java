package tech.salamati.lifeexpectanc.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tech.salamati.lifeexpectanc.exception.RequestNotMacheException;
import tech.salamati.lifeexpectanc.helper.ApiResultImp;

@ControllerAdvice
public class ExceptionHandlerControl extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {RequestNotMacheException.class})
    public ApiResultImp handleInvalidRequestException(RequestNotMacheException exception, WebRequest request) {
        return new ApiResultImp().fatalError(exception);
    }
}
