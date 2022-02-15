package com.grehab.grhaus.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum BusinessRuleEnum {
  UNEXPECTED_ERROR("G001"),
  GROUP_NOT_FOUND("G404"),
  USER_NOT_FOUND("U404"),
  TASK_NOT_FOUND("T404");

  private final String value;
}
