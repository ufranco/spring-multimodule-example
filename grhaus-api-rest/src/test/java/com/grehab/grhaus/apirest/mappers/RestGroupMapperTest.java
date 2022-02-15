package com.grehab.grhaus.apirest.mappers;

import static com.grehab.grhaus.apirest.testUtils.GroupUtils.GROUP_ID;
import static com.grehab.grhaus.apirest.testUtils.GroupUtils.getGroupIn;
import static com.grehab.grhaus.apirest.testUtils.GroupUtils.getGroupInCommand;
import static com.grehab.grhaus.apirest.testUtils.GroupUtils.getGroupOut;
import static com.grehab.grhaus.apirest.testUtils.GroupUtils.getGroupOutCommand;
import static org.assertj.core.api.Assertions.assertThat;

import com.grehab.grhaus.apirest.model.GroupOut;
import com.grehab.grhaus.domain.commands.group.GroupInCommand;
import lombok.val;
import org.junit.jupiter.api.Test;

class RestGroupMapperTest {

  private final RestGroupMapper mapper = new RestGroupMapperImpl();

  @Test
  void givenNullGroupIn_whenMapToGroupInCommand_thenShouldRaiseException() {
    //WHEN
    val result = mapper.mapToGroupInCommand(null);

    //THEN
    assertThat(result)
        .isNull();
  }

  @Test
  void givenGroupIn_whenMapToGroupInCommand_thenShouldSuccess() {
    //GIVEN
    val input = getGroupIn();
    val expectedResult = getGroupInCommand();

    //WHEN
    val output = mapper.mapToGroupInCommand(input);

    //THEN
    assertThat(output)
        .extracting(
            GroupInCommand::getId,
            GroupInCommand::getName,
            GroupInCommand::getDescription
        )
        .containsExactly(
            null,
            expectedResult.getName(),
            expectedResult.getDescription()
        );
  }

  @Test
  void givenNullId_whenMapToGroupInCommand_thenShouldBeNull() {
    //WHEN
    val result = mapper.mapToGroupInCommand(null, null);

    //THEN
    assertThat(result)
        .isNull();
  }

  @Test
  void givenGroupInAndId_whenMapToGroupInCommand_thenShouldSuccess() {
    //GIVEN
    val input = getGroupIn();
    val expectedResult = getGroupInCommand();

    //WHEN
    val output = mapper.mapToGroupInCommand(GROUP_ID, input);

    //THEN
    assertThat(output)
        .extracting(
            GroupInCommand::getId,
            GroupInCommand::getName,
            GroupInCommand::getDescription
        )
        .containsExactly(
            expectedResult.getId(),
            expectedResult.getName(),
            expectedResult.getDescription()
        );
  }

  @Test
  void givenNullGroupOutCommand_whenMapToGroupOut_thenShouldRaiseException() {
    //WHEN
    val result = mapper.mapToGroupOut(null);

    //THEN
    assertThat(result)
        .isNull();
  }

  @Test
  void givenGroupOutCommand_whenMapToGroupOut_thenShouldSuccess() {
    //GIVEN
    val input = getGroupOutCommand();
    val expectedResult = getGroupOut();

    //WHEN
    val output = mapper.mapToGroupOut(input);

    //THEN
    assertThat(output)
        .extracting(
            GroupOut::getId,
            GroupOut::getName,
            GroupOut::getDescription,
            GroupOut::getMembers,
            GroupOut::getTasks
        )
        .containsExactly(
            expectedResult.getId(),
            expectedResult.getName(),
            expectedResult.getDescription(),
            expectedResult.getMembers(),
            expectedResult.getTasks()
        );
  }

}
