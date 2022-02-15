package com.grehab.grhaus.usecases.usecases.task;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DeleteTaskUseCaseTest {

  @Test
  void givenNullId_whenDeleteTask_thenShouldRaiseException() {}

  @Test
  void givenNonExistentId_whenDeleteTask_thenShouldRaiseException() {}

  @Test
  void givenValidId_whenDeleteTask_thenShouldSuccess() {}

}
