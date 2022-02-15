package com.grehab.grhaus.usecases.usecases.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateUserUseCaseTest {

  @Test
  void givenNullUserInCommand_whenCreateUser_thenShouldRaiseException() {

  }

  @Test
  void givenUserInCommandWithNullUsername_whenCreateUser_thenShouldRaiseException() {

  }

  @Test
  void givenValidUserInCommand_whenCreateUser_thenShouldSuccess() {

  }

}