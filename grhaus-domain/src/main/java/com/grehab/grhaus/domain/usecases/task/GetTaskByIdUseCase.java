package com.grehab.grhaus.domain.usecases.task;

import com.grehab.grhaus.domain.commands.task.TaskOutCommand;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public interface GetTaskByIdUseCase {

  TaskOutCommand getTaskById(String id) throws NotFoundException;

}
