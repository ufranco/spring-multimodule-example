package com.grehab.grhaus.apirest.mappers;

import com.grehab.grhaus.apirest.model.TaskIn;
import com.grehab.grhaus.apirest.model.TaskOut;
import com.grehab.grhaus.domain.commands.task.TaskInCommand;
import com.grehab.grhaus.domain.commands.task.TaskOutCommand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RestTaskMapper {

  @Mapping(target = "id", ignore = true)
  TaskInCommand mapToTaskInCommand(TaskIn taskIn);

  TaskInCommand mapToTaskInCommand(String id, TaskIn taskIn);


  TaskOut mapToTaskOut(TaskOutCommand outCommand);

}
