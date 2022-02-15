package com.grehab.grhaus.usecases.usecases.task;

import com.grehab.grhaus.domain.usecases.task.DeleteTaskUseCase;
import com.grehab.grhaus.infrastructure.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Log4j2
@RequiredArgsConstructor
public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase {

  private final TaskRepository repository;

  @Override
  public void deleteTask(String id) throws NotFoundException {
    // TODO document why this method is empty
  }
}
