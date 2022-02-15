package com.grehab.grhaus.usecases.usecases.task;

import com.grehab.grhaus.domain.commands.task.TaskInCommand;
import com.grehab.grhaus.domain.commands.task.TaskOutCommand;
import com.grehab.grhaus.domain.usecases.task.UpdateTaskUseCase;
import com.grehab.grhaus.infrastructure.repositories.TaskRepository;
import com.grehab.grhaus.usecases.mappers.TaskMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Log4j2
@RequiredArgsConstructor
public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {

  private final TaskRepository repository;

  private final TaskMapper mapper;

  @Override
  public TaskOutCommand updateTask(TaskInCommand inCommand) {
    return null;
  }
}
