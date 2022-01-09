package com.grehab.grhaus.domain.exceptions;

import com.grehab.grhaus.domain.enums.BusinessRuleEnum;

public class GRHausException extends Exception {

  private final BusinessRuleEnum ruleBroken;

  public GRHausException(BusinessRuleEnum ruleBroken) {
    super();
    this.ruleBroken = ruleBroken;
  }
}
