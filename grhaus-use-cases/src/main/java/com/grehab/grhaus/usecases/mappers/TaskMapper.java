package com.grehab.grhaus.usecases.mappers;

import com.grehab.grhaus.domain.commands.task.TaskInCommand;
import com.grehab.grhaus.domain.commands.task.TaskOutCommand;
import com.grehab.grhaus.infrastructure.entities.TaskEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {

  TaskEntity mapTaskInCommandToTaskEntity(final TaskInCommand inCommand);

  TaskOutCommand mapTaskEntityToTaskOutCommand(final TaskEntity entity);

}
