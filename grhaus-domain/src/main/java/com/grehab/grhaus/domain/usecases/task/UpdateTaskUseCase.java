package com.grehab.grhaus.domain.usecases.task;

import com.grehab.grhaus.domain.commands.task.TaskInCommand;
import com.grehab.grhaus.domain.commands.task.TaskOutCommand;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public interface UpdateTaskUseCase {

  TaskOutCommand updateTask(TaskInCommand inCommand) throws NotFoundException;
}
