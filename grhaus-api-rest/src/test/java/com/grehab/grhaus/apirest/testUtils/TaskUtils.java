package com.grehab.grhaus.apirest.testUtils;

import static com.grehab.grhaus.apirest.testUtils.GroupUtils.GROUP_ID;
import static com.grehab.grhaus.apirest.testUtils.UserUtils.USER_NAME;

import com.grehab.grhaus.apirest.model.Task;
import com.grehab.grhaus.apirest.model.TaskIn;
import com.grehab.grhaus.apirest.model.TaskOut;
import com.grehab.grhaus.domain.commands.common.TaskDTO;
import com.grehab.grhaus.domain.commands.task.TaskInCommand;
import com.grehab.grhaus.domain.commands.task.TaskOutCommand;
import java.time.LocalDate;

public class TaskUtils {

  public static final String TASK_ID = "61e896e64ee05aef34a767f0";
  public static final String TASK_DESCRIPTION = "clean your damn room";
  public static final Integer TASK_EFFORT = 5;
  public static final LocalDate TASK_DUE_DATE = LocalDate.now();
  public static final Boolean TASK_DONE = false;

  public static TaskIn getTaskIn() {
    return new TaskIn()
        .groupId(GROUP_ID)
        .assignedTo(USER_NAME)
        .description(TASK_DESCRIPTION)
        .effort(TASK_EFFORT)
        .dueDate(TASK_DUE_DATE)
        .done(TASK_DONE);
  }

  public static TaskInCommand getTaskInCommand() {
    return TaskInCommand.builder()
        .id(TASK_ID)
        .assignedTo(USER_NAME)
        .groupId(GROUP_ID)
        .description(TASK_DESCRIPTION)
        .effort(TASK_EFFORT)
        .dueDate(TASK_DUE_DATE)
        .done(TASK_DONE)
        .build();
  }

  public static TaskOutCommand getTaskOutCommand() {
    return TaskOutCommand.builder()
        .id(TASK_ID)
        .description(TASK_DESCRIPTION)
        .assignedTo(USER_NAME)
        .group(GroupUtils.getGroupDTO())
        .effort(TASK_EFFORT)
        .dueDate(TASK_DUE_DATE)
        .done(TASK_DONE)
        .build();
  }

  public static TaskOut getTaskOut() {
    return new TaskOut()
        .id(TASK_ID)
        .group(GroupUtils.getGroup())
        .assignedTo(USER_NAME)
        .description(TASK_DESCRIPTION)
        .effort(TASK_EFFORT)
        .dueDate(TASK_DUE_DATE)
        .done(TASK_DONE);
  }

  public static TaskDTO getTaskDTO() {
    return TaskDTO.builder()
        .id(TASK_ID)
        .groupId(GROUP_ID)
        .description(TASK_DESCRIPTION)
        .assignedTo(USER_NAME)
        .effort(TASK_EFFORT)
        .dueDate(TASK_DUE_DATE)
        .build();
  }

  public static Task getTask() {
    return new Task()
        .id(TASK_ID)
        .description(TASK_DESCRIPTION)
        .assignedTo(USER_NAME)
        .effort(TASK_EFFORT)
        .dueDate(TASK_DUE_DATE)
        .done(TASK_DONE);
  }
}
