package com.grehab.grhaus.domain.commands.task;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class TaskListInCommand {

  String username;

  String groupId;

  Boolean done;

}
