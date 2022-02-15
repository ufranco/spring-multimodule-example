package com.grehab.grhaus.domain.commands.task;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class TaskInCommand {

  String id;

  String groupId;

  String description;

  String assignedTo;

  Integer effort;

  Boolean done;

  LocalDate dueDate;
}
