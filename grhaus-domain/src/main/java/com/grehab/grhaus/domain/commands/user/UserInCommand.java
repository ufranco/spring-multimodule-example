package com.grehab.grhaus.domain.commands.user;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class UserInCommand {

  String id;

  String username;

  String groupId;

}
