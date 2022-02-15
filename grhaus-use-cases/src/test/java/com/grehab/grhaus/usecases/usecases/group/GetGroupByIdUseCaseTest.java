package com.grehab.grhaus.usecases.usecases.group;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetGroupByIdUseCaseTest {

  @Test
  void givenNullId_whenGetGroupById_shouldRaiseException() {}

  @Test
  void givenNonExistentId_whenGetGroupById_shouldRaiseException() {}

  @Test
  void givenValidId_whenGetGroupById_shouldSuccess() {}

}
