package com.grehab.grhaus.apirest.mappers;

import static com.grehab.grhaus.apirest.testUtils.UserUtils.getUserIn;
import static com.grehab.grhaus.apirest.testUtils.UserUtils.getUserInCommand;
import static com.grehab.grhaus.apirest.testUtils.UserUtils.getUserOut;
import static com.grehab.grhaus.apirest.testUtils.UserUtils.getUserOutCommand;
import static org.assertj.core.api.Assertions.assertThat;

import com.grehab.grhaus.apirest.model.UserOut;
import com.grehab.grhaus.domain.commands.user.UserInCommand;
import lombok.val;
import org.junit.jupiter.api.Test;

class RestUserMapperTest {

  private final RestUserMapper mapper = new RestUserMapperImpl();

  @Test
  void givenNullUserIn_whenMapToUserInCommand_thenShouldRaiseException() {
    //WHEN
    val result = mapper.mapToUserInCommand(null);

    //THEN
    assertThat(result)
        .isNull();
  }

  @Test
  void givenUserIn_whenMapToUserInCommand_thenShouldSuccess() {
    //GIVEN
    val input = getUserIn();
    val expectedResult = getUserInCommand();

    //WHEN
    val output = mapper.mapToUserInCommand(input);

    //THEN
    assertThat(output)
        .extracting(
            UserInCommand::getUsername,
            UserInCommand::getGroupId
        )
        .containsExactly(
            expectedResult.getUsername(),
            expectedResult.getGroupId()
        );
  }

  @Test
  void givenNullUserOutCommand_whenMapToUserOut_thenShouldRaiseException() {
    //WHEN
    val result = mapper.mapToUserOut(null);

    //THEN
    assertThat(result)
        .isNull();
  }

  @Test
  void givenUserOutCommand_whenMapToUserOut_thenShouldSuccess() {
    //GIVEN
    val input = getUserOutCommand();
    val expectedResult = getUserOut();

    //WHEN
    val output = mapper.mapToUserOut(input);

    //THEN
    assertThat(output)
        .extracting(
            UserOut::getUsername,
            UserOut::getGroup,
            UserOut::getTasksAssigned
        )
        .containsExactly(
            expectedResult.getUsername(),
            expectedResult.getGroup(),
            expectedResult.getTasksAssigned()
        );
  }

}
