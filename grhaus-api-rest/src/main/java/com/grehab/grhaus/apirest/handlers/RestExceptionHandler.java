package com.grehab.grhaus.apirest.handlers;

import static com.grehab.grhaus.domain.enums.BusinessRuleEnum.UNEXPECTED_ERROR;

import com.grehab.grhaus.apirest.model.ErrorOut;
import com.grehab.grhaus.domain.exceptions.GRHausException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(GRHausException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorOut handleGRHausException(GRHausException exception) {
    return new ErrorOut()
        .code(UNEXPECTED_ERROR.getValue())
        .description(UNEXPECTED_ERROR.name());
  }


}
