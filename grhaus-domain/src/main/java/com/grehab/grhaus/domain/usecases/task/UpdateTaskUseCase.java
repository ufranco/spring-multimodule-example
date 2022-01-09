package com.grehab.grhaus.domain.usecases.task;

import com.grehab.grhaus.domain.commands.task.TaskInCommand;
import com.grehab.grhaus.domain.commands.task.TaskOutCommand;

public interface UpdateTaskUseCase {

  TaskOutCommand updateTask(TaskInCommand inCommand);
}
