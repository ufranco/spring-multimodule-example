package com.grehab.grhaus.domain.commands.task;

import java.util.Date;
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

  Date dueDate;
}
