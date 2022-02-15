package com.grehab.grhaus.domain.commands.common;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class TaskDTO {

  String id;

  String groupId;

  String description;

  String assignedTo;

  Integer effort;

  LocalDate dueDate;

}
