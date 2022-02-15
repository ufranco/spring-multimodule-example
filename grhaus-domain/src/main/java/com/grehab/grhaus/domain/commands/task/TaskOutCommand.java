package com.grehab.grhaus.domain.commands.task;

import com.grehab.grhaus.domain.commands.common.GroupDTO;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class TaskOutCommand {

  String id;

  GroupDTO group;

  String description;

  String assignedTo;

  Integer effort;

  Boolean done;

  LocalDate dueDate;

}
