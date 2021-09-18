package com.grehab.grhaus.domain.commands.task;

import com.grehab.grhaus.domain.commands.common.TaskDTO;
import java.util.List;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class TaskListOutCommand {

  TaskInCommand query;

  List<TaskDTO> tasks;

  Integer records;

}
