package com.grehab.grhaus.apirest.controllers;

import static com.grehab.grhaus.apirest.testUtils.TaskUtils.TASK_ID;
import static com.grehab.grhaus.apirest.testUtils.TaskUtils.getTaskIn;
import static com.grehab.grhaus.apirest.testUtils.TaskUtils.getTaskInCommand;
import static com.grehab.grhaus.apirest.testUtils.TaskUtils.getTaskOut;
import static com.grehab.grhaus.apirest.testUtils.TaskUtils.getTaskOutCommand;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import com.grehab.grhaus.apirest.mappers.RestTaskMapper;
import com.grehab.grhaus.apirest.model.TaskIn;
import com.grehab.grhaus.domain.commands.task.TaskOutCommand;
import com.grehab.grhaus.domain.exceptions.GRHausException;
import com.grehab.grhaus.domain.usecases.task.CreateTaskUseCase;
import com.grehab.grhaus.domain.usecases.task.DeleteTaskUseCase;
import com.grehab.grhaus.domain.usecases.task.GetTaskByIdUseCase;
import com.grehab.grhaus.domain.usecases.task.UpdateTaskUseCase;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
class TaskApiControllerTest {

  @Mock
  private CreateTaskUseCase createTaskUseCase;

  @Mock
  private GetTaskByIdUseCase getTaskByIdUseCase;

  @Mock
  private UpdateTaskUseCase updateTaskUseCase;

  @Mock
  private DeleteTaskUseCase deleteTaskUseCase;

  @Mock
  private RestTaskMapper mapper;

  @InjectMocks
  private TaskApiController controller;

  @Test
  void givenNullId_whenGetTask_shouldRaiseException() {
    //WHEN
    val result = catchThrowable(() -> controller.getTask(null));

    //THEN
    assertThat(result)
        .isNotNull()
        .isInstanceOf(GRHausException.class);
  }

  @Test
  void givenValidId_whenGetTask_shouldSuccess() throws GRHausException, NotFoundException {
    //GIVEN
    given(getTaskByIdUseCase.getTaskById(anyString()))
        .willReturn(getTaskOutCommand());

    given(mapper.mapToTaskOut(any(TaskOutCommand.class)))
        .willReturn(getTaskOut());

    //WHEN
    val result = controller.getTask(TASK_ID);

    //THEN
    assertThat(result)
        .isNotNull()
        .isInstanceOf(ResponseEntity.class)
        .extracting(HttpEntity::getBody, ResponseEntity::getStatusCode)
        .containsExactly();
  }

  @Test
  void givenNullTaskIn_whenCreateTask_shouldRaiseException() {
    //WHEN
    val result = catchThrowable(() -> controller.createTask(null));

    //THEN
    assertThat(result)
        .isNotNull()
        .isInstanceOf(GRHausException.class);
  }

  @Test
  void givenValidTaskIn_whenCreateTask_shouldSuccess() throws GRHausException {
    //GIVEN

    given(mapper.mapToTaskInCommand(getTaskIn()))
        .willReturn(getTaskInCommand());

    given(createTaskUseCase.createTask(getTaskInCommand()))
        .willReturn(getTaskOutCommand());

    given(mapper.mapToTaskOut(any(TaskOutCommand.class)))
        .willReturn(getTaskOut());

    //WHEN
    val result = controller.createTask(getTaskIn());

    //THEN
    assertThat(result)
        .isNotNull()
        .isInstanceOf(ResponseEntity.class)
        .extracting(HttpEntity::getBody, ResponseEntity::getStatusCode)
        .isEqualTo(CREATED);
  }

  @Test
  void givenNullTaskIn_whenUpdateTask_shouldRaiseException() {
    //WHEN
    val result = catchThrowable(() -> controller.updateTask(null, null));

    //THEN
    assertThat(result)
        .isNotNull()
        .isInstanceOf(GRHausException.class);
  }

  @Test
  void givenValidTaskIn_whenUpdateTask_shouldSuccess() throws GRHausException, NotFoundException {
    //GIVEN
    given(mapper.mapToTaskInCommand(anyString(), any(TaskIn.class)))
        .willReturn(getTaskInCommand());

    given(updateTaskUseCase.updateTask(getTaskInCommand()))
        .willReturn(getTaskOutCommand());

    given(mapper.mapToTaskOut(any(TaskOutCommand.class)))
        .willReturn(getTaskOut());

    //WHEN
    val result = controller.updateTask(TASK_ID, getTaskIn());

    //THEN
    assertThat(result)
        .isNotNull()
        .isInstanceOf(ResponseEntity.class)
        .extracting(HttpEntity::getBody, ResponseEntity::getStatusCode)
        .containsExactly();
  }

  @Test
  void givenNullId_whenDeleteTask_shouldRaiseException() {
    //WHEN
    val result = catchThrowable(() -> controller.deleteTask(null));

    //THEN
    assertThat(result)
        .isNotNull()
        .isInstanceOf(GRHausException.class);
  }

  @Test
  void givenValidId_whenDeleteTask_shouldSuccess() throws NotFoundException {
    //WHEN
    val result = controller.deleteTask(TASK_ID);

    //THEN
    assertThat(result)
        .isNotNull()
        .isInstanceOf(ResponseEntity.class)
        .extracting(HttpEntity::getBody, ResponseEntity::getStatusCode)
        .containsExactly(NO_CONTENT);
  }
}
