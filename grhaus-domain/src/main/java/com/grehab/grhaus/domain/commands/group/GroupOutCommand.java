package com.grehab.grhaus.domain.commands.group;

import com.grehab.grhaus.domain.commands.common.TaskDTO;
import com.grehab.grhaus.domain.commands.common.UserDTO;
import java.util.List;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class GroupOutCommand {

  String name;

  String description;

  List<UserDTO> members;

  List<TaskDTO> tasks;

}
