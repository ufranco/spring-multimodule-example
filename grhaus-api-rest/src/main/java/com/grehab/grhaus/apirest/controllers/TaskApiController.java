package com.grehab.grhaus.apirest.controllers;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import com.grehab.grhaus.apirest.api.TaskApi;
import com.grehab.grhaus.apirest.mappers.RestTaskMapper;
import com.grehab.grhaus.apirest.model.TaskIn;
import com.grehab.grhaus.apirest.model.TaskOut;
import com.grehab.grhaus.domain.enums.BusinessRuleEnum;
import com.grehab.grhaus.domain.exceptions.GRHausException;
import com.grehab.grhaus.domain.usecases.task.CreateTaskUseCase;
import com.grehab.grhaus.domain.usecases.task.DeleteTaskUseCase;
import com.grehab.grhaus.domain.usecases.task.GetTaskByIdUseCase;
import com.grehab.grhaus.domain.usecases.task.UpdateTaskUseCase;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
@Validated
public class TaskApiController implements TaskApi {

  private final CreateTaskUseCase createTaskUseCase;

  private final GetTaskByIdUseCase getTaskByIdUseCase;

  private final UpdateTaskUseCase updateTaskUseCase;

  private final DeleteTaskUseCase deleteTaskUseCase;

  private final RestTaskMapper mapper;

  @Override
  public ResponseEntity<TaskOut> createTask(TaskIn taskIn) throws GRHausException {
    val taskOut = Optional.ofNullable(taskIn)
        .map(mapper::mapToTaskInCommand)
        .map(createTaskUseCase::createTask)
        .map(mapper::mapToTaskOut)
        .orElseThrow(() ->
            new GRHausException(BusinessRuleEnum.UNEXPECTED_ERROR)
        );

    return new ResponseEntity<>(taskOut, CREATED);
  }

  @Override
  public ResponseEntity<Void> deleteTask(String id) throws NotFoundException, GRHausException {
    Optional.ofNullable(id)
        .orElseThrow(() -> new GRHausException(BusinessRuleEnum.UNEXPECTED_ERROR));

    deleteTaskUseCase.deleteTask(id);

    return new ResponseEntity<>(NO_CONTENT);
  }

  @Override
  public ResponseEntity<TaskOut> getTask(String id) throws GRHausException, NotFoundException {
    return Optional.ofNullable(getTaskByIdUseCase.getTaskById(id))
        .map(mapper::mapToTaskOut)
        .map(ResponseEntity::ok)
        .orElseThrow(() ->
            new GRHausException(BusinessRuleEnum.UNEXPECTED_ERROR)
        );
  }

  @Override
  public ResponseEntity<TaskOut> updateTask(String id, TaskIn taskIn) throws GRHausException, NotFoundException {
    val inCommand = Optional.ofNullable(taskIn)
        .map(task -> mapper.mapToTaskInCommand(id, task))
        .orElseThrow(() -> new GRHausException(BusinessRuleEnum.UNEXPECTED_ERROR));

    return Optional.of(updateTaskUseCase.updateTask(inCommand))
        .map(mapper::mapToTaskOut)
        .map(ResponseEntity::ok)
        .orElseThrow(() ->
            new GRHausException(BusinessRuleEnum.UNEXPECTED_ERROR)
        );
  }

}
