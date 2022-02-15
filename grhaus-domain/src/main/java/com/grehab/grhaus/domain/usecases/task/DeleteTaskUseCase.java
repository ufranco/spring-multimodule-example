package com.grehab.grhaus.domain.usecases.task;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public interface DeleteTaskUseCase {

  void deleteTask(String id) throws NotFoundException;

}
