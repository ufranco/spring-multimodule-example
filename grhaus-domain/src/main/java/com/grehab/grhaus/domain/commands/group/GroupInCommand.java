package com.grehab.grhaus.domain.commands.group;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class GroupInCommand {

  String id;

  String name;

  String description;

}
