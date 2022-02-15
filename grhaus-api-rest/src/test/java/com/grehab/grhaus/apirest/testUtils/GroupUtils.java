package com.grehab.grhaus.apirest.testUtils;

import static com.grehab.grhaus.apirest.testUtils.TaskUtils.getTask;
import static com.grehab.grhaus.apirest.testUtils.TaskUtils.getTaskDTO;
import static com.grehab.grhaus.apirest.testUtils.UserUtils.getUser;
import static com.grehab.grhaus.apirest.testUtils.UserUtils.getUserDTO;

import com.grehab.grhaus.apirest.model.Group;
import com.grehab.grhaus.apirest.model.GroupIn;
import com.grehab.grhaus.apirest.model.GroupOut;
import com.grehab.grhaus.domain.commands.common.GroupDTO;
import com.grehab.grhaus.domain.commands.group.GroupInCommand;
import com.grehab.grhaus.domain.commands.group.GroupOutCommand;
import java.util.List;

public class GroupUtils {

  public static final String GROUP_NAME = "GRHAUS";
  public static final String GROUP_ID = "61e89596e5a64d7f621c70cf";
  public static final String GROUP_DESCRIPTION = "description";

  public static GroupIn getGroupIn() {
    return new GroupIn()
        .name(GROUP_NAME)
        .description(GROUP_DESCRIPTION);
  }

  public static GroupInCommand getGroupInCommand() {
    return GroupInCommand.builder()
        .id(GROUP_ID)
        .name(GROUP_NAME)
        .description(GROUP_DESCRIPTION)
        .build();
  }

  public static GroupOutCommand getGroupOutCommand() {
    return GroupOutCommand.builder()
        .id(GROUP_ID)
        .name(GROUP_NAME)
        .description(GROUP_DESCRIPTION)
        .tasks(List.of(getTaskDTO()))
        .members(List.of(getUserDTO()))
        .build();
  }

  public static GroupOut getGroupOut() {
    return new GroupOut()
        .id(GROUP_ID)
        .name(GROUP_NAME)
        .description(GROUP_DESCRIPTION)
        .members(List.of(getUser()))
        .tasks(List.of(getTask()));
  }

  public static GroupDTO getGroupDTO() {
    return GroupDTO.builder()
        .id(GROUP_ID)
        .name(GROUP_NAME)
        .description(GROUP_DESCRIPTION)
        .build();
  }

  public static Group getGroup() {
    return new Group()
        .id(GROUP_ID)
        .name(GROUP_NAME)
        .description(GROUP_DESCRIPTION);
  }

}
