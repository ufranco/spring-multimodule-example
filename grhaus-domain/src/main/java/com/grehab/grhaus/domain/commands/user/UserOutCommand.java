package com.grehab.grhaus.domain.commands.user;

import com.grehab.grhaus.domain.commands.common.GroupDTO;
import com.grehab.grhaus.domain.commands.common.TaskDTO;
import java.util.List;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class UserOutCommand {

  String username;

  GroupDTO group;

  List<TaskDTO> tasksAssigned;

}
