package com.grehab.grhaus.domain.exceptions;

import com.grehab.grhaus.domain.exceptions.enums.BusinessRuleExceptionEnum;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@Builder(toBuilder = true)
@EqualsAndHashCode(callSuper = false)
public class TaskNotFoundException extends RuntimeException {

  public static final long serialVersionUID = 1L;

  BusinessRuleExceptionEnum ruleBroken;

}
