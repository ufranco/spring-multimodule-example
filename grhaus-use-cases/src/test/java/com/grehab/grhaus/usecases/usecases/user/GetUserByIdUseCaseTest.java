package com.grehab.grhaus.usecases.usecases.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetUserByIdUseCaseTest {

  @Test
  void givenNullId_whenGetUserById_thenShouldRaiseException() {}

  @Test
  void givenNonExistentId_whenGetUserById_thenShouldRaiseException() {}

  @Test
  void givenValidId_whenGetUserById_thenShouldSuccess() {}

}
