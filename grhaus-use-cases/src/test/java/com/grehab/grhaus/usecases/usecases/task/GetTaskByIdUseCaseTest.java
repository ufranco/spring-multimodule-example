package com.grehab.grhaus.usecases.usecases.task;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetTaskByIdUseCaseTest {

  @Test
  void givenNullId_whenGetTaskById_thenShouldRaiseException() {}

  @Test
  void givenNonExistentId_whenGetTaskById_thenShouldRaiseException() {}

  @Test
  void givenValidId_whenGetTaskById_thenShouldSuccess() {}

}
