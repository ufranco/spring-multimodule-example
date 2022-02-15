package com.grehab.grhaus.apirest.controllers;

import static com.grehab.grhaus.apirest.testUtils.GroupUtils.GROUP_ID;
import static com.grehab.grhaus.apirest.testUtils.GroupUtils.getGroupIn;
import static com.grehab.grhaus.apirest.testUtils.GroupUtils.getGroupInCommand;
import static com.grehab.grhaus.apirest.testUtils.GroupUtils.getGroupOut;
import static com.grehab.grhaus.apirest.testUtils.GroupUtils.getGroupOutCommand;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import com.grehab.grhaus.apirest.mappers.RestGroupMapper;
import com.grehab.grhaus.apirest.model.GroupIn;
import com.grehab.grhaus.domain.commands.group.GroupOutCommand;
import com.grehab.grhaus.domain.exceptions.GRHausException;
import com.grehab.grhaus.domain.usecases.group.CreateGroupUseCase;
import com.grehab.grhaus.domain.usecases.group.DeleteGroupUseCase;
import com.grehab.grhaus.domain.usecases.group.GetGroupByIdUseCase;
import com.grehab.grhaus.domain.usecases.group.UpdateGroupUseCase;
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
class GroupApiControllerTest {

  @Mock
  private CreateGroupUseCase createGroupUseCase;

  @Mock
  private GetGroupByIdUseCase getGroupByIdUseCase;

  @Mock
  private UpdateGroupUseCase updateGroupUseCase;

  @Mock
  private DeleteGroupUseCase deleteGroupUseCase;

  @Mock
  private RestGroupMapper mapper;

  @InjectMocks
  private GroupApiController controller;

  @Test
  void givenNullId_whenGetGroup_shouldRaiseException() {
    //WHEN
    val result = catchThrowable(() -> controller.getGroup(null));

    //THEN
    assertThat(result)
        .isNotNull()
        .isInstanceOf(GRHausException.class);
  }

  @Test
  void givenValidId_whenGetGroup_shouldSuccess() throws GRHausException {
    //GIVEN
    given(getGroupByIdUseCase.getGroupById(anyString()))
        .willReturn(getGroupOutCommand());

    given(mapper.mapToGroupOut(any(GroupOutCommand.class)))
        .willReturn(getGroupOut());

    //WHEN
    val result = controller.getGroup(GROUP_ID);

    //THEN
    assertThat(result)
        .isNotNull()
        .isInstanceOf(ResponseEntity.class)
        .extracting(HttpEntity::getBody)
        .isNotEmpty();
  }

  @Test
  void givenNullGroupIn_whenCreateGroup_shouldRaiseException() {
    //WHEN
    val result = catchThrowable(() -> controller.createGroup(null));

    //THEN
    assertThat(result)
        .isNotNull()
        .isInstanceOf(GRHausException.class);
  }

  @Test
  void givenValidGroupIn_whenCreateGroup_shouldSuccess() throws GRHausException {
    //GIVEN

    given(mapper.mapToGroupInCommand(getGroupIn()))
        .willReturn(getGroupInCommand());

    given(createGroupUseCase.createGroup(getGroupInCommand()))
        .willReturn(getGroupOutCommand());

    given(mapper.mapToGroupOut(any(GroupOutCommand.class)))
        .willReturn(getGroupOut());

    //WHEN
    val result = controller.createGroup(getGroupIn());

    //THEN
    assertThat(result)
        .isNotNull()
        .isInstanceOf(ResponseEntity.class)
        .extracting(ResponseEntity::getStatusCode)
        .containsExactly(CREATED);
  }

  @Test
  void givenNullGroupIn_whenUpdateGroup_shouldRaiseException() {
    //WHEN
    val result = catchThrowable(() -> controller.updateGroup(null, null));

    //THEN
    assertThat(result)
        .isNotNull()
        .isInstanceOf(GRHausException.class);
  }

  @Test
  void givenValidGroupIn_whenUpdateGroup_shouldSuccess() throws GRHausException {
    //GIVEN
    given(mapper.mapToGroupInCommand(anyString(), any(GroupIn.class)))
        .willReturn(getGroupInCommand());

    given(updateGroupUseCase.updateGroup(getGroupInCommand()))
        .willReturn(getGroupOutCommand());

    given(mapper.mapToGroupOut(any(GroupOutCommand.class)))
        .willReturn(getGroupOut());

    //WHEN
    val result = controller.updateGroup(GROUP_ID, getGroupIn());

    //THEN
    assertThat(result)
        .isNotNull()
        .isInstanceOf(ResponseEntity.class)
        .extracting(HttpEntity::getBody)
        .isNotEmpty();
  }

  @Test
  void givenNullId_whenDeleteGroup_shouldRaiseException() {
    //WHEN
    val result = catchThrowable(() -> controller.deleteGroup(null));

    //THEN
    assertThat(result)
        .isNotNull()
        .isInstanceOf(GRHausException.class);
  }

  @Test
  void givenValidId_whenDeleteGroup_shouldSuccess() throws GRHausException {
    //WHEN
    val result = controller.deleteGroup(GROUP_ID);

    //THEN
    assertThat(result)
        .isNotNull()
        .isInstanceOf(ResponseEntity.class)
        .extracting(ResponseEntity::getStatusCode)
        .containsExactly(NO_CONTENT);
  }

}
