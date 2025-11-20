package com.info.sam.exception.handler;

import com.info.sam.logger.AppLogger;
import com.info.sam.bo.response.error.ErrorResponseBO;
import com.info.sam.constant.AppConstant;
import com.info.sam.exception.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private AppLogger logger;

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorResponseBO errorResponseBO = new ErrorResponseBO();
        errorResponseBO.setErrorMessage(ex.getMessage());
        return ResponseEntity.badRequest().body(errorResponseBO);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorResponseBO errorResponseBO = new ErrorResponseBO();
        errorResponseBO.setErrorMessage(ex.getMessage());
        return ResponseEntity.badRequest().body(errorResponseBO);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorResponseBO errorResponseBO = new ErrorResponseBO();
        errorResponseBO.setErrorMessage(ex.getMessage());
        return ResponseEntity.badRequest().body(errorResponseBO);
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    protected ResponseEntity<ErrorResponseBO> handleValidationException(ValidationException exception, WebRequest webRequest){
        ErrorResponseBO errorResponseBO = new ErrorResponseBO();
        errorResponseBO.setErrorMessage(exception.getMessage());
        logger.info("FAiled .....");
        return ResponseEntity.badRequest().body(errorResponseBO);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    protected ResponseEntity<ErrorResponseBO> handleAllServerRelatedException(Exception exception, WebRequest webRequest){
        ErrorResponseBO errorResponseBO = new ErrorResponseBO();
        errorResponseBO.setErrorMessage(AppConstant.SOMETHING_WENT_WRONG);
        return ResponseEntity.badRequest().body(errorResponseBO);
    }
}
