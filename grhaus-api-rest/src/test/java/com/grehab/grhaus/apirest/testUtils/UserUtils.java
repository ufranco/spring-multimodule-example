package com.grehab.grhaus.apirest.testUtils;

import static com.grehab.grhaus.apirest.testUtils.GroupUtils.GROUP_ID;

import com.grehab.grhaus.apirest.model.User;
import com.grehab.grhaus.apirest.model.UserIn;
import com.grehab.grhaus.apirest.model.UserOut;
import com.grehab.grhaus.domain.commands.common.UserDTO;
import com.grehab.grhaus.domain.commands.user.UserInCommand;
import com.grehab.grhaus.domain.commands.user.UserOutCommand;
import java.util.List;

public class UserUtils {

  public static final String USER_NAME = "user";

  public static UserIn getUserIn() {
    return new UserIn()
        .username(USER_NAME)
        .groupId(GROUP_ID);
  }

  public static UserInCommand getUserInCommand() {
    return UserInCommand.builder()
        .username(USER_NAME)
        .groupId(GROUP_ID)
        .build();
  }

  public static UserOutCommand getUserOutCommand() {
    return UserOutCommand.builder()
        .username(USER_NAME)
        .group(GroupUtils.getGroupDTO())
        .tasksAssigned(List.of(TaskUtils.getTaskDTO()))
        .build();
  }

  public static UserOut getUserOut() {
    return new UserOut()
        .username(USER_NAME)
        .group(GroupUtils.getGroup())
        .tasksAssigned(List.of(TaskUtils.getTask()));

  }

  public static UserDTO getUserDTO() {
    return UserDTO.builder()
        .username(USER_NAME)
        .build();
  }

  public static User getUser() {
    return new User()
        .username(USER_NAME);
  }

}
