package com.grehab.grhaus.apirest.controllers;

import static com.grehab.grhaus.apirest.testUtils.UserUtils.USER_NAME;
import static com.grehab.grhaus.apirest.testUtils.UserUtils.getUserIn;
import static com.grehab.grhaus.apirest.testUtils.UserUtils.getUserInCommand;
import static com.grehab.grhaus.apirest.testUtils.UserUtils.getUserOut;
import static com.grehab.grhaus.apirest.testUtils.UserUtils.getUserOutCommand;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import com.grehab.grhaus.apirest.mappers.RestUserMapper;
import com.grehab.grhaus.apirest.model.UserIn;
import com.grehab.grhaus.domain.commands.user.UserOutCommand;
import com.grehab.grhaus.domain.exceptions.GRHausException;
import com.grehab.grhaus.domain.usecases.user.CreateUserUseCase;
import com.grehab.grhaus.domain.usecases.user.DeleteUserUseCase;
import com.grehab.grhaus.domain.usecases.user.GetUserByIdUseCase;
import com.grehab.grhaus.domain.usecases.user.UpdateUserUseCase;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
class UserApiControllerTest {

  @Mock
  private CreateUserUseCase createUserUseCase;

  @Mock
  private GetUserByIdUseCase getUserByIdUseCase;

  @Mock
  private UpdateUserUseCase updateUserUseCase;

  @Mock
  private DeleteUserUseCase deleteUserUseCase;

  @Mock
  private RestUserMapper mapper;

  @InjectMocks
  private UserApiController controller;

  @Test
  void givenNullId_whenGetUser_shouldRaiseException() {
    //WHEN
    val result = catchThrowable(() -> controller.getUser(null));

    //THEN
    assertThat(result)
        .isNotNull()
        .isInstanceOf(GRHausException.class);
  }

  @Test
  void givenValidId_whenGetUser_shouldSuccess() throws GRHausException {
    //GIVEN
    given(getUserByIdUseCase.getUserById(anyString()))
        .willReturn(getUserOutCommand());

    given(mapper.mapToUserOut(any(UserOutCommand.class)))
        .willReturn(getUserOut());

    //WHEN
    val result = controller.getUser(USER_NAME);

    //THEN
    assertThat(result)
        .isNotNull()
        .isInstanceOf(ResponseEntity.class)
        .extracting(HttpEntity::getBody)
        .isNotEmpty();
  }

  @Test
  void givenNullUserIn_whenCreateUser_shouldRaiseException() {
    //WHEN
    val result = catchThrowable(() -> controller.createUser(null));

    //THEN
    assertThat(result)
        .isNotNull()
        .isInstanceOf(GRHausException.class);
  }

  @Test
  void givenValidUserIn_whenCreateUser_shouldSuccess() throws GRHausException {
    //GIVEN

    given(mapper.mapToUserInCommand(getUserIn()))
        .willReturn(getUserInCommand());

    given(createUserUseCase.createUser(getUserInCommand()))
        .willReturn(getUserOutCommand());

    given(mapper.mapToUserOut(any(UserOutCommand.class)))
        .willReturn(getUserOut());

    //WHEN
    val result = controller.createUser(getUserIn());

    //THEN
    assertThat(result)
        .isNotNull()
        .isInstanceOf(ResponseEntity.class)
        .extracting(ResponseEntity::getStatusCode)
        .containsExactly(CREATED);
  }

  @Test
  void givenNullUserIn_whenUpdateUser_shouldRaiseException() {
    //WHEN
    val result = catchThrowable(() -> controller.updateUser(null));

    //THEN
    assertThat(result)
        .isNotNull()
        .isInstanceOf(GRHausException.class);
  }

  @Test
  void givenValidUserIn_whenUpdateUser_shouldSuccess() throws GRHausException {
    //GIVEN
    given(mapper.mapToUserInCommand(any(UserIn.class)))
        .willReturn(getUserInCommand());

    given(updateUserUseCase.updateUser(getUserInCommand()))
        .willReturn(getUserOutCommand());

    given(mapper.mapToUserOut(any(UserOutCommand.class)))
        .willReturn(getUserOut());

    //WHEN
    val result = controller.updateUser(getUserIn());

    //THEN
    assertThat(result)
        .isNotNull()
        .isInstanceOf(ResponseEntity.class)
        .extracting(HttpEntity::getBody)
        .isNotEmpty();
  }

  @Test
  void givenNullId_whenDeleteUser_shouldRaiseException() {
    //WHEN
    val result = catchThrowable(() -> controller.deleteUser(null));

    //THEN
    assertThat(result)
        .isNotNull()
        .isInstanceOf(GRHausException.class);
  }

  @Test
  void givenValidId_whenDeleteUser_shouldSuccess() throws GRHausException {
    //WHEN
    val result = controller.deleteUser(USER_NAME);

    //THEN
    assertThat(result)
        .isNotNull()
        .isInstanceOf(ResponseEntity.class)
        .extracting(ResponseEntity::getStatusCode)
        .containsExactly(NO_CONTENT);
  }
}
