package com.grehab.grhaus.apirest.mappers;
import static com.grehab.grhaus.apirest.testUtils.TaskUtils.TASK_ID;
import static com.grehab.grhaus.apirest.testUtils.TaskUtils.getTaskIn;
import static com.grehab.grhaus.apirest.testUtils.TaskUtils.getTaskInCommand;
import static com.grehab.grhaus.apirest.testUtils.TaskUtils.getTaskOut;
import static com.grehab.grhaus.apirest.testUtils.TaskUtils.getTaskOutCommand;
import static org.assertj.core.api.Assertions.assertThat;

import com.grehab.grhaus.apirest.model.TaskOut;
import com.grehab.grhaus.domain.commands.task.TaskInCommand;
import lombok.val;
import org.junit.jupiter.api.Test;

class RestTaskMapperTest {

  private final RestTaskMapper mapper = new RestTaskMapperImpl();

  @Test
  void givenNullTaskIn_whenMapToTaskInCommand_thenShouldRaiseException() {
    //WHEN
    val result = mapper.mapToTaskInCommand(null);

    //THEN
    assertThat(result)
        .isNull();
  }

  @Test
  void givenTaskIn_whenMapToTaskInCommand_thenShouldSuccess() {
    //GIVEN
    val input = getTaskIn();
    val expectedResult = getTaskInCommand();

    //WHEN
    val output = mapper.mapToTaskInCommand(input);

    //THEN
    assertThat(output)
        .extracting(
            TaskInCommand::getId,
            TaskInCommand::getDescription,
            TaskInCommand::getAssignedTo,
            TaskInCommand::getEffort,
            TaskInCommand::getDueDate,
            TaskInCommand::getDone
        )
        .containsExactly(
            null,
            expectedResult.getDescription(),
            expectedResult.getAssignedTo(),
            expectedResult.getEffort(),
            expectedResult.getDueDate(),
            expectedResult.getDone()
        );
  }

  @Test
  void givenNullId_whenMapToTaskInCommand_thenShouldBeNull() {
    //WHEN
    val result = mapper.mapToTaskInCommand(null, null);

    //THEN
    assertThat(result)
        .isNull();
  }

  @Test
  void givenTaskInAndId_whenMapToTaskInCommand_thenShouldSuccess() {
    //GIVEN
    val input = getTaskIn();
    val expectedResult = getTaskInCommand();

    //WHEN
    val output = mapper.mapToTaskInCommand(TASK_ID, input);

    //THEN
    assertThat(output)
        .extracting(
            TaskInCommand::getId,
            TaskInCommand::getDescription,
            TaskInCommand::getAssignedTo,
            TaskInCommand::getEffort,
            TaskInCommand::getDueDate,
            TaskInCommand::getDone
        )
        .containsExactly(
            expectedResult.getId(),
            expectedResult.getDescription(),
            expectedResult.getAssignedTo(),
            expectedResult.getEffort(),
            expectedResult.getDueDate(),
            expectedResult.getDone()
        );
  }

  @Test
  void givenNullTaskOutCommand_whenMapToTaskOut_thenShouldRaiseException() {
    //WHEN
    val result = mapper.mapToTaskOut(null);

    //THEN
    assertThat(result)
        .isNull();
  }

  @Test
  void givenTaskOutCommand_whenMapToTaskOut_thenShouldSuccess() {
    //GIVEN
    val input = getTaskOutCommand();
    val expectedResult = getTaskOut();

    //WHEN
    val output = mapper.mapToTaskOut(input);

    //THEN
    assertThat(output)
        .extracting(
            TaskOut::getId,
            TaskOut::getDescription,
            TaskOut::getAssignedTo,
            TaskOut::getEffort,
            TaskOut::getDueDate,
            TaskOut::getDone
        )
        .containsExactly(
            expectedResult.getId(),
            expectedResult.getDescription(),
            expectedResult.getAssignedTo(),
            expectedResult.getEffort(),
            expectedResult.getDueDate(),
            expectedResult.getDone()
        );
  }


}
