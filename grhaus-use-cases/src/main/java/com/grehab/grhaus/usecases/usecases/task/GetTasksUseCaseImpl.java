package com.grehab.grhaus.usecases.usecases.task;

import com.grehab.grhaus.domain.commands.task.TaskListInCommand;
import com.grehab.grhaus.domain.commands.task.TaskListOutCommand;
import com.grehab.grhaus.domain.usecases.task.GetTasksUseCase;
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
public class GetTasksUseCaseImpl implements GetTasksUseCase {

  private final TaskRepository repository;

  private final TaskMapper mapper;

  @Override
  public TaskListOutCommand getTasks(TaskListInCommand inCommand) {
    return null;
  }
}
