package com.grehab.grhaus.domain.usecases.task;

import com.grehab.grhaus.domain.commands.task.TaskInCommand;
import com.grehab.grhaus.domain.commands.task.TaskOutCommand;

public interface CreateTaskUseCase {

  TaskOutCommand createTask(final TaskInCommand inCommand);

}
