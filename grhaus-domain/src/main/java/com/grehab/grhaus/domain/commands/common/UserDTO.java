package com.grehab.grhaus.domain.commands.common;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class UserDTO {
  String username;
}
