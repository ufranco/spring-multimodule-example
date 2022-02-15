package com.grehab.grhaus.usecases.usecases.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UpdateUserUseCaseTest {

  @Test
  void givenNullInCommand_whenUpdateUser_thenShouldRaiseException() {}

  @Test
  void givenInCommandWithNonExistentId_whenUpdateUser_thenShouldRaiseException() {}

  @Test
  void givenValidInCommand_whenUpdateUser_thenShouldSuccess() {}

}
