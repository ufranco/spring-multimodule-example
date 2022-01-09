package com.grehab.grhaus.domain.usecases.task;

import com.grehab.grhaus.domain.commands.task.TaskOutCommand;

public interface GetTaskByIdUseCase {

  TaskOutCommand getTaskById(String id);

}
