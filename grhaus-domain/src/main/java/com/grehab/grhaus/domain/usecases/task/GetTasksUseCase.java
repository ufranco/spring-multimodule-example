package com.grehab.grhaus.domain.usecases.task;

import com.grehab.grhaus.domain.commands.task.TaskListInCommand;
import com.grehab.grhaus.domain.commands.task.TaskListOutCommand;

public interface GetTasksUseCase {

  TaskListOutCommand getTasks(final TaskListInCommand inCommand);

}
