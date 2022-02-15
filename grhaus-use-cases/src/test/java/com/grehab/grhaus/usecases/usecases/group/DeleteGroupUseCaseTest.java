package com.grehab.grhaus.usecases.usecases.group;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DeleteGroupUseCaseTest {

  @Test
  void givenNullId_whenDeleteGroup_shouldRaiseException() {}

  @Test
  void givenNonExistentId_whenDeleteGroup_shouldRaiseException() {}

  @Test
  void givenValidId_whenDeleteGroup_shouldSuccess() {}



}
