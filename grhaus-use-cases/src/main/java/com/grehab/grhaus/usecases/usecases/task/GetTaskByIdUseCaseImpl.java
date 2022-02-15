package com.grehab.grhaus.usecases.usecases.task;

import com.grehab.grhaus.domain.commands.task.TaskOutCommand;
import com.grehab.grhaus.domain.usecases.task.GetTaskByIdUseCase;
import com.grehab.grhaus.infrastructure.repositories.TaskRepository;
import com.grehab.grhaus.usecases.mappers.TaskMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Log4j2
@RequiredArgsConstructor
public class GetTaskByIdUseCaseImpl implements GetTaskByIdUseCase {

  private final TaskRepository repository;

  private final TaskMapper mapper;

  @Override
  public TaskOutCommand getTaskById(String id) throws NotFoundException {
    return repository.findById(id)
        .map(mapper::mapTaskEntityToTaskOutCommand)
        .orElseThrow(NotFoundException::new);
  }
}
