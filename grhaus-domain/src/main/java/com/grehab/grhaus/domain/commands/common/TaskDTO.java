package com.grehab.grhaus.domain.commands.common;

import java.util.Date;
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

  Date dueDate;

}
